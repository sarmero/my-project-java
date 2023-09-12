/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componente;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModeloTabla extends AbstractTableModel {

    private final String[] columnNames = {"Meses", "Ingresos"};
    
    
    final Object[][] data = {
        {"Enero", new Integer(5500000)},
        {"Febrero", new Integer(150000)},
        {"Marzo", new Integer(25000)},
        {"Abril", new Integer(-12000)},
        {"Mayo", new Integer(20000)},
        {"Junio", new Integer(7000)},
        {"Julio", new Integer(25000)},
        {"Agosto", new Integer(-60000)},
        {"Septiembre", new Integer(-5000)},
        {"Octubre", new Integer(17000)},
        {"Noviembre", new Integer(8000)},
        {"Deciembre", new Integer(9000)}
    };

    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return data.length;
    }

    public Object getValueAt(int row, int column) {
        return data[row][column];
    }
}
