/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.Person;
import data.TableDataModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import logic.ManagePerson;

/**
 *
 * @author JRivera
 */
public class Edit extends JFrame {

    int index;
    JTable table;
    Person per;
    String[] head = {"Identificacion", "Nombre", "Edad", "Genero", "Celular", "Direccion"};
    String[][] date = {
        {"123456", "Jorge Rivera", "36", "M", "329394995", "pasto"},
        {"09876", "Pedro Perez", "36", "M", "329394995", "pasto"},
        {"000000", "Fulano De Tal", "36", "M", "329394995", "pasto"},
        {"11111111", "Carlos Sanchez", "36", "M", "329394995", "pasto"},};

    public Edit(Person p) {
        per = p;
        setTitle("Editar persona");
        setLayout(new FlowLayout());
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        lounchWidgets();
//        lounchEvents();

        System.out.println(p.toString());
    }

    public void lounchWidgets() {
       
        Object[][] data = new Object[1][6];
        data[0][0] = per.id;
        data[0][1] = per.name;
        data[0][2] = per.age;
        data[0][3] = per.gender;
        data[0][4] = per.phone;
        data[0][5] = per.address;
        table = new JTable(new TableDataModel(data, head));
        add(new JScrollPane(table), BorderLayout.CENTER);
       
    }

    public void lounchEvents() {
        
    }

}
