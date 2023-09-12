/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componente;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author USER
 */
public class CeldaRenderer extends DefaultTableCellRenderer {

    private int col = -1;

    public CeldaRenderer(int col) {
        this.col = col;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        double val;
        String cos;

        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (col == column && value instanceof String) {
            cos = String.valueOf(value);
            cos = cos.replace(".", "");
            cos = cos.replace("$ ", "");
            cos = cos.replace(",", ".");
            val = Double.valueOf(cos);
            if (val < 0) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
                return cell;
            } else {
                cell.setBackground(Color.GREEN);
                cell.setForeground(new Color(98, 50, 35));
            }

        }

        return cell;
    }
}
