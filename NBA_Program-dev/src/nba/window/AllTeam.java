package nba.window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
 
import nba.listener.TeamAgeAnalysisListener;
import nba.listener.TeamGameAnalysisListener;
import nba.listener.TeamWinAnalysisListener;
import nba.r.R;

public class AllTeam extends AbstractPage {

		  private static final long serialVersionUID = 1L;
		  private JButton btnTeamwin_num;
		  private JButton btnTeamgame_num;
		  private JButton btnTeamage;
		  private JRadioButton btnBar;
		  private JRadioButton btnPie;

		  public AllTeam() {
		    super();
		    setTitle("球队整体分析");
		    //setSize(880, 610);
		    Color c = new Color(202, 225, 255);
		    getContentPane().setBackground(c);
		  }

		  protected void regitstComponent() {
			  R.getInstance().registObject("AllTeam", this);
			  R.getInstance().registObject("btnBarTeam", btnBar);
			  R.getInstance().registObject("btnPieTeam", btnPie);
		  }

		  protected void init() {
		    setLayout(null);

		    btnTeamage = new JButton("球队年限分布");
		    btnTeamage.setBounds(60, 120, 140, 60);
		    add(btnTeamage);
		    
		    btnTeamgame_num = new JButton("球队参赛场次分布");
		    btnTeamgame_num.setBounds(60, 240, 140, 60);
		    add(btnTeamgame_num);

		    btnTeamwin_num = new JButton("球队胜利场次分布");
		    btnTeamwin_num.setBounds(60, 360, 140, 60);
		    add(btnTeamwin_num);

		    
		    ButtonGroup bg = new ButtonGroup();

		    btnBar = new JRadioButton("柱状图");
		    btnBar.setBounds(690, 0, 100, 40);
		    btnBar.setFont(new Font("楷体", Font.BOLD, 16));
		    btnBar.setContentAreaFilled(false); // 设为透明色
		    add(btnBar);

		    btnPie = new JRadioButton("扇形图");
		    btnPie.setBounds(770, 0, 100, 40);
		    btnPie.setFont(new Font("楷体", Font.BOLD, 16));
		    btnPie.setContentAreaFilled(false); // 设为透明色
		    add(btnPie);

		    bg.add(btnBar); // 将btnAnalysis btnDetail加入ButtonGroup中
		    bg.add(btnPie);
		    btnBar.setSelected(true);// 默认是整体分析
		    
		    validate();

		  }

		  protected void addListener() {
			  btnTeamgame_num.addActionListener(new TeamGameAnalysisListener());
			  btnTeamage.addActionListener(new TeamAgeAnalysisListener());
			  btnTeamwin_num.addActionListener(new TeamWinAnalysisListener());
		  }
		

}
