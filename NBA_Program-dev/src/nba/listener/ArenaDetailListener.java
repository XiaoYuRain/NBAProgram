package nba.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import javax.swing.JTextField;

import nba.model.Arena;
import nba.model.Catalog;

import nba.r.R;
import nba.util.NBASearcher;

public class ArenaDetailListener implements ActionListener {
  private JTextField textinput;

  public void actionPerformed(ActionEvent arg0) {
    R r = R.getInstance();
    textinput = (JTextField) r.getObject("textArena");

    if (textinput.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "���������������֣�", "����", JOptionPane.WARNING_MESSAGE);
    } else {
      Arena arena =
          NBASearcher.find(Catalog.getInstance().getArenas(), "getName", textinput.getText());
      if (arena == null) {
        JOptionPane.showMessageDialog(null, "���޴���������", "���ҽ��", JOptionPane.PLAIN_MESSAGE);
      } else {
        new ArenaMouseListener().showDetails(arena);
      }
    }
  }
}
