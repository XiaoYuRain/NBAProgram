package nba.window;


import java.util.List;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

import nba.listener.CoachDetailListener;
import nba.listener.CoachMouseListener;

import nba.model.Catalog;
import nba.model.Coach;
import nba.model.NBATableModel;

import nba.r.R;


public class EachCoach extends AbstractPage {

  private static final long serialVersionUID = 1L;

  private JTextField textCoach;// ������������
  private JButton btnEnsure;// "ȷ������"��ť
  private JTextField textShowCname; // ��ʾ��������
  private JList<Object> coachJlist;
  private List<Coach> coachs;
  private JTable coachTeamTable;

  @Override
  public void initPage() {
    super.initPage();
    setTitle("������ϸ��Ϣ");

    setLayout(null);
  }

  @Override
  protected void init() {
    JLabel search = new JLabel("������");
    search.setBounds(20, 20, 50, 50);
    add(search);

    textCoach = new JTextField(58);
    textCoach.setBounds(60, 35, 655, 25);
    add(textCoach);

    btnEnsure = new JButton("ȷ��");
    btnEnsure.setBounds(745, 33, 65, 26);
    getRootPane().setDefaultButton(btnEnsure);
    add(btnEnsure);

    JLabel coachName = new JLabel("����������");
    coachName.setBounds(420, 85, 90, 50);
    add(coachName);

    textShowCname = new JTextField(40);
    textShowCname.setBounds(490, 97, 150, 25);
    textShowCname.setEditable(false);
    add(textShowCname);

    JLabel teach = new JLabel("ִ�������");
    teach.setBounds(420, 140, 90, 50);
    add(teach);

    String[] columnNames = {"ִ�����", "ִ�����"};
    NBATableModel model = new NBATableModel(columnNames);
    coachTeamTable = new JTable(model);
    coachTeamTable.setRowSorter(new TableRowSorter<NBATableModel>(model));
    JScrollPane JspCtable = new JScrollPane(coachTeamTable);
    JspCtable.setBounds(420, 190, 400, 300);
    add(JspCtable);

    addCoachJlist();
  }

  public void addCoachJlist() {
    coachs = Catalog.getInstance().getCoachs();

    coachJlist = new JList<Object>(coachs.toArray());
    JScrollPane JScrollPane = new JScrollPane(coachJlist);
    JScrollPane.setBounds(60, 85, 220, 420);
    add(JScrollPane);
  }

  @Override
  protected void addListener() {
    btnEnsure.addActionListener(new CoachDetailListener());
    coachJlist.addMouseListener(new CoachMouseListener());
  }

  @Override
  protected void regitstComponent() {
    R.getInstance().registObject("textCoach", textCoach);
    R.getInstance().registObject("textShowCname", textShowCname);
    R.getInstance().registObject("coachTeamTable", coachTeamTable);
  }
}
