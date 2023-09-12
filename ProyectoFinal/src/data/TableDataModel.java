/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logic.ManagePerson;
import logic.MyTableModelListener;

/**
 *
 * @author JRivera
 */
public class TableDataModel extends AbstractTableModel {

    Object[][] data;
    String[] titles;

    public TableDataModel(Object[][] data, String[] titles) {
        this.data = data;
        this.titles = titles;
        addTableModelListener(new MyTableModelListener(data));
    }

    public TableDataModel(ArrayList<Person> pList,String[] titles) {
        data = new Object[pList.size()][6];
        Person p;
        for (int i = 0; i < pList.size(); i++) {
            p = pList.get(i);
            data[i][0] = p.id;
            data[i][1] = p.name;
            data[i][2] = p.age;
            data[i][3] = p.gender;
            data[i][4] = p.phone;
            data[i][5] = p.address;
        }
        this.titles = titles;
        addTableModelListener(new MyTableModelListener(data));
    }

    @Override
    public String getColumnName(int column) {
        return titles[column]; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        if (columnIndex == 2) {
            return false;
        }

        return true;
    }

}
