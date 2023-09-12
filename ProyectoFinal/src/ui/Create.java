/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.Person;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.ManagePerson;

/**
 *
 * @author JRivera
 */
public class Create extends JFrame {

    JLabel lblId;
    JLabel lblName;
    JLabel lblAge;
    JLabel lblGender;
    JLabel lblPhone;
    JLabel lblAddress;

    JTextField txfId;
    JTextField txfName;
    JTextField txfAge;
    JTextField txfGender;
    JTextField txfPhone;
    JTextField txfAddress;

    JButton btnSave;

    public Create() {
        setSize(600, 400);
        setTitle("Crear registro de persona");
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new GridLayout(13, 1));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lounchWidgets();
        lounchEvents();
        setVisible(true);
    }

    public void lounchWidgets() {
        lblId = new JLabel("Identificacion:");
        lblName = new JLabel("Nombre:");
        lblAge = new JLabel("Edad:");
        lblGender = new JLabel("Genero:");
        lblPhone = new JLabel("Celular:");
        lblAddress = new JLabel("Direccion:");

        txfId = new JTextField();
        txfName = new JTextField();
        txfAge = new JTextField();
        txfGender = new JTextField();
        txfPhone = new JTextField();
        txfAddress = new JTextField();

        btnSave = new JButton("Guardar");

        add(lblId);
        add(txfId);

        add(lblName);
        add(txfName);

        add(lblAge);
        add(txfAge);

        add(lblGender);
        add(txfGender);

        add(lblPhone);
        add(txfPhone);

        add(lblAddress);
        add(txfAddress);

        add(btnSave);

    }

    public void lounchEvents() {
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (validateForm() == true) {
                    savePerson();
                    cleanForm();
                } else {
                    showMessagge();
                }
            }
        });
    }

    public void savePerson() {
        String _id = txfId.getText();
        String _name = txfName.getText();
        int _age = Integer.parseInt(txfAge.getText());
        char _gender = txfGender.getText().charAt(0);
        String _phone = txfPhone.getText();
        String _address = txfAddress.getText();
        ManagePerson.pList.add(new Person(_id, _name, _age, _gender, _phone, _address));
        JOptionPane.showMessageDialog(
                this,
                "El registro se ha guardado con éxito",
                "Registro Guardado",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void cleanForm() {
        txfId.setText("");
        txfName.setText("");
        txfAge.setText("");
        txfGender.setText("");
        txfPhone.setText("");
        txfAddress.setText("");
    }

    public boolean validateForm() {
        //True -> if form is full
        //False -> if a field is empty
        boolean ret = false;

        if (txfId.getText().trim().isEmpty() == false
                && txfName.getText().trim().isEmpty() == false
                && txfAge.getText().trim().isEmpty() == false
                && verifyNumber(txfAge.getText().trim()) == true
                && txfGender.getText().trim().isEmpty() == false
                && verifyGender(txfGender.getText().trim()) == true
                && txfPhone.getText().trim().isEmpty() == false
                && txfAddress.getText().trim().isEmpty() == false) {
            ret = true;
        }
        return ret;
    }

    public void showMessagge() {

        String msj = "";
        String msj2 = "";
        String msj3 = "";

        if (txfId.getText().trim().isEmpty() == true) {
            msj += "Identificacion";
        }
        if (txfName.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Nombre";
        }
        if (txfAge.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Edad";
        }
        if (verifyNumber(txfAge.getText().trim()) == false) {
            msj2 += "La edad debe ser un número";
        }
        if (txfGender.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Genero";
        }        
        if (verifyGender(txfGender.getText().trim()) == false) {
            msj3 += "El género debe ser M o F";
        }
        if (txfPhone.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Celular";
        }
        if (txfAddress.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Direccion";
        }

        JOptionPane.showMessageDialog(
                this,
                (msj.isEmpty() == true ? "" : "Debe llenar los campos: " + msj)
                + (msj2.isEmpty() == true ? "" : "\n" + msj2)
                + (msj3.isEmpty() == true ? "" : "\n" + msj3),
                "Todos los campos son obligatorios",
                JOptionPane.WARNING_MESSAGE
        );

        //JOptionPane.WARNING_MESSAGE        
        //JOptionPane.ERROR_MESSAGE        
        //JOptionPane.PLAIN_MESSAGE
        //JOptionPane.INFORMATION__MESSAGE
    }

    public boolean verifyNumber(String cad) {
        //True -> is number
        //False -> is not number

        boolean ret = true;
        for (int i = 0; i < cad.length(); i++) {
            if (Character.isDigit(cad.charAt(i)) == false) {
                ret = false;
                break;
            }
        }

        return ret;
    }

    public boolean verifyGender(String cad) {
        //True -> is ok
        //False -> is wrong

        boolean ret = true;

        if (cad.length() > 1 || cad.length() == 0) {
            ret = false;
        } else if (!(cad.charAt(0) == 'M' || cad.charAt(0) == 'F')) {
            ret = false;
        }

        return ret;
    }

}
