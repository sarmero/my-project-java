/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Cocina;

/**
 *
 * @author USER
 */
public class VentanaVisualisarProducto extends javax.swing.JDialog {

    private Cocina gestorListaReceta;
    private VentanaVisualisarReceta venRec;

    /**
     * Creates new form VentanaVisualisarProducto
     */
    public VentanaVisualisarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        venRec = new VentanaVisualisarReceta(parent, true);
    }

    public void setGestorListaCocina(Cocina gestorListaCocina) {
        this.gestorListaReceta = gestorListaCocina;
        setIconImage(gestorListaCocina.Icono());
        venRec.setGestorListaCocina(gestorListaCocina);
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
        lblMedida = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagen.setForeground(new java.awt.Color(98, 50, 35));
        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setToolTipText("");
        lblImagen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 200));

        lblNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(98, 50, 35));
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 260, -1));

        lblMedida.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblMedida.setForeground(new java.awt.Color(98, 50, 35));
        lblMedida.setText("Medida:");
        jPanel1.add(lblMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 260, -1));

        lblPrecio.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(98, 50, 35));
        lblPrecio.setText("Precio:");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 260, -1));

        lblFecha.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(98, 50, 35));
        lblFecha.setText("Fecha:");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 260, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imgFondo1.png"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void visualizarProducto(String pro, boolean ban) {
        Object[] prod = gestorListaReceta.vizualizarProducto(pro);
        if (prod != null) {
            setTitle(pro);
            lblNombre.setText("Nombre: " + prod[0] + "");
            lblMedida.setText("Contenido: " + prod[1] + "");
            lblPrecio.setText("Precio: " + prod[2] + "");
            lblFecha.setText("Fecha: " + prod[3] + "");
            gestorListaReceta.visualizadorImagen(lblImagen, prod[4] + "");
            setVisible(true);
        } else if (ban == true) {
            venRec.visualizarReceta(pro);
        } else {
            gestorListaReceta.mensaje("Producto no encintrado", "Error",2);
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
            java.util.logging.Logger.getLogger(VentanaVisualisarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVisualisarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVisualisarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVisualisarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaVisualisarProducto dialog = new VentanaVisualisarProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMedida;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
