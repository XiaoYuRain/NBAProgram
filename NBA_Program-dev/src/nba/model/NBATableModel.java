package nba.model;

import javax.swing.table.AbstractTableModel;

public class NBATableModel extends AbstractTableModel {
  private static final long serialVersionUID = 1L;

  private String[] columnNames;
  private Object[][] data;

  public NBATableModel(Object[][] data, String[] columnNames) {
    this.columnNames = columnNames;
    this.data = data;
  }

  public NBATableModel(String[] columnNames) {
    this(new Object[0][0], columnNames);
  }

  public NBATableModel() {
    this(new Object[0][0], new String[0]);
  }

  public String[] getColumnNames() {
    return columnNames;
  }

  public void setColumnNames(String[] columnNames) {
    this.columnNames = columnNames;
  }

  public Object[][] getData() {
    return data;
  }

  public void setData(Object[][] data) {
    this.data = data;
    fireTableDataChanged();
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public int getRowCount() {
    return data.length;
  }

  @Override
  public Object getValueAt(int row, int column) {
    return data[row][column];
  }

}
