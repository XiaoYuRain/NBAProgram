package nba.window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import nba.listener.ArenaAgeAnalysisListener;
import nba.listener.ArenaCapacityAnalysisListener;
import nba.r.R;

public class AllArena extends AbstractPage {

	  private static final long serialVersionUID = 1L;
	  private JButton btnCapacity;
	  private JButton btnArenaAge;
	  private JRadioButton btnBar;
	  private JRadioButton btnPie;

	  public AllArena() {
	    super();
	    setTitle("�������������");
	  
	    Color c = new Color(202, 225, 255);
	    getContentPane().setBackground(c);
	  }

	  protected void regitstComponent() {
		  R.getInstance().registObject("AllArena", this);
		  R.getInstance().registObject("btnBarArena", btnBar);
		  R.getInstance().registObject("btnPieArena", btnPie);
	  }

	  protected void init() {
		  setLayout(null);
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
	        btnBar.setSelected(true);// Ĭ�����������
	        
	        btnArenaAge = new JButton("������ʹ������");
	        btnArenaAge.setBounds(60, 120, 145, 60);
	        add( btnArenaAge);
	        
	        btnCapacity = new JButton("�����������ֲ�");
	        btnCapacity.setBounds(60,320,145,60);
	        add(btnCapacity);
	        
	        validate();
	        
	  }

	  protected void addListener() {
		  btnArenaAge.addActionListener(new ArenaAgeAnalysisListener());
		  btnCapacity.addActionListener(new ArenaCapacityAnalysisListener());
	  }
	}
