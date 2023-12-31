/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmoremoney;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

/**
 *
 * @author Estudiante
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_more = new javax.swing.JLabel();
        lbl_send = new javax.swing.JLabel();
        lbl_money = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_Solucionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_more.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_more.setText("MORE");

        lbl_send.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_send.setText("SEND");

        lbl_money.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_money.setText("MONEY");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("+");

        jLabel1.setText("-----------------------");

        btn_Solucionar.setText("Solucionar");
        btn_Solucionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SolucionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_send)
                            .addComponent(lbl_money)
                            .addComponent(lbl_more))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_Solucionar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_send)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_more)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(lbl_money)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btn_Solucionar)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SolucionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SolucionarActionPerformed
        // TODO add your handling code here:
        Model model=new Model("SMM");
        //Variable y dominios
        IntVar S=model.intVar("S", 1, 9);
        IntVar E=model.intVar("E", 0, 9);
        IntVar N=model.intVar("N", 0, 9);
        IntVar D=model.intVar("D", 0, 9);
        IntVar M=model.intVar("M", 1, 9);
        IntVar O=model.intVar("O", 0, 9);
        IntVar R=model.intVar("R", 0, 9);
        IntVar Y=model.intVar("Y", 0, 9);
        
        IntVar[] variables=new IntVar[]{S,E,N,D,M,O,R,Y};
        //Restricciones
        
        
        int[] COEF=new int[]{
            1000,100,10,1,
            1000,100,10,1,
            -10000,-1000,-100,-10,-1
        };
        
        IntVar[] Var=new IntVar[]{
          S,E,N,D,
          M,O,R,E,
          M,O,N,E,Y
        };
        
        model.allDifferent(variables).post();
        model.scalar(Var, COEF, "=", 0).post();
        
        Solver s=model.getSolver();
        s.showStatistics();
        s.showSolutions();
        Solution sol=s.findSolution();
        
        String send=""+S.getValue()+E.getValue()+N.getValue()+D.getValue();
        String more=""+M.getValue()+O.getValue()+R.getValue()+E.getValue();
        String money=""+M.getValue()+O.getValue()+N.getValue()+E.getValue()+Y.getValue();
        
        lbl_send.setText(send);
        lbl_more.setText(more);
        lbl_money.setText(money);
        
        
    }//GEN-LAST:event_btn_SolucionarActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Solucionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_money;
    private javax.swing.JLabel lbl_more;
    private javax.swing.JLabel lbl_send;
    // End of variables declaration//GEN-END:variables
}
