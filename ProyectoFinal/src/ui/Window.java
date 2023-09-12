/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author USUARIO
 */
public class Window extends  JFrame{
    JTabbedPane tabs;
    
    JPanel pLbl;
    JPanel pBtn;
    JPanel pTbl,pTb2,pTb3;
    JPanel pGr;
    
    JLabel lblTab;
    JButton btnTab;
    JTable tblTab,tblTab1,tblTab2;
    
    String[] head = {"Nombre", "Apellido", "Cédula"};
    String[][] data = {
        {"Jorge", "Rivera", "123456"},
        {"Pedro", "Perez", "09876"},
        {"Fulano", "De Tal", "000000"},
        {"Carlos", "Sanchez", "11111111"}
    };
    
    String[] head1 = {"Nombre", "Apellido", "Cédula"};
    String[][] data1 = {
        {"Jorge", "Rivera", "123456"},
        {"Pedro", "Perez", "09876"},
        {"Fulano", "De Tal", "000000"},
        {"Carlos", "Sanchez", "11111111"}
    };
    
    String[] head2 = {"Nombre", "Apellido", "Cédula"};
    String[][] data2 = {
        {"Jorge", "Rivera", "123456"},
        {"Pedro", "Perez", "09876"},
        {"Fulano", "De Tal", "000000"},
        {"Carlos", "Sanchez", "11111111"}
    };
    public Window () {
    
    setTitle("Trabajo final");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setSize(400, 300);
        lounchWidgets();
        lounchEvents();
        setVisible(true);
   
    
    }
    public void lounchWidgets() {
        tabs = new JTabbedPane ();
        
        pTb2 = new JPanel();
        pTb3 = new JPanel();
        pBtn = new JPanel();
        pTbl = new JPanel();
        pGr = new JPanel();
        
        tblTab1 = new JTable(data1,head1);
        tblTab2 = new JTable(data2,head2);
        btnTab = new JButton("Button inside Tab");
        tblTab = new JTable(data,head);
        
        pTb2.add(tblTab1);
        pTb3.add(tblTab2);
        pBtn.add(btnTab);
        pTbl.add(tblTab);
        
        tabs.add("MASCOTA", pTb2);
        tabs.add("PERSONA", pTb3);
        tabs.add("Button", pBtn);
        tabs.add("Tables", pTbl);
        tabs.add("Graphics", pGr);
        
        add(tabs);

    }

    public void lounchEvents() {
    }
    
}

