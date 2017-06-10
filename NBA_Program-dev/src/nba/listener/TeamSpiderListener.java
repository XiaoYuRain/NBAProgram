package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;
import nba.model.Catalog;
import nba.model.Team;
import nba.r.R;
import nba.util.NBASearcher;

public class TeamSpiderListener implements ActionListener {

  private JList<Team> teamList;

  private boolean first = true;

  private double max_game_num;
  private double max_win_num;
  private double max_age;
  private double max_champ_num;
  private double max_ratio;

  @SuppressWarnings("unchecked")
  public TeamSpiderListener() {
    teamList = (JList<Team>) R.getInstance().getObject("teamList");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    String Tname = teamList.getSelectedValue().toString();
    Team team = NBASearcher.find(Catalog.getInstance().getTeams(), "getName", Tname);

    double game_num = team.getGameNum();
    double age = team.getAge();
    double win_num = team.getWinNum();
    double champ_num = team.getChampNum();
    double ratio = win_num / game_num;

    if (first) {
      first = false;

      max_win_num = win_num;
      max_game_num = game_num;
      max_champ_num = champ_num;
      max_ratio = ratio;
      max_age = age;

      for (Team t : Catalog.getInstance().getTeams()) {
        if (t.getWinNum() > max_win_num) max_win_num = t.getWinNum();
        if (t.getChampNum() > max_champ_num) max_champ_num = t.getChampNum();
        if (t.getGameNum() > max_game_num) max_game_num = t.getGameNum();
        if (t.getAge() > max_age) max_age = t.getAge();
        if (t.getWinNum() * 1.0 / t.getGameNum() > max_ratio)
          max_ratio = t.getWinNum() * 1.0 / t.getGameNum();
      }
    }

    String[] keys = new String[] {"能力值", "经验值", "潜力值", "胜利值", "冠军值"};
    double[] values =
        new double[] {ratio / max_ratio, game_num / max_game_num, age / max_age,
            win_num / max_win_num, champ_num / max_champ_num};

    Diagram diagram = DiagramFactory.createDiagram("spider", values, keys);
    diagram.draw();
  }

}
