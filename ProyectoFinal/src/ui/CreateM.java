/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import data.Pet;
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
import logic.ManagePet;

/**
 *
 * @author JRivera
 */
public class CreateM extends JFrame {

    JLabel lblId;
    JLabel lblName;
    JLabel lblAge;
    JLabel lblTipo;
    JLabel lblRaza;
    JLabel lblGender;
    JLabel lblPhone;
    JLabel lblAddress;

    JTextField txfId;
    JTextField txfName;
    JTextField txfAge;
    JTextField txTipo;
    JTextField txfRaza;
    JTextField txfGender;
    JTextField txfPhone;
    JTextField txfAddress;

    JButton btnSave;

    public CreateM() {
        setSize(600, 400);
        setTitle("Crear registro de Mascota");
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new GridLayout(18, 1));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lounchWidgets();
        lounchEvents();
        setVisible(true);
    }

    public void lounchWidgets() {
        lblId = new JLabel("Identificacion:");
        lblName = new JLabel("Nombre:");
        lblAge = new JLabel("Edad:");
        lblTipo = new JLabel("Tipo Mascota:");
        lblRaza = new JLabel("Raza:");
        lblGender = new JLabel("Genero:");
        lblPhone = new JLabel("Celular:");
        lblAddress = new JLabel("Direccion:");

        txfId = new JTextField();
        txfName = new JTextField();
        txfAge = new JTextField();
        txTipo = new JTextField();
        txfRaza = new JTextField();
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
        
        add(lblTipo);
        add(txTipo);
        
        add(lblRaza);
        add(txfRaza);

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
                    savePet();
                    cleanForm();
                } else {
                    showMessagge();
                }
            }
        });
    }

    public void savePet() {
        String _id = txfId.getText();
        String _name = txfName.getText();
        int _age = Integer.parseInt(txfAge.getText());
        String _tipo = txTipo.getText();
        String _raza = txfRaza.getText();
        char _gender = txfGender.getText().charAt(0);
        String _phone = txfPhone.getText();
        String _address = txfAddress.getText();
        ManagePet.petList.add(new Pet(_id, _name, _age, _tipo, _raza, _gender, _phone, _address));
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
        txTipo.setText("");
        txfRaza.setText("");
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
                && txTipo.getText().trim().isEmpty() == false
                && txfRaza.getText().trim().isEmpty() == false
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
        if (txTipo.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Tipo Mascota:";
        }
        if (txfRaza.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Raza:";
        }
        if (txfGender.getText().trim().isEmpty() == true) {
            msj += (msj.trim().isEmpty() == true ? "" : ", ") + "Genero";
        }        
        if (verifyGender(txfGender.getText().trim()) == false) {
            msj3 += "El género debe ser M o H";
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
        } else if (!(cad.charAt(0) == 'M' || cad.charAt(0) == 'H')) {
            ret = false;
        }

        return ret;
    }

}
