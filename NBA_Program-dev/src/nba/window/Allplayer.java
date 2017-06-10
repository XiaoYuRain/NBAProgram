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
    setTitle("球员整体分析");
    
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

    btnPlayerAge = new JButton("球员年龄分布");
    btnPlayerAge.setBounds(60, 100, 140, 60);
    add(btnPlayerAge);

    btnPlayerGames = new JButton("球员参赛场次分布");
    btnPlayerGames.setBounds(60, 200, 140, 60);
    add(btnPlayerGames);

    btnPlayerPTS = new JButton("球员平均得分分布");
    btnPlayerPTS.setBounds(60, 300, 140, 60);
    add(btnPlayerPTS);

    btnPlayerSeason = new JButton("球员参赛季度分布");
    btnPlayerSeason.setBounds(60, 400, 140, 60);
    add(btnPlayerSeason);
    
    ButtonGroup bg = new ButtonGroup();

    btnBar = new JRadioButton("柱状图");
    btnBar.setBounds(690, 0, 100, 40);
    btnBar.setFont(new Font("楷体", Font.BOLD, 16));
    btnBar.setContentAreaFilled(false); // 设为透明色
    btnBar.setActionCommand("bar");
    add(btnBar);

    btnPie = new JRadioButton("扇形图");
    btnPie.setBounds(770, 0, 100, 40);
    btnPie.setFont(new Font("楷体", Font.BOLD, 16));
    btnPie.setContentAreaFilled(false); // 设为透明色
    btnPie.setActionCommand("pie");
    add(btnPie);

    bg.add(btnBar); // 将btnAnalysis btnDetail加入ButtonGroup中
    bg.add(btnPie);
    btnBar.setSelected(true);// 默认是柱状图
    
    validate();

  }

  protected void addListener() {
    btnPlayerAge.addActionListener(new PlayerAgeAnalysisListener());
    btnPlayerGames.addActionListener(new PlayerGameAnalysisListener());
    btnPlayerPTS.addActionListener(new PlayerPointAnalysisListener());
    btnPlayerSeason.addActionListener(new PlayerSeasonAnalysisListener());
  }
}
