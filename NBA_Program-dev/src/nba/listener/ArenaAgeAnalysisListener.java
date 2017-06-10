package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nba.diagram.Diagram;
import nba.diagram.DiagramFactory;

import nba.model.ArenaTeam;
import nba.model.Catalog;

import nba.r.R;
import nba.util.NBAComparator;

public class ArenaAgeAnalysisListener implements ActionListener {

	  @Override
	  public void actionPerformed(ActionEvent arg0) {
	    Catalog catalog = Catalog.getInstance();
	    List<ArenaTeam> arenaTeams = catalog.getArenaTeams();

	    NBAComparator<ArenaTeam> comparator = // 按成立年份从大到小排序
	        new NBAComparator<ArenaTeam>("getStartYear", NBAComparator.FROM_BIG);
	    arenaTeams.sort(comparator);

	    int index = -1;
	    int startYear = 0;
	    double[] num = new double[200];
	    String[] age = new String[200];
	

	    for (ArenaTeam arenaTeam : arenaTeams) { // 统计所有体育场年限分布
		      if (startYear != arenaTeam.getStartYear()) {
		    	  startYear = arenaTeam.getStartYear();
		        ++index;
		        age[index] = String.valueOf(2017 - startYear);
		      }
		      ++num[index]; 
		    }

	    double[] values = new double[index + 1];
	    String[] keys = new String[index + 1];

	   
	    System.arraycopy(age, 0, keys, 0, index + 1);
	    System.arraycopy(num, 0, values, 0, index + 1);
	    
	    Diagram b;
	    JRadioButton btnBar = (JRadioButton) R.getInstance().getObject("btnBarArena");
	    
	    if(btnBar.isSelected())
	    {
	          b = DiagramFactory.createDiagram("bar", values, keys, 1, 10); 
	    }
	    else  b = DiagramFactory.createDiagram("pie", values, keys, 1, 10);
	    
	     b.setTitle("体育场使用年限");
	     b.setValueAxisLabel("个数");
	     b.setCategoryAxisLabel("年限");
	     setPanel(b);

 
	  }
	  public void setPanel(Diagram b){
		  JPanel p;
		  JFrame frame = (JFrame)R.getInstance().getObject("AllArena");
		  p = b.getPanel();
		  p.removeAll();
		  frame.validate();
		  p = b.getPanel();
		  p.setBounds(230,90,600,400);
		  frame.add(p);
	  }
}

