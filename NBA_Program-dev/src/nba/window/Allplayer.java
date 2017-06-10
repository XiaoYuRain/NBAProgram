package nba.window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import nba.listener.PlayerAgeAnalysisListener;
import nba.listener.PlayerGameAnalysisListener;
import nba.listener.PlayerPointAnalysisListener;
import nba.listener.PlayerSeasonAnalysisListener;
import nba.r.R;

public class Allplayer extends AbstractPage {

  private static final long serialVersionUID = 1L;
  private JButton btnPlayerAge;
  private JButton btnPlayerGames;
  private JButton btnPlayerPTS;
  private JButton btnPlayerSeason;
  private JRadioButton btnBar;
  private JRadioButton btnPie;

  public Allplayer() {
    super();
    setTitle("��Ա�������");
    
    Color c = new Color(202, 225, 255);
    getContentPane().setBackground(c);
  }

  protected void regitstComponent() {
	  R.getInstance().registObject("AllPlayer", this);
	  R.getInstance().registObject("btnBar", btnBar);
	  R.getInstance().registObject("btnPie", btnPie);
  }

  protected void init() {
    setLayout(null);

    btnPlayerAge = new JButton("��Ա����ֲ�");
    btnPlayerAge.setBounds(60, 100, 140, 60);
    add(btnPlayerAge);

    btnPlayerGames = new JButton("��Ա�������ηֲ�");
    btnPlayerGames.setBounds(60, 200, 140, 60);
    add(btnPlayerGames);

    btnPlayerPTS = new JButton("��Աƽ���÷ֲַ�");
    btnPlayerPTS.setBounds(60, 300, 140, 60);
    add(btnPlayerPTS);

    btnPlayerSeason = new JButton("��Ա�������ȷֲ�");
    btnPlayerSeason.setBounds(60, 400, 140, 60);
    add(btnPlayerSeason);
    
    ButtonGroup bg = new ButtonGroup();

    btnBar = new JRadioButton("��״ͼ");
    btnBar.setBounds(690, 0, 100, 40);
    btnBar.setFont(new Font("����", Font.BOLD, 16));
    btnBar.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    btnBar.setActionCommand("bar");
    add(btnBar);

    btnPie = new JRadioButton("����ͼ");
    btnPie.setBounds(770, 0, 100, 40);
    btnPie.setFont(new Font("����", Font.BOLD, 16));
    btnPie.setContentAreaFilled(false); // ��Ϊ͸��ɫ
    btnPie.setActionCommand("pie");
    add(btnPie);

    bg.add(btnBar); // ��btnAnalysis btnDetail����ButtonGroup��
    bg.add(btnPie);
    btnBar.setSelected(true);// Ĭ������״ͼ
    
    validate();

  }

  protected void addListener() {
    btnPlayerAge.addActionListener(new PlayerAgeAnalysisListener());
    btnPlayerGames.addActionListener(new PlayerGameAnalysisListener());
    btnPlayerPTS.addActionListener(new PlayerPointAnalysisListener());
    btnPlayerSeason.addActionListener(new PlayerSeasonAnalysisListener());
  }
}
