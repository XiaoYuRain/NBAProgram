package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import nba.model.Catalog;
import nba.model.Player;
import nba.r.R;

import nba.util.NBASearcher;



public class PlayerDetailListener implements ActionListener {

  private JTextField textinput;

  public void actionPerformed(ActionEvent arg0) {
    R r = R.getInstance();
    textinput = (JTextField) r.getObject("textPlayer");

    if (textinput.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "��������Ա������", "����", JOptionPane.WARNING_MESSAGE);
    } else {
      Player player =
          NBASearcher.find(Catalog.getInstance().getPlayers(), "getName", textinput.getText());
      if (player == null) {
        JOptionPane.showMessageDialog(null, "���޴��ˣ�", "���ҽ��", JOptionPane.PLAIN_MESSAGE);
      } else {
        new PlayerMouseListener().showDetails(player);
      }
    }
  }
}
