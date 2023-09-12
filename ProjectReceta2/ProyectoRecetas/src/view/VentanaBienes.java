/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Componente.Vista;
import controller.Cocina;
import java.util.ArrayList;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class VentanaBienes extends javax.swing.JFrame {

    private Cocina gestorListaCocina;
    private Vista vis;

    /**
     * Creates new form VentanaBienes
     */
    public VentanaBienes() {
        initComponents();
        vis = new Vista();
    }

    public void setGestorListaCocina(Cocina gestorListaCocina) {
        this.gestorListaCocina = gestorListaCocina;
        setIconImage(gestorListaCocina.Icono());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbxReceta = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblEgreso = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblBajas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblIngreso = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblGanancia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblInventario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaInformacion = new javax.swing.JTextPane();
        lblVenTot = new javax.swing.JLabel();
        lblGasTot = new javax.swing.JLabel();
        lblGanTot = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblVentaTotalEst = new javax.swing.JLabel();
        lblN4 = new javax.swing.JLabel();
        lblN1 = new javax.swing.JLabel();
        lblN2 = new javax.swing.JLabel();
        lblN3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Bienes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(98, 50, 35));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Receta", "Cant", "Gasto", "Venta", "Ganancia", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setSelectionBackground(new java.awt.Color(98, 50, 35));
        jTable1.setSelectionForeground(new java.awt.Color(204, 255, 204));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(115);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(55);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 590, 240));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(98, 50, 35));
        jLabel1.setText("Receta:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jPanel1.add(cbxReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 300, -1));

        btnBuscar.setBackground(new java.awt.Color(98, 50, 35));
        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 191, 154));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 90, -1));

        btnCerrar.setBackground(new java.awt.Color(255, 153, 153));
        btnCerrar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(98, 50, 35));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 80, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Egreso:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 260, -1, -1));

        lblEgreso.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblEgreso.setForeground(new java.awt.Color(204, 255, 204));
        lblEgreso.setText("$ 50.000");
        jPanel1.add(lblEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 135, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Perdidas:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 380, 70, -1));

        lblBajas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblBajas.setForeground(new java.awt.Color(204, 255, 204));
        lblBajas.setText("$ 40.000");
        jPanel1.add(lblBajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 135, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Ingresos:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 290, -1, -1));

        lblIngreso.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblIngreso.setForeground(new java.awt.Color(204, 255, 204));
        lblIngreso.setText("$ 150.000");
        jPanel1.add(lblIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 135, -1));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 204));
        jLabel9.setText("Ganancia:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 320, -1, -1));

        lblGanancia.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblGanancia.setForeground(new java.awt.Color(204, 255, 204));
        lblGanancia.setText("$ 300.000");
        jPanel1.add(lblGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 135, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 204));
        jLabel10.setText("Bienes:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 410, 66, -1));

        lblTotal.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 255, 204));
        lblTotal.setText("$ 500.000");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 410, 135, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Inventario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 350, -1, -1));

        lblInventario.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblInventario.setForeground(new java.awt.Color(204, 255, 204));
        lblInventario.setText("$ 100.400.000.00");
        jPanel1.add(lblInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 135, -1));

        txaInformacion.setEditable(false);
        txaInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(98, 50, 35)), "Informacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14), new java.awt.Color(98, 50, 35))); // NOI18N
        txaInformacion.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txaInformacion.setForeground(new java.awt.Color(98, 50, 35));
        txaInformacion.setSelectedTextColor(new java.awt.Color(204, 255, 204));
        txaInformacion.setSelectionColor(new java.awt.Color(98, 50, 35));
        jScrollPane2.setViewportView(txaInformacion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 590, 90));

        lblVenTot.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblVenTot.setForeground(new java.awt.Color(98, 50, 35));
        lblVenTot.setText("Venta total: $ 200.000");
        jPanel1.add(lblVenTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 180, -1));

        lblGasTot.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblGasTot.setForeground(new java.awt.Color(98, 50, 35));
        lblGasTot.setText("Gasto total: $ 100.000");
        jPanel1.add(lblGasTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 180, -1));

        lblGanTot.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lblGanTot.setForeground(new java.awt.Color(98, 50, 35));
        lblGanTot.setText("Gananacia total:$ 3000.000");
        jPanel1.add(lblGanTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 180, -1));

        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)), "Finanzas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14), new java.awt.Color(204, 255, 204))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 220, 230, 240));

        lblVentaTotalEst.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblVentaTotalEst.setForeground(new java.awt.Color(204, 255, 204));
        lblVentaTotalEst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentaTotalEst.setText("Total ventas: 100");
        jPanel1.add(lblVentaTotalEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 30, 210, -1));

        lblN4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblN4.setForeground(new java.awt.Color(204, 255, 204));
        lblN4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblN4.setText("Otros: 0,5%");
        jPanel1.add(lblN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 150, 210, -1));

        lblN1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblN1.setForeground(new java.awt.Color(204, 255, 204));
        lblN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblN1.setText("Genoveza: 63%");
        jPanel1.add(lblN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 60, 210, -1));

        lblN2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblN2.setForeground(new java.awt.Color(204, 255, 204));
        lblN2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblN2.setText("Normal: 30%");
        jPanel1.add(lblN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 90, 210, -1));

        lblN3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblN3.setForeground(new java.awt.Color(204, 255, 204));
        lblN3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblN3.setText("Tres Leche: 3%");
        jPanel1.add(lblN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 120, 210, -1));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)), "Estadistica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14), new java.awt.Color(204, 255, 204))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 0, 230, 210));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imgFondoVentaR.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 470));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imgFondo2.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 240, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String receta;
        if (cbxReceta.getSelectedIndex() > 0) {
            receta = cbxReceta.getSelectedItem().toString();
        } else {
            receta = "";
        }

        jTable1.setModel(gestorListaCocina.obtenerBienesFecha(jTable1, receta));
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        txaInformacion.setText("");
        lblGasTot.setText("Gasto total: " + gestorListaCocina.costoReporte(modelo, 2));
        lblVenTot.setText("Venta total: " + gestorListaCocina.costoReporte(modelo, 3));
        lblGanTot.setText("Ganancia total: " + gestorListaCocina.costoReporte(modelo, 4));

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        vis.setBan(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        setVisible(false);
        vis.setBan(true);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        String receta;
        double can;

        if (row >= 0) {
            receta = jTable1.getValueAt(row, 0) + "";
            can = Double.valueOf((((jTable1.getValueAt(row, 1) + "").replace(".", "")).replace("g", "")).replace(",", "."));
            txaInformacion.setText(gestorListaCocina.getListaPedido().informacionPedidos(receta, can));
            gestorListaCocina.formatoJtexPanel(txaInformacion);
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void obtenerValores() {
        Object[] bienes = gestorListaCocina.bienes();
        lblEgreso.setText("" + bienes[1]);
        lblIngreso.setText("" + bienes[0]);
        lblGanancia.setText("" + bienes[2]);
        lblBajas.setText("" + bienes[3]);
        lblInventario.setText("" + bienes[4]);
        lblTotal.setText("" + bienes[5]);
    }

    private void estadistica() {
        String[] list = gestorListaCocina.getListaPedido().estadistica();

        lblVentaTotalEst.setText(list[0] + "");
        lblN1.setText(list[1] != null ? list[1] : "");
        lblN2.setText(list[2] != null ? list[2] : "");
        lblN3.setText(list[3] != null ? list[3] : "");
        lblN4.setText(list[4] != null ? list[4] : "");

    }

    public void llenarcbx(Observer ven) {
        vis.addObserver(ven);
        cbxReceta.removeAllItems();
        cbxReceta.addItem("Todas las receteta");
        gestorListaCocina.getListaCategoria().listaBoxRecetaAll(cbxReceta);
        jTable1.setModel(gestorListaCocina.obtenerBienesFecha(jTable1, ""));
        obtenerValores();
        estadistica();
        gestorListaCocina.formatoJtexPanel(txaInformacion);
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        lblGasTot.setText("Gasto total: " + gestorListaCocina.costoReporte(modelo, 2));
        lblVenTot.setText("Venta total: " + gestorListaCocina.costoReporte(modelo, 3));
        lblGanTot.setText("Ganancia total: " + gestorListaCocina.costoReporte(modelo, 4));
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
            java.util.logging.Logger.getLogger(VentanaBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBienes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBienes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cbxReceta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBajas;
    private javax.swing.JLabel lblEgreso;
    private javax.swing.JLabel lblGanTot;
    private javax.swing.JLabel lblGanancia;
    private javax.swing.JLabel lblGasTot;
    private javax.swing.JLabel lblIngreso;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblN1;
    private javax.swing.JLabel lblN2;
    private javax.swing.JLabel lblN3;
    private javax.swing.JLabel lblN4;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVenTot;
    private javax.swing.JLabel lblVentaTotalEst;
    private javax.swing.JTextPane txaInformacion;
    // End of variables declaration//GEN-END:variables
}
