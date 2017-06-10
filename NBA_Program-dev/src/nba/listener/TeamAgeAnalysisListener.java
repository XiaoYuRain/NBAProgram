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
import nba.model.Team;
import nba.r.R;
import nba.util.NBAComparator;

public class TeamAgeAnalysisListener implements ActionListener {

	  @Override
	  public void actionPerformed(ActionEvent arg0) {
	    double[] nums = new double[100];
	    String[] ages = new String[100];

	    List<Team> teams = Catalog.getInstance().getTeams();
	    NBAComparator<Team> comparator = new NBAComparator<Team>("getAge");
	    teams.sort(comparator);

	    int age = 0;
	    int index = -1;
	  
	    for (Team team : teams) {
		      if (age != team.getAge()) {
		        age = team.getAge();
		        ++index;
		        ages[index] = String.valueOf(age);
		      }
		      ++nums[index];
		    }
	    double[] values = new double[index + 1];
	    String[] keys = new String[index + 1];
	    System.arraycopy(ages, 0, keys, 0, index + 1);
	    System.arraycopy(nums, 0, values, 0, index + 1);
	     
	    JRadioButton btnBar = (JRadioButton) R.getInstance().getObject("btnBarTeam");
	    Diagram b;
	    
	    if(btnBar.isSelected())
	    	 b = DiagramFactory.createDiagram("bar", values, keys, 1, 10);
	    else
	         b = DiagramFactory.createDiagram("pie", values, keys, 1, 10);
        b.setTitle("球队年限分布");
        b.setValueAxisLabel("个数");
	     b.setCategoryAxisLabel("年限");
	    setPanel(b);

	}
	  public void setPanel(Diagram b){
		  JPanel p;
		  JFrame frame = (JFrame)R.getInstance().getObject("AllTeam");
		  p = b.getPanel();
		  p.removeAll();
		  frame.validate();
		  p = b.getPanel();
		  p.setBounds(230,90,600,400);
		  frame.add(p);
	  }
}