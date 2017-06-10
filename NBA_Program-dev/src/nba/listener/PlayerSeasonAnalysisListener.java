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
import nba.model.Season;
import nba.r.R;
import nba.util.NBAComparator;

public class PlayerSeasonAnalysisListener implements ActionListener {
	
	@Override
    public void actionPerformed(ActionEvent arg0) {
      
      double[] nums = new double[100];
      String[] years = new String[100];

      List<Season> seasons = Catalog.getInstance().getSeasons();
      NBAComparator<Season> comparator = new NBAComparator<Season>("getYear");
      seasons.sort(comparator);

      int year = 0;
      int index = -1;
      for (Season season : seasons) {
        if (year != season.getYear()) {
          year = season.getYear();
          ++index;
          years[index] = String.valueOf(year);
        }
        ++nums[index];
      }

      double[] values = new double[index + 1];
      String[] keys = new String[index + 1];
      System.arraycopy(years, 0, keys, 0, index + 1);
      System.arraycopy(nums, 0, values, 0, index + 1);
       
      JRadioButton btnBar = (JRadioButton) R.getInstance().getObject("btnBar");
      Diagram b;
      
      if(btnBar.isSelected())
    	  b = DiagramFactory.createDiagram("bar", values, keys, 1946, 10);
      else
      	  b = DiagramFactory.createDiagram("pie", values, keys, 1946, 10);
      b.setTitle("球员参赛季度分布");
      b.setValueAxisLabel("个数");
	     b.setCategoryAxisLabel("参赛季度");
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
