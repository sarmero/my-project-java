/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

public final class Principal extends JApplet {

    JComboBox combo;
    String nombres[], clases[];

    @Override
    public void init() {

        LookAndFeelInfo skins[];
        skins = UIManager.getInstalledLookAndFeels();
        nombres = new String[skins.length];
        clases = new String[skins.length];
        System.out.println("paso"+skins.length);
        for (int i = 0; i < skins.length; i++) {
            nombres[i] = "" + skins[i].getName();
            clases[i] = "" + skins[i].getClassName();
            System.out.println(nombres[i]);
        }

        combo = new JComboBox(nombres);

        combo.addActionListener((ActionEvent arg0) -> {
            try {
                UIManager.setLookAndFeel(clases[combo.getSelectedIndex()]);
                SwingUtilities.updateComponentTreeUI(Principal.this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });

        JPanel p = new JPanel();
        p.add(combo);
        add(p);
    }
}
