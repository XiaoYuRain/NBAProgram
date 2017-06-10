package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import nba.model.Catalog;
import nba.model.Coach;
import nba.r.R;
import nba.util.NBASearcher;


public class CoachDetailListener implements ActionListener {

  private JTextField textinput;

  public void actionPerformed(ActionEvent arg0) {
    R r = R.getInstance();
    textinput = (JTextField) r.getObject("textCoach");

    if (textinput.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "���������������", "����", JOptionPane.WARNING_MESSAGE);
    } else {
      Coach coach =
          NBASearcher.find(Catalog.getInstance().getCoachs(), "getName", textinput.getText());

      if (coach == null) {
        JOptionPane.showMessageDialog(null, "���޴��ˣ�", "���ҽ��", JOptionPane.PLAIN_MESSAGE);
      } else {
        new CoachMouseListener().showDetails(coach);
      }
    }
  }
}
