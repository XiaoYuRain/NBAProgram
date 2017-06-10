package nba.window;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import nba.listener.ArenaDetailListener;
import nba.listener.ArenaMouseListener;
import nba.model.Arena;
import nba.model.Catalog;
import nba.model.NBATableModel;
import nba.r.R;

public class EachArena extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JTextField textArena;// ������������
  private JButton btnEnsure;// "ȷ������"��ť
  private JTextField arenaNameTx;
  private List<Arena> arenas;
  private JList<Object> arenaList;
  private JTable arenaLocationTable;
  private JTable arenaTeamTable;

  @Override
  protected void initPage() {
    super.initPage();
    setTitle("��������ϸ��Ϣ");

    setLayout(null);
  }

  @Override
  protected void init() {
    JLabel searchLabel = new JLabel("������");
    searchLabel.setBounds(20, 20, 50, 50);
    add(searchLabel);

    textArena = new JTextField(58);
    textArena.setBounds(60, 35, 655, 25);
    add(textArena);

    btnEnsure = new JButton("ȷ��");
    btnEnsure.setBounds(745, 33, 65, 26);
    getRootPane().setDefaultButton(btnEnsure);
    add(btnEnsure);

    addArenaJlist(); // ����������б�

    JLabel ArenaName = new JLabel("���������� ��");
    ArenaName.setBounds(380, 85, 90, 50);
    add(ArenaName);

    arenaNameTx = new JTextField();
    arenaNameTx.setEditable(false);
    arenaNameTx.setBounds(470, 98, 150, 25);
    add(arenaNameTx);

    JLabel ArenaLocation = new JLabel("λ �� �� Ϣ ��");
    ArenaLocation.setBounds(380, 130, 90, 50);
    add(ArenaLocation);

    String[] columnNames = {"ʹ�����", "���ڵ�", "����"};
    NBATableModel locationModel = new NBATableModel(columnNames);
    arenaLocationTable = new JTable(locationModel);
    arenaLocationTable.setRowSorter(new TableRowSorter<NBATableModel>(locationModel));
    JScrollPane JSP = new JScrollPane(arenaLocationTable);
    JSP.setBounds(470, 150, 360, 100);
    add(JSP);

    JLabel ArenaTeam = new JLabel("�� �� �� �� ��");
    ArenaTeam.setBounds(380, 280, 90, 50);
    add(ArenaTeam);

    columnNames = new String[] {"ʹ�����", "�������"};
    NBATableModel teamModel = new NBATableModel(columnNames);
    arenaTeamTable = new JTable(teamModel);
    arenaTeamTable.setRowSorter(new TableRowSorter<NBATableModel>(teamModel));
    JScrollPane JSP2 = new JScrollPane(arenaTeamTable);
    JSP2.setBounds(470, 300, 360, 200);
    add(JSP2);
  }

  private void addArenaJlist() {
    arenas = Catalog.getInstance().getArenas();

    arenaList = new JList<Object>(arenas.toArray());
    JScrollPane JScrollPane = new JScrollPane(arenaList);
    JScrollPane.setBounds(60, 85, 230, 420);
    add(JScrollPane);
  }

  @Override
  protected void addListener() {
    btnEnsure.addActionListener(new ArenaDetailListener());
    arenaList.addMouseListener(new ArenaMouseListener());
  }

  @Override
  protected void regitstComponent() {
    R.getInstance().registObject("textArena", textArena);
    R.getInstance().registObject("ArenaNameTx", arenaNameTx);
    R.getInstance().registObject("arenaLocationTable", arenaLocationTable);
    R.getInstance().registObject("arenaTeamTable", arenaTeamTable);
  }

}
