/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Componente.Vista;
import controller.ListaUsuario;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author USER
 */
public class VentanaUsuario extends javax.swing.JFrame implements Observer {

    private ListaUsuario gestorListaUsuario;
    private Usuario usuario;
    private Vista vis;
    private boolean vent;
    private VentanaRegistrarUsuario ventanaRegistrarUsuario;
    private ventanaConfirmeContraseña venConfirmeContraseña;
    private boolean password;

    /**
     * Creates new form VentanaUsuario
     */
    public VentanaUsuario() {
        initComponents();
        vis = new Vista();
        vent = false;
        password = false;
        ventanaRegistrarUsuario = new VentanaRegistrarUsuario();
        venConfirmeContraseña = new ventanaConfirmeContraseña(this, true);
    }

    public void setGestorUsuario(ListaUsuario gestorListaUsuario) {
        this.gestorListaUsuario = gestorListaUsuario;
        setIconImage(gestorListaUsuario.Icono());
        ventanaRegistrarUsuario.setGestorListaUsuario(gestorListaUsuario);
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
        lblImagen = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        lblPin = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setTitle("Usuario");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(85, 35, 14));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagen.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        lblImagen.setForeground(new java.awt.Color(85, 35, 14));
        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 150, 150));

        lblNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(85, 35, 14));
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        lblApellido.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(85, 35, 14));
        lblApellido.setText("Apellido:");
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(85, 35, 14));
        lblCorreo.setText("Correo:");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(85, 35, 14));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("s");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 150, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pasteli3.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 260, 160));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chocoPastel.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 280, 460));

        lblCelular.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblCelular.setForeground(new java.awt.Color(85, 35, 14));
        lblCelular.setText("Celular:");
        lblCelular.setToolTipText("");
        jPanel1.add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btnModificar.setBackground(new java.awt.Color(85, 35, 14));
        btnModificar.setForeground(new java.awt.Color(255, 191, 154));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 90, -1));

        lblPin.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblPin.setForeground(new java.awt.Color(85, 35, 14));
        lblPin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPin.setText("Desactivar PIN");
        lblPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPinMouseExited(evt);
            }
        });
        jPanel1.add(lblPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 110, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fondoUsuario.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        password = true;
        venConfirmeContraseña.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed


    private void lblPinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPinMouseEntered
        lblPin.setForeground(Color.blue);
    }//GEN-LAST:event_lblPinMouseEntered

    private void lblPinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPinMouseExited
        lblPin.setForeground(new Color(85, 35, 14));
    }//GEN-LAST:event_lblPinMouseExited

    private void lblPinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPinMouseClicked
        activarPin();
    }//GEN-LAST:event_lblPinMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        vis.setBan(true);
    }//GEN-LAST:event_formWindowClosing

    private void activarPin() {
        String respuesta = "";

        while (respuesta != null) {
            respuesta = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la Contraseña",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (respuesta != null) {

                if (gestorListaUsuario.validarContraseña(usuario.getUsuario(), respuesta) == true) {

                    if (usuario.getPin() == -1) {
                        while (respuesta != null) {
                            respuesta = JOptionPane.showInputDialog(
                                    null,
                                    "Ingrese el nuevo PIN de 6 digitos",
                                    JOptionPane.QUESTION_MESSAGE
                            );

                            boolean ban = false;

                            if (respuesta != null) {
                                if (respuesta.length() == 6) {
                                    for (int i = 0; i < 6; i++) {
                                        if (respuesta.charAt(i) < 48 && respuesta.charAt(i) > 57) {
                                            ban = true;
                                            break;
                                        }
                                    }

                                    if (ban == false) {
                                        gestorListaUsuario.ingresarPin(Integer.valueOf(respuesta));
                                        gestorListaUsuario.mensaje("PIN Ingresado Correctamente", "Usuario",0);
                                        lblPin.setText("Desativar Pin");
                                        respuesta = null;
                                    } else {
                                        gestorListaUsuario.mensaje("por favor ingrese un PIN valido", "Usuario",2);
                                    }

                                } else {
                                    gestorListaUsuario.mensaje("por favor Ingrese un pin de 6 digitos", "Usuario",3);
                                }
                            }
                        }

                    } else {
                        gestorListaUsuario.ingresarPin(-1);
                        lblPin.setText("Activar Pin");
                        respuesta = null;
                    }
                } else {

                }
            }
        }
    }

    public void observer(Observer ven) {
        vis.addObserver(ven);
    }

    public void cargarUsuario(Usuario user) {
        usuario = gestorListaUsuario.buscarUsuario(user.getUsuario());
        lblNombre.setText("Nombre: "+ user.getNombre());
        lblApellido.setText("Empresa: " + user.getNegocio());
        lblCorreo.setText("Correo: " + user.getCorreo());
        lblCelular.setText("Celular: " + user.getCelular());
        lblUsuario.setText(user.getUsuario());
        if (usuario.getPin() == -1) {
            lblPin.setText("Activar PIN");
        } else {
            lblPin.setText("Desativar PIN");
        }
        lblImagen = gestorListaUsuario.visualizadorImagen2(lblImagen, user.getRutaImagen());
        venConfirmeContraseña.setUsuario(usuario, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Boolean && vent == true) {
            cargarUsuario(gestorListaUsuario.obtenerUsuario(usuario.getCodigo()));
            setVisible(true);
            vent = false;
        }

        if ((boolean) arg == true && password == true) {
            ventanaRegistrarUsuario.modificarUsuario(usuario);
            ventanaRegistrarUsuario.setVisible(true);
            ventanaRegistrarUsuario.observer(this);
            setVisible(false);
            vent = true;
            password = false;
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
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPin;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

}