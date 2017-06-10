package nba.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import nba.model.Arena;
import nba.model.ArenaTeam;
import nba.model.Catalog;
import nba.model.Location;
import nba.model.NBATableModel;
import nba.r.R;
import nba.util.NBASearcher;

public class ArenaMouseListener implements MouseListener {
  private JTextField arenaNameTx;
  private JTable arenaLocationTable;
  private JTable arenaTeamTable;

  public ArenaMouseListener() {
    R r = R.getInstance();
    arenaNameTx = (JTextField) r.getObject("ArenaNameTx");
    arenaLocationTable = (JTable) r.getObject("arenaLocationTable");
    arenaTeamTable = (JTable) r.getObject("arenaTeamTable");
  }

  @SuppressWarnings("rawtypes")
  @Override
  public void mouseClicked(MouseEvent e) {
    JList ArenaList = (JList) e.getSource();
    if (e.getClickCount() == 2) {
      String Aname = ArenaList.getSelectedValue().toString();
      Arena arena = NBASearcher.find(Catalog.getInstance().getArenas(), "getName", Aname);

      showDetails(arena);
    }
  }

  public void showDetails(Arena arena) {
    setArenaName(arena);
    LocationTable(arena);
    ArenaTeamTable(arena);
  }

  private void setArenaName(Arena arena) {
    arenaNameTx.setText(arena.getName());
  }

  private void LocationTable(Arena arena) {
    List<Location> Location = arena.getLocations();

    String[][] data = new String[Location.size()][3];
    for (int i = 0; i < data.length; ++i) {
      Location loc = Location.get(i);
      data[i][0] = loc.getStartYear() + "-" + loc.getEndYear();
      data[i][1] = loc.getName();
      data[i][2] = loc.getCapacity() + "";
    }

    NBATableModel model = (NBATableModel) arenaLocationTable.getModel();
    model.setData(data);
  }

  private void ArenaTeamTable(Arena arena) {
    List<ArenaTeam> ArenaTeam = arena.getArenaTeams();

    String[][] data = new String[ArenaTeam.size()][2];
    for (int i = 0; i < data.length; ++i) {
      ArenaTeam atm = ArenaTeam.get(i);
      data[i][0] = atm.getStartYear() + "-" + atm.getEndYear();
      data[i][1] = atm.getTeamName();
    }

    NBATableModel model = (NBATableModel) arenaTeamTable.getModel();
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
