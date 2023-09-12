/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Componente.Vista;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class VentanaAvatar extends javax.swing.JFrame {

    private Vista vis;
    private ArrayList<JLabel> listAvatar;
    private int x, y, n;
    private String rutaImg;
    private img vis2;

    /**
     * Creates new form VentanaAvatar
     */
    public VentanaAvatar() {
        initComponents();
        vis = new Vista();
        vis2 = new img();
        listAvatar = new ArrayList<>();
        precargarAvatar();
        mostrarFotos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setTitle("Avatar");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        vis.setBan(true);
    }//GEN-LAST:event_formWindowClosing

    private void precargarAvatar() {
        JLabel lbl;

        for (int i = 0; i < 48; i++) {
            lbl = new JLabel();
            lbl.setBounds(0, 0, 65, 65);
            img(lbl, "/image/IconAvatar/img" + i + ".png");
            lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            String ruta = "/image/IconAvatar/img" + i + ".png";

            lbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    vis2.setRuta(ruta);
                    setVisible(false);
                }
            });

            listAvatar.add(lbl);
        }
    }

    private void img(JLabel lbl, String ruta) {

        try {
            lbl.setIcon(null);
            Icon icon;
            ImageIcon image;
            image = new ImageIcon(getClass().getResource(ruta));

            icon = new ImageIcon(
                    image.getImage().getScaledInstance(
                            lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT)
            );

            lbl.setIcon(icon);
            lbl.repaint();
        } catch (Exception e) {

        }

    }

    public void mostrarFotos() {
        x = 10;
        y = 10;
        n = 0;
        listAvatar.stream().forEach(ava -> {
            jPanel1.add(ava, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, 65, 65));
            x += 75;

            if (n == 7) {
                x = 10;
                y += 75;
                n = -1;
            }

            n++;
        });

        jPanel1.revalidate();
    }

    public void datos(Observer obs) {
        vis.addObserver(obs);
        vis2.addObserver(obs);
    }

    private class img extends Observable {

        private String ruta;

        public img() {
            ruta = "";
        }

        public void setRuta(String ruta) {
            this.setChanged();
            this.notifyObservers(ruta);
            this.clearChanged();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAvatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAvatar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}