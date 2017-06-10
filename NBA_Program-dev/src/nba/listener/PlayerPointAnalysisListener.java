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

public class PlayerPointAnalysisListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {
    List<Player> players = Catalog.getInstance().getPlayers();
    int[] avgpoints = new int[players.size()];   
    
    for (int index = 0; index < players.size(); ++index) {
    	int game = 0;
    	int point = 0;
        for (Season season : players.get(index).getSeasons()) {
          game += season.getGameNum();
          point += season.getPoint();
        }
        avgpoints[index] = point/game;
    }
    

    //所有得分排序，统计各个分数各有多少人
    Arrays.sort(avgpoints);
    double[] nums = new double[avgpoints.length];
    String[] pointNums = new String[avgpoints.length];

    int pre = -1;
    int index = -1;
    for (int avgpoint : avgpoints) {
      if (pre != avgpoint) {
        pre = avgpoint;
        ++index;
        pointNums[index] = String.valueOf(avgpoint);
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
      b = DiagramFactory.createDiagram("bar", values, keys, 0, 3);
    else
      b = DiagramFactory.createDiagram("pie", values, keys, 0, 3);
    b.setTitle("球员平均得分分布"); 
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("平均得分");
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
