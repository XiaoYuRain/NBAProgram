package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import nba.r.R;
import nba.window.AbstractPage;

public class SelectionListener implements ActionListener {

  private Class<AbstractPage> classAnalysis;
  private Class<AbstractPage> classDetail;
  private JRadioButton btnAnalysis;

  @SuppressWarnings({"rawtypes", "unchecked"})
  public SelectionListener(Class classAnalysis, Class classDetail) {
    this.classAnalysis = classAnalysis;
    this.classDetail = classDetail;
    R r = R.getInstance();
    btnAnalysis = (JRadioButton) r.getObject("btnAnalysis");
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    try {
      if (btnAnalysis.isSelected())
        classAnalysis.newInstance().run();
      else
        classDetail.newInstance().run();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

}
