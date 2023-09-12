/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.Person;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import logic.ManagePerson;

/**
 *
 * @author JRivera
 */
public class List extends JFrame {

    JPanel top;
    JPanel list;
    JPanel listM;

    JButton btnCreate;
    JButton btnCreateM;
    JButton btnRefresh;

    int auxIndex;

    public List() {
        setSize(600, 400);
        setTitle("Lista");
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lounchWidgets();
        lounchEvents();
        setVisible(true);
    }

    public void lounchWidgets() {
        top = new JPanel();
        list = new JPanel();
        listM = new JPanel();

        btnCreate = new JButton("Crear registro persona");
        btnCreateM = new JButton("Crear registro Mascota");
        btnRefresh = new JButton("Actualizar");

        top.add(btnCreate);
        top.add(btnCreateM);
        top.add(btnRefresh);

        ManagePerson.pList.add(new Person("01", "Pedro", 15, 'M', "7202020", "Casa 1"));
        ManagePerson.pList.add(new Person("02", "Maria", 25, 'F', "7202021", "Casa 2"));
        ManagePerson.pList.add(new Person("03", "Juana", 35, 'F', "7202022", "Casa 3"));

        //top.setBorder(new LineBorder(Color.YELLOW));
        //list.setBorder(new LineBorder(Color.BLUE));
        list.setBorder(new CompoundBorder(
                new LineBorder(Color.BLUE),
                new LineBorder(Color.ORANGE)));

        add(top, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);
    }

    public void lounchEvents() {
        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Create();
                
            }
        });
        btnCreateM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CreateM();
                
            }
        });

        btnRefresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagePerson.showList();

                //Cargando dinamicamente la lista
                list.removeAll();
                list.setLayout(new GridLayout(ManagePerson.pList.size(), 1));
                for (int i = 0; i < ManagePerson.pList.size(); i++) {
                    Person p = ManagePerson.pList.get(i);
                    JPanel pp = new JPanel();
                    JButton btnEdit = new JButton("Editar");
                    JButton btnDelete = new JButton("Borrar");

                    auxIndex = i;
                    //Editar la lista
                    btnEdit.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            new Edit(p);
                        }

                    });
                    //Eliminar la lista
                    btnDelete.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
//                           list.remove(ManagePerson.pList.size()-1);
                            for (int j = 0; j < ManagePerson.pList.size(); j++) {
                                if (ManagePerson.pList.get(j).id.equals(p.id)) {
                                    ManagePerson.pList.remove(j);
                                    System.out.println("Ha eliminado por completo");
                                }
                            }
                           
                           
                       
                      }

                    });
                    pp.add(btnEdit);
                    pp.add(btnDelete);

                    pp.setBorder(new TitledBorder(p.name));
                    list.add(pp);
                }

                list.revalidate();

            }
        });
    }

}
