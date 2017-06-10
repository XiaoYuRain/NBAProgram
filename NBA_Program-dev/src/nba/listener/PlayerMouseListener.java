package nba.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import nba.model.Catalog;
import nba.model.NBATableModel;
import nba.model.Player;
import nba.model.Season;
import nba.r.R;
import nba.util.NBASearcher;

public class PlayerMouseListener implements MouseListener {
  private JTextField playerNameTx;
  private JTextField playerBirthTx;
  private JTable playerTable;
  private JButton spiderDiagram;

  public PlayerMouseListener() {
    R r = R.getInstance();
    playerNameTx = (JTextField) r.getObject("playerNameTx");
    playerBirthTx = (JTextField) r.getObject("playerBirthTx");
    playerTable = (JTable) r.getObject("playerTable");
    spiderDiagram = (JButton) r.getObject("spiderDiagram");
  }

  @SuppressWarnings("rawtypes")
  @Override
  public void mouseClicked(MouseEvent e) {
    JList PList = (JList) e.getSource();
    if (e.getClickCount() == 2) {
      String Pname = PList.getSelectedValue().toString();
      Player player = NBASearcher.find(Catalog.getInstance().getPlayers(), "getName", Pname);

      spiderDiagram.setEnabled(true);
      showDetails(player);
    }
  }

  public void showDetails(Player player) {
    setPlayerName(player);
    setPlayerBirth(player);
    fillTable(player);
  }

  private void setPlayerName(Player player) {
    playerNameTx.setText(player.getName());
  }

  private void setPlayerBirth(Player player) {
    String str = player.getBirth() + "";
    playerBirthTx.setText(str);
  }

  private void fillTable(Player player) {
    List<Season> seasons = player.getSeasons();

    String[][] data = new String[seasons.size()][4];
    for (int i = 0; i < data.length; ++i) {
      Season s = seasons.get(i);
      data[i][0] = s.getYear() - 1 + "-" + s.getYear();
      data[i][1] = s.getGameNum() + "";
      data[i][2] = s.getPoint() + "";
      data[i][3] = s.getTeamAbbr();
    }

    NBATableModel model = (NBATableModel) playerTable.getModel();
    model.setData(data);
  }

  @Override
  public void mouseEntered(MouseEvent arg0) {}

  @Override
  public void mouseExited(MouseEvent arg0) {}

  @Override
  public void mousePressed(MouseEvent arg0) {}

  @Override
  public void mouseReleased(MouseEvent arg0) {}
}
