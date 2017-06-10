package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;
import nba.model.Catalog;
import nba.model.Player;
import nba.r.R;
import nba.util.NBASearcher;

public class PlayerSpiderListener implements ActionListener {

  private JList<Object> playerList;

  private double max_point;
  private double max_game_num;
  private double min_birth;
  private double max_birth;

  private boolean first = true;

  @SuppressWarnings("unchecked")
  public PlayerSpiderListener() {
    playerList = (JList<Object>) R.getInstance().getObject("playerList");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    String Pname = playerList.getSelectedValue().toString();
    Player player = NBASearcher.find(Catalog.getInstance().getPlayers(), "getName", Pname);

    double point = player.getPoints();
    double game_num = player.getGameNum();
    double birth = player.getBirth();

    if (first) {
      first = false;

      max_point = point;
      max_game_num = game_num;
      max_birth = birth;
      min_birth = birth;
      for (Player p : Catalog.getInstance().getPlayers()) {
        if (p.getBirth() < min_birth) min_birth = p.getBirth();
        if (p.getBirth() > max_birth) max_birth = p.getBirth();
        if (p.getGameNum() > max_game_num) max_game_num = p.getGameNum();
        if (p.getPoints() > max_point) max_point = p.getPoints();
      }
    }

    String[] keys = new String[] {"能力值", "经验值", "潜力值"};
    double[] values =
        new double[] {point / max_point, game_num / max_game_num,
            (birth - min_birth) / (max_birth - min_birth)};
    
    Diagram diagram = DiagramFactory.createDiagram("spider", values, keys);
    diagram.setTitle("球员能力图");
    diagram.draw();
  }
}
