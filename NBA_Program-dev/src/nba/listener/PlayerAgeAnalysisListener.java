package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;
import nba.model.Catalog;
import nba.model.Player;
import nba.r.R;
import nba.util.NBAComparator;

public class PlayerAgeAnalysisListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent arg0) {
    Catalog catalog = Catalog.getInstance();
    List<Player> players = catalog.getPlayers();

    NBAComparator<Player> comparator = // 按生日从大到小排序
        new NBAComparator<Player>("getBirth", NBAComparator.FROM_BIG);
    players.sort(comparator);

    int index = -1;
    int birth = 0;
    double[] num = new double[200];
    String[] age = new String[200];
    for (Player player : players) { // 统计所有球员年龄分布
      if (birth != player.getBirth()) {
        birth = player.getBirth();
        ++index;
        age[index] = String.valueOf(2017 - birth);
      }
      ++num[index];
    }


    double[] values = new double[index + 1];
    String[] keys = new String[index + 1];

   
    System.arraycopy(age, 0, keys, 0, index + 1);
    System.arraycopy(num, 0, values, 0, index + 1);
    
     
    JRadioButton btnBar = (JRadioButton) R.getInstance().getObject("btnBar");
    Diagram b;
    
    if(btnBar.isSelected())
    	 b = DiagramFactory.createDiagram("bar", values, keys, 21, 10);
 
    else
         b = DiagramFactory.createDiagram("pie", values, keys, 21, 10);
    b.setTitle("球员年限分布");
    b.setValueAxisLabel("个数");
    b.setCategoryAxisLabel("年龄");
    setPanel(b);
    }
  public void setPanel(Diagram b){
	  JPanel p;
	  JFrame frame = (JFrame)R.getInstance().getObject("AllPlayer");
	  p = b.getPanel();
	  p.setBounds(300,100,500,300);
	  frame.add(p);
  }

}