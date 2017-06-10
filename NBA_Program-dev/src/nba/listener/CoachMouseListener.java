package nba.listener;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JList;

import javax.swing.JTable;
import javax.swing.JTextField;

import nba.model.Catalog;
import nba.model.Coach;
import nba.model.CoachTeam;
import nba.model.NBATableModel;
import nba.r.R;
import nba.util.NBASearcher;

public class CoachMouseListener implements MouseListener {
  private JTextField coachNameTx;
  private JTable coachTeamTable;

  public CoachMouseListener() {
    R r = R.getInstance();

    coachNameTx = (JTextField) r.getObject("textShowCname");
    coachTeamTable = (JTable) r.getObject("coachTeamTable");
  }

  @SuppressWarnings("rawtypes")
  public void mouseClicked(MouseEvent e) {
    JList CList = (JList) e.getSource();
    if (e.getClickCount() == 2) {
      String Cname = CList.getSelectedValue().toString();
      Coach coach = NBASearcher.find(Catalog.getInstance().getCoachs(), "getName", Cname);

      showDetails(coach);
    }
  }

  public void showDetails(Coach coach) {
    setCoachName(coach);
    fillCoachTeamTable(coach);
  }

  private void fillCoachTeamTable(Coach coach) {
    List<CoachTeam> coachTeams = coach.getCoachTeams();

    String[][] data = new String[coachTeams.size()][2];
    for (int i = 0; i < data.length; ++i) {
      CoachTeam s = coachTeams.get(i);
      data[i][0] = s.getStartYear() + "-" + s.getEndYear();
      data[i][1] = s.getTeamName();
    }

    NBATableModel model = (NBATableModel) coachTeamTable.getModel();
    model.setData(data);
  }

  private void setCoachName(Coach coach) {
    coachNameTx.setText(coach.getName());
  }

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}
