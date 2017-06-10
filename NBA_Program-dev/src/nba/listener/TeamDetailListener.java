package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import nba.model.Catalog;
import nba.model.Team;
import nba.r.R;
import nba.util.NBASearcher;

public class TeamDetailListener implements ActionListener {

  JTextField textinput;

  public void actionPerformed(ActionEvent arg0) {
    R r = R.getInstance();
    textinput = (JTextField) r.getObject("textTeam");

    if (textinput.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "������������֣�", "����", JOptionPane.WARNING_MESSAGE);
    } else {
      Team team =
          NBASearcher.find(Catalog.getInstance().getTeams(), "getName", textinput.getText());

      if (team == null) {
        JOptionPane.showMessageDialog(null, "���޴���ӣ�", "���ҽ��", JOptionPane.PLAIN_MESSAGE);
      } else {
        new TeamMouseListener().showDetails(team);
      }
    }
  }
}
