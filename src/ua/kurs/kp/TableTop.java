package ua.kurs.kp;

import javax.swing.table.AbstractTableModel;

class TableTop extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] columnNames ; 
    private Object[][] data ;
    
    public TableTop(Object[][] data){
        columnNames = new String[data[0].length]; 
        this.data = data;
    }
    
    public TableTop(int rows,int columns){
        columnNames = new String[columns];
        //columnNames[0] = "¹";
        columnNames[0] = "Fruit";
        columnNames[1] = "Sold";
        data = new Object[rows][columns];
        
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++){
                data[i][j] = "";
            }        
    } 
 
    public int getColumnCount() {
        return columnNames.length;
    }
 
    public int getRowCount() {
        return data.length;
    }
 
    public String getColumnName(int col) {
    	return columnNames[col];
    }
 
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
 
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
 
   /* public boolean isCellEditable(int row, int col) {
        return true;
    }*/
 
    public void setValueAt(Object value, int row, int col) {
    }
}
