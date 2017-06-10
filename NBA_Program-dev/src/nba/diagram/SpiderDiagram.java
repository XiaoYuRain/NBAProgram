package nba.diagram;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;

public class SpiderDiagram extends Diagram {

  public SpiderDiagram(double[] values, String[] keys) {
    super(values, keys);
  }

  @Override
  protected JFreeChart createDiagram() {
    SpiderWebPlot spiderwebplot = new MySpiderWebPlot(super.categoryDataset);
    return new JFreeChart(super.title, spiderwebplot);
  }
  
  @Override
  public void setCategoryDataset(double[] values, String[] keys) {
    super.setCategoryDataset(values, keys);
    
    for (int i = 0; i < values.length; ++i) {
      categoryDataset.addValue(1, "another", keys[i]);
    }
  }
}
