/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author USER
 */
public class FormatoCbox extends BasicComboBoxRenderer {

    String[] tooltips = {"los numeros son distintos ", " ", "Latin "};

    public Component getListCellRendererComponent(JList list, Object value,int index,boolean isSelected,boolean cellHasFocus){
        if (isSelected) {
            setBackground(new Color(255, 51, 51));
            setForeground(new Color(255, 255, 255));
            
            if (-1 < index) {
//                    list.setToolTipText(tooltips[index]);
            
            }else{
                
            }
        } else {
            setBackground(new Color(0, 0, 0));
            setForeground(new Color(255, 51, 51));
        }
        
        setFont(list.getFont());
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
