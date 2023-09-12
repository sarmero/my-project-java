/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Componente.Vista;
import controller.Cocina;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Despensa;

/**
 *
 * @author USER
 */
public class VentanaDespensa extends javax.swing.JFrame {

    private Cocina gestorListaCocina;
    private boolean ban;
    private Vista vis;
    private boolean estado;

    /**
     * Creates new form VentanaEntrada
     */
    public VentanaDespensa() {
        initComponents();
        ban = false;
        vis = new Vista();
        estado = false;
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

        popumenu = new javax.swing.JPopupMenu();
        minRem = new javax.swing.JMenuItem();
        minRemAll = new javax.swing.JMenuItem();
        minEditar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dtcFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        cbxProducto = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        cbtBajas = new javax.swing.JCheckBox();
        cbtEntrada = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxProducto1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbtEntrada1 = new javax.swing.JCheckBox();
        cbtBajas1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        popumenu.setLabel("Opcion:");

        minRem.setText("Remover");
        minRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minRemActionPerformed(evt);
            }
        });
        popumenu.add(minRem);

        minRemAll.setText("Remover todo");
        minRemAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minRemAllActionPerformed(evt);
            }
        });
        popumenu.add(minRemAll);

        minEditar.setText("Editar");
        minEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEditarActionPerformed(evt);
            }
        });
        popumenu.add(minEditar);

        setTitle("Entradas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 191, 154));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(98, 50, 35));
        jLabel6.setText("Producto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jTable1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(98, 50, 35));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setComponentPopupMenu(popumenu);
        jTable1.setSelectionBackground(new java.awt.Color(98, 50, 35));
        jTable1.setSelectionForeground(new java.awt.Color(204, 255, 204));
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(180);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 500, 290));

        dtcFecha.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jPanel1.add(dtcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 180, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(98, 50, 35));
        jLabel1.setText("Fecha:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 153, 153));
        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(98, 50, 35));
        btnSalir.setText("Cerrar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 525, 85, -1));

        cbxProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cbxProducto.setForeground(new java.awt.Color(98, 50, 35));
        jPanel1.add(cbxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 180, -1));

        btnBuscar.setBackground(new java.awt.Color(98, 50, 35));
        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 191, 154));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        cbtBajas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbtBajas.setForeground(new java.awt.Color(98, 50, 35));
        cbtBajas.setText("Bajas");
        cbtBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtBajasActionPerformed(evt);
            }
        });
        jPanel1.add(cbtBajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 80, -1));

        cbtEntrada.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbtEntrada.setForeground(new java.awt.Color(98, 50, 35));
        cbtEntrada.setSelected(true);
        cbtEntrada.setText("Entrda");
        cbtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(cbtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 80, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(98, 50, 35), 1, true), "Registrar ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14), new java.awt.Color(98, 50, 35))); // NOI18N

        btnAdd.setBackground(new java.awt.Color(98, 50, 35));
        btnAdd.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 191, 154));
        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(98, 50, 35));
        jLabel3.setText("Cantidad:");

        cbxProducto1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(98, 50, 35));
        jLabel2.setText("Producto:");

        cbtEntrada1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbtEntrada1.setForeground(new java.awt.Color(98, 50, 35));
        cbtEntrada1.setSelected(true);
        cbtEntrada1.setText("Entrda");
        cbtEntrada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtEntrada1ActionPerformed(evt);
            }
        });

        cbtBajas1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbtBajas1.setForeground(new java.awt.Color(98, 50, 35));
        cbtBajas1.setText("Bajas");
        cbtBajas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtBajas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCantidad)
                            .addComponent(cbxProducto1, 0, 190, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 51, Short.MAX_VALUE)
                        .addComponent(cbtEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cbtBajas1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtEntrada1)
                    .addComponent(cbtBajas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, 200));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imgFondoPrincipal.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minRemActionPerformed
        int row = jTable1.getSelectedRow();
        if (jTable1.getSelectedRowCount() > 0) {
            gestorListaCocina.getListaDespensa().eliminarEntrada(row);
            obtenerDatos();
        }
    }//GEN-LAST:event_minRemActionPerformed

    private void minRemAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minRemAllActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        jTable1.setModel(modelo);
        gestorListaCocina.getListaDespensa().eliminarAllEntrada();
    }//GEN-LAST:event_minRemAllActionPerformed

    private void minEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minEditarActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            cbxProducto1.setSelectedIndex(row);
            txtCantidad.setText(jTable1.getModel().getValueAt(row, 1) + "");
            btnAdd.setText("Modificar");
        }

        if (cbtEntrada.isSelected() == true) {
            cbtEntrada1.setSelected(true);
            cbtBajas1.setSelected(false);
        } else {
            cbtEntrada1.setSelected(false);
            cbtBajas1.setSelected(true);
        }

        cbtEntrada1.setEnabled(false);
        cbtBajas1.setEnabled(false);
    }//GEN-LAST:event_minEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
        vis.setBan(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        obtenerDatos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        evt = gestorListaCocina.consumir(evt, txtCantidad.getText());
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Añadir();
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtEntradaActionPerformed
        validarCheBoton(true);
    }//GEN-LAST:event_cbtEntradaActionPerformed

    private void cbtBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtBajasActionPerformed
        validarCheBoton(false);
    }//GEN-LAST:event_cbtBajasActionPerformed

    private void cbtEntrada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtEntrada1ActionPerformed
        validarCheBoton1(true);
    }//GEN-LAST:event_cbtEntrada1ActionPerformed

    private void cbtBajas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtBajas1ActionPerformed
        validarCheBoton1(false);
    }//GEN-LAST:event_cbtBajas1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        vis.setBan(true);
    }//GEN-LAST:event_formWindowClosing

    private void validarCheBoton(boolean ban) {

        if (ban == true) {
            cbtEntrada.setSelected(true);
            cbtBajas.setSelected(false);
        } else {
            cbtBajas.setSelected(true);
            cbtEntrada.setSelected(false);
        }
    }

    private void validarCheBoton1(boolean ban) {

        if (ban == true) {
            cbtEntrada1.setSelected(true);
            cbtBajas1.setSelected(false);
        } else {
            cbtBajas1.setSelected(true);
            cbtEntrada1.setSelected(false);
        }
    }

    private void Añadir() {
        if (!txtCantidad.getText().equals("") && cbxProducto1.getSelectedIndex() >= 0) {
            if (ban == false) {
                guardar();
            } else {
                editar();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por Favor, llena todas las casillas");
        }
    }

    private void guardar() {
        Despensa alm;
        alm = new Despensa();
        alm.setProducto(gestorListaCocina.getListaProducto().getListaProducto().get(cbxProducto1.getSelectedIndex()));
        alm.setCantidad(Double.valueOf(txtCantidad.getText()));

        if (cbtEntrada1.isSelected() == true) {
            gestorListaCocina.getListaDespensa().agregarAlmacen(alm);
            jTable1.setModel(gestorListaCocina.obtenerListaEntradas(jTable1, "", 0));

        } else {
            gestorListaCocina.getListaDespensa().agregarBaja(alm);
            jTable1.setModel(gestorListaCocina.obtenerListaBaja(jTable1, "", 0));
        }

        gestorListaCocina.mensaje("Productos registrado Corretamente", "Almacen",0);
        txtCantidad.setText("");

    }

    private void editar() {
        int row = jTable1.getSelectedRow();
        Despensa alm = gestorListaCocina.getListaDespensa().entrada(row);
        alm.setProducto(gestorListaCocina.getListaProducto().getListaProducto().get(cbxProducto1.getSelectedIndex()));
        alm.setCantidad(Double.valueOf(txtCantidad.getText()));

        if (cbtEntrada.isSelected() == true) {
            gestorListaCocina.getListaDespensa().editarEntrada(row, alm);
            jTable1.setModel(gestorListaCocina.obtenerListaEntradas(jTable1, "", 0));
        } else {
            gestorListaCocina.getListaDespensa().editarBaja(row, alm);
            jTable1.setModel(gestorListaCocina.obtenerListaEntradas(jTable1, "", 0));
        }

        gestorListaCocina.mensaje("Productos modificado Corretamente", "Almacen",0);
        ban = false;
        btnAdd.setText("Añadir");
        txtCantidad.setText("");
        cbtEntrada1.setEnabled(true);
        cbtBajas1.setEnabled(true);
    }

    private void obtenerDatos() {
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/YYYY");
        Date dat = dtcFecha.getDate();
        String fech;
        try {
            fech = fecha.format(dat);
            System.out.println(dat.toString());
        } catch (Exception e) {
            fech = "";
        }

        if (fech.length() < 10) {
            fech = "";
        }

        if (cbtEntrada.isSelected() == true) {
            jTable1.setModel(
                    gestorListaCocina.obtenerListaEntradas(
                            jTable1, fech,
                            cbxProducto.getSelectedIndex()
                    )
            );
        } else {
            jTable1.setModel(
                    gestorListaCocina.obtenerListaBaja(
                            jTable1, fech,
                            cbxProducto.getSelectedIndex()
                    )
            );
        }

    }

    public void llenarComboBox() {
        cbxProducto.removeAllItems();
        cbxProducto1.removeAllItems();
        cbxProducto.addItem("Todos los productos");
        gestorListaCocina.getListaProducto().listaBoxProductosMedida(cbxProducto);
        gestorListaCocina.getListaProducto().listaBoxProductosMedida(cbxProducto1);
        jTable1.setModel(gestorListaCocina.obtenerListaEntradas(jTable1, "", 0));
    }

    public void observer(Observer ven) {
        vis.addObserver(ven);
    }

    public void prueba() {
        Despensa alm;
        llenarComboBox();

        double cant[] = new double[]{5, 10, 5, 5, 5, 5, 3, 7, 9, 20, 300, 10, 1, 5, 5, 14, 128, 38, 26, 10, 8};

        for (int i = 0; i < cbxProducto1.getItemCount(); i++) {
            alm = new Despensa();
            alm.setProducto(gestorListaCocina.getListaProducto().getListaProducto().get(i));
            alm.setCantidad(Double.valueOf(cant[i] + ""));
            gestorListaCocina.getListaDespensa().agregarAlmacen(alm);
        }

        cant = new double[]{0, 205.5, 0, 300.25, 300, 0, 0, 0, 150, 8, 0, 9, 0, 180, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < cbxProducto1.getItemCount(); i++) {
            alm = new Despensa();
            alm.setProducto(gestorListaCocina.getListaProducto().getListaProducto().get(i));
            alm.setCantidad(Double.valueOf(cant[i] + ""));
            gestorListaCocina.getListaDespensa().agregarBaja(alm);
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
            java.util.logging.Logger.getLogger(VentanaDespensa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDespensa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDespensa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDespensa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDespensa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox cbtBajas;
    private javax.swing.JCheckBox cbtBajas1;
    private javax.swing.JCheckBox cbtEntrada;
    private javax.swing.JCheckBox cbtEntrada1;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JComboBox<String> cbxProducto1;
    private com.toedter.calendar.JDateChooser dtcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem minEditar;
    private javax.swing.JMenuItem minRem;
    private javax.swing.JMenuItem minRemAll;
    private javax.swing.JPopupMenu popumenu;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
