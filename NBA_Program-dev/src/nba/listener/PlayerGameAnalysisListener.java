package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;
import nba.model.Catalog;
import nba.model.Player;
import nba.model.Season;
import nba.r.R;

public class PlayerGameAnalysisListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {
    List<Player> players = Catalog.getInstance().getPlayers();
    int[] games = new int[players.size()];

    //累加所有球员各自的场次数
    for (int index = 0; index < players.size(); ++index) {
      int game = 0;
      for (Season season : players.get(index).getSeasons()) {
        game += season.getGameNum();
      }
      games[index] = game;
    }

    //所有得分排序，统计各个分数各有多少人
    Arrays.sort(games);
    double[] nums = new double[games.length];
    String[] pointNums = new String[games.length];

    int pre = -1;
    int index = -1;
    for (int game : games) {
      if (pre != game) {
        pre = game;
        ++index;
        pointNums[index] = String.valueOf(game);
      }
      ++nums[index];
    }

    double[] values = new double[index + 1];
    String[] keys = new String[index + 1];
    System.arraycopy(pointNums, 0, keys, 0, index + 1);
    System.arraycopy(nums, 0, values, 0, index + 1);
   
  
    JRadioButton btnBar = (JRadioButton) R.getInstance().getObject("btnBar");
    Diagram b;
    
    if(btnBar.isSelected())
      b = DiagramFactory.createDiagram("bar", values, keys, 1, 100);
    else
      b = DiagramFactory.createDiagram("pie", values, keys, 1, 100);
    b.setTitle("球员参赛场次分布");
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("参赛场次");
    setPanel(b);
  }
  public void setPanel(Diagram b){
	  JPanel p;
	  JFrame frame = (JFrame)R.getInstance().getObject("AllPlayer");
	  p = b.getPanel();
	  p.removeAll();
	  frame.validate();
	  p = b.getPanel();
	  p.setBounds(230,90,600,400);
	  frame.add(p);
  }

}
