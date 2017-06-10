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
import nba.model.Location;
import nba.r.R;
import nba.util.NBAComparator;

public class ArenaCapacityAnalysisListener implements ActionListener {
		
		@Override
	    public void actionPerformed(ActionEvent arg0) {
	      
	      double[] nums = new double[100];
	      String[] capacities = new String[100];

	      List<Location> locations = Catalog.getInstance().getLocations();
	      NBAComparator<Location> comparator = new NBAComparator<Location>("getCapacity");
	      locations.sort(comparator);

	      int capacity = 0;
	      int index = -1;
	      for (Location location : locations) {
	        if (capacity != location.getCapacity()) {
	          capacity = location.getCapacity();
	          ++index;
	          capacities[index] = String.valueOf(capacity);
	        }
	        ++nums[index];
	      }

	      double[] values = new double[index + 1];
	      String[] keys = new String[index + 1];
	      System.arraycopy(capacities, 0, keys, 0, index + 1);
	      System.arraycopy(nums, 0, values, 0, index + 1);
	      
	      Diagram b;
		  JRadioButton btnBar = (JRadioButton) R.getInstance().getObject("btnBarArena");
		    
		  if(btnBar.isSelected())
		  {
		      b = DiagramFactory.createDiagram("bar", values, keys, 1, 1000); 
		  }
		  else  b = DiagramFactory.createDiagram("pie", values, keys, 1, 1000);
		  
		  b.setTitle("体育场容量");
		  b.setValueAxisLabel("个数");
		     b.setCategoryAxisLabel("容纳人数");
		  setPanel(b);
	    }
		
		 public void setPanel(Diagram b){
			  JPanel p;
			  JFrame frame = (JFrame)R.getInstance().getObject("AllArena");
			  p=b.getPanel();
			  p.removeAll();
			  frame.validate();
			  p = b.getPanel();
			  p.setBounds(230,90,600,400);
			  frame.add(p);
		  }
}
