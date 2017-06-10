package nba.window;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

import nba.r.R;
import nba.listener.PlayerDetailListener;
import nba.listener.PlayerMouseListener;
import nba.listener.PlayerSpiderListener;
import nba.model.Catalog;
import nba.model.NBATableModel;
import nba.model.Player;

import java.util.List;

public class EachPlayer extends AbstractPage {
  private static final long serialVersionUID = 1L;

  private JTextField textPlayer;// 输入搜索内容
  private JButton btnEnsure;// "确定搜索"按钮
  private List<Player> players;
  private JTextField playerNameTx;
  private JTextField playerBirthTx;
  private JList<Object> playerList;
  private JTable playerTable;
  
  private JButton spiderDiagram;//查看蜘蛛图按钮

  @Override
  protected void initPage() {
    super.initPage();
    setTitle("球员详细信息");
    setSize(880, 610);// TODO

    setLayout(null);
  }

  protected void init() {
    JLabel searchLabel = new JLabel("搜索：");
    searchLabel.setBounds(20, 20, 50, 50);
    add(searchLabel);

    textPlayer = new JTextField(58);
    textPlayer.setBounds(60, 35, 655, 25);
    add(textPlayer);

    btnEnsure = new JButton("确定");
    btnEnsure.setBounds(745, 33, 65, 26);
    getRootPane().setDefaultButton(btnEnsure);
    add(btnEnsure);
    
    spiderDiagram = new JButton("查看蜘蛛图");
    spiderDiagram.setBounds(700, 120,100,30);
    spiderDiagram.setEnabled(false);
    add(spiderDiagram);

    addPlayerJlist();// 添加球员名单

    JLabel name = new JLabel("球 员 名 字 ： ");
    name.setBounds(380, 85, 90, 50);
    add(name);

    playerNameTx = new JTextField();
    playerNameTx.setEditable(false);
    playerNameTx.setBounds(460, 98, 150, 25);
    add(playerNameTx);

    JLabel birth = new JLabel("出 生 年 份 ： ");
    birth.setBounds(380, 135, 90, 50);
    add(birth);

    playerBirthTx = new JTextField();
    playerBirthTx.setEditable(false);
    playerBirthTx.setBounds(460, 150, 150, 25);
    add(playerBirthTx);

    JLabel gameInformation = new JLabel("参 赛 信 息 ： ");
    gameInformation.setBounds(380, 185, 90, 50);
    add(gameInformation);

    String[] columnNames = {"赛季", "参赛场次", "得分", "所属球队缩写"};
    NBATableModel model = new NBATableModel(columnNames);
    playerTable = new JTable(model);
    playerTable.setRowSorter(new TableRowSorter<NBATableModel>(model));
    JScrollPane JSP = new JScrollPane(playerTable);
    JSP.setBounds(460, 200, 360, 300);
    add(JSP);
  }

  public void addPlayerJlist() {
    players = Catalog.getInstance().getPlayers();

    playerList = new JList<Object>(players.toArray());
    JScrollPane JScrollPane = new JScrollPane(playerList);
    JScrollPane.setBounds(60, 85, 220, 420);
    add(JScrollPane);
  }

  @Override
  protected void addListener() {
    btnEnsure.addActionListener(new PlayerDetailListener());
    playerList.addMouseListener(new PlayerMouseListener());
    spiderDiagram.addActionListener(new PlayerSpiderListener());
  }

  @Override
  protected void regitstComponent() {
    R.getInstance().registObject("textPlayer", textPlayer);
    R.getInstance().registObject("playerNameTx", playerNameTx);
    R.getInstance().registObject("playerBirthTx", playerBirthTx);
    R.getInstance().registObject("playerTable", playerTable);
    R.getInstance().registObject("spiderDiagram", spiderDiagram);
    R.getInstance().registObject("playerList", playerList);
  }
}
