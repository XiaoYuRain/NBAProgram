package nba.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import nba.model.Catalog;

import nba.model.CoachTeam;
import nba.model.NBATableModel;
import nba.model.Team;
import nba.r.R;
import nba.util.NBASearcher;

public class TeamMouseListener implements MouseListener {

  private JTextField textShowTname;
  private JTextField textShowTabbrname;
  private JTextField textTeamBirth;
  private JTextField textTeamAge;
  private JTextField textTeamGame;
  private JTextField textTeamWin;
  private JTextField textTeamChampion;
  private JTable teamCoachTable;
  
  private JButton spiderDiagram;

  public TeamMouseListener() {
    R r = R.getInstance();
    textShowTname = (JTextField) r.getObject("textShowTname");
    textShowTabbrname = (JTextField) r.getObject("textShowTabbrname");
    textTeamBirth = (JTextField) r.getObject("textTeamBirth");
    textTeamAge = (JTextField) r.getObject("textTeamAge");
    textTeamGame = (JTextField) r.getObject("textTeamGame");
    textTeamWin = (JTextField) r.getObject("textTeamWin");
    textTeamChampion = (JTextField) r.getObject("textTeamChampion");
    teamCoachTable = (JTable) r.getObject("teamCoachTable");
    
    spiderDiagram = (JButton) r.getObject("teamSpiderDiagram");
  }

  @SuppressWarnings("rawtypes")
  public void mouseClicked(MouseEvent e) {
    JList TList = (JList) e.getSource();
    if (e.getClickCount() == 2) {
      String Tname = TList.getSelectedValue().toString();

      Team team = NBASearcher.find(Catalog.getInstance().getTeams(), "getName", Tname);
      
      spiderDiagram.setEnabled(true);
      showDetails(team);
    }
  }

  public void showDetails(Team team) {
    textShowTname.setText(team.getName());
    textShowTabbrname.setText(team.getAbbr());
    textTeamBirth.setText(team.getBirth() + "");
    textTeamAge.setText(team.getAge() + "");
    textTeamGame.setText(team.getGameNum() + "");
    textTeamWin.setText(team.getWinNum() + "");
    textTeamChampion.setText(team.getChampNum() + "");

    List<CoachTeam> coachTeams = team.getCoachTeams();

    String[][] data = new String[coachTeams.size()][2];
    for (int i = 0; i < data.length; ++i) {
      CoachTeam c = coachTeams.get(i);
      data[i][0] = c.getCoachName();
      data[i][1] = c.getStartYear() + "-" + c.getEndYear();
    }

    NBATableModel model = (NBATableModel) teamCoachTable.getModel();
    model.setData(data);
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
