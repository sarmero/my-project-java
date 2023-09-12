package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author JIDWARD RODRIGUEZ
 */
public class Main extends JFrame {

    public JPanel encripted;
    public JPanel descencripted;

    public JLabel lblName;
    public JLabel lblKey;
    public JLabel lblEnc;

    public JTextField txfName;
    public JTextField txfKey;
    public JTextField txfEnc;

    public JButton btnEncript;

    public JLabel lbl_Name;
    public JLabel lbl_Key;
    public JLabel lbl_Desenc;

    public JTextField txf_Name;
    public JTextField txf_Key;
    public JTextField txf_Desenc;

    public JButton btnDesencripted;

    private BasicTextEncryptor textEncryptor;
    private String myEncryptedText;

    public static void main(String[] args) {
        new Main();

    }

    public Main() {
        setTitle("Encrypting & Desencrypting");
        setSize(525, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        louchWidgets();
        lounchEvents();
        setVisible(true);
        myEncryptedText = "";
    }

    public void louchWidgets() {
        //encripted = new JPanel();
        //descencripted = new JPanel();

        lblName = new JLabel("Texto Llano: ");
        lblName.setBounds(10, 40, 200, 25);
        lblKey = new JLabel("Clave: ");
        lblKey.setBounds(10, 100, 200, 25);
        lblEnc = new JLabel("Encriptado");
        lblEnc.setBounds(10, 160, 200, 25);

        lbl_Name = new JLabel("Encriptado: ");
        lbl_Name.setBounds(300, 40, 200, 25);
        lbl_Key = new JLabel("Clave: ");
        lbl_Key.setBounds(300, 100, 200, 25);
        lbl_Desenc = new JLabel("Texto Llano");
        lbl_Desenc.setBounds(300, 160, 200, 25);

        txfName = new JTextField();
        txfName.setBounds(10, 70, 200, 25);
        txfKey = new JTextField();
        txfKey.setBounds(10, 130, 200, 25);
        txfEnc = new JTextField();
        txfEnc.setBounds(10, 190, 200, 25);

        txf_Name = new JTextField();
        txf_Name.setBounds(300, 70, 200, 25);
        txf_Key = new JTextField();
        txf_Key.setBounds(300, 130, 200, 25);
        txf_Desenc = new JTextField();
        txf_Desenc.setBounds(300, 190, 200, 25);

        btnEncript = new JButton("Encriptar");
        btnEncript.setBounds(30, 250, 130, 25);
        btnDesencripted = new JButton("Desencriptar");
        btnDesencripted.setBounds(330, 250, 130, 25);

        add(lblName);
        add(txfName);
        add(lblKey);
        add(txfKey);
        add(lblEnc);
        add(txfEnc);
        add(btnEncript);
        add(lbl_Name);
        add(txf_Name);
        add(lbl_Key);
        add(txf_Key);
        add(lbl_Desenc);
        add(txf_Desenc);
        add(btnDesencripted);

    }

    public void lounchEvents() {
        btnEncript.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!txfKey.getText().equals("") && !txfName.getText().equals("")) {
                    encripted();
                }

            }
        });

        btnDesencripted.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!txf_Key.getText().equals("") && !txf_Name.getText().equals("")) {
                    desencripted();
                }

            }
        });

    }

    private void encripted() {
        try {
            textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword(txfKey.getText());
            myEncryptedText = textEncryptor.encrypt(txfName.getText());
            txfEnc.setText(myEncryptedText);
            System.out.println(textEncryptor.decrypt(myEncryptedText));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al encriptar el texto");
        }
    }

    private void desencripted() {
        try {
            textEncryptor = new BasicTextEncryptor();
            textEncryptor.setPassword(txf_Key.getText());
            String plainText = textEncryptor.decrypt(txf_Name.getText());
            txf_Desenc.setText(plainText);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desencriptar el texto");
        }

    }
}
