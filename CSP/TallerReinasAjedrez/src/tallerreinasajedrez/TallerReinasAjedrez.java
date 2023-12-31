/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tallerreinasajedrez;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

/**
 *
 * @author Asus
 */
public class TallerReinasAjedrez extends javax.swing.JFrame {

    /**
     * Creates new form Ajedrez
     */
    
    JLabel[][] tablero;
    public TallerReinasAjedrez() {
        initComponents();
        tablero=new JLabel[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JLabel lbl=new JLabel();
                tablero[i][j]=lbl;
                lbl.setOpaque(true);
                Color color=(i+j)%2==0?Color.WHITE:Color.BLACK;
                lbl.setBackground(color);
                pnl_tablero.add(lbl);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Solucionar = new javax.swing.JButton();
        pnl_tablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Solucionar.setText("Solucionar");
        lbl_Solucionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_SolucionarActionPerformed(evt);
            }
        });
        getContentPane().add(lbl_Solucionar, java.awt.BorderLayout.PAGE_END);

        pnl_tablero.setLayout(new java.awt.GridLayout(8, 8));
        getContentPane().add(pnl_tablero, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_SolucionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_SolucionarActionPerformed
        // TODO add your handling code here:
        // TODO code application logic here
        Model model=new Model("8 Queens");
        
        //Variables y Dominios
        IntVar[][] Cij=new IntVar[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cij[i][j]=model.intVar(i+""+j,0, 1);
            }
        }
        //Restricciones
        //Filas
        for (int i = 0; i < 8; i++) {
            model.sum(Cij[i], "=", 1).post();
        }
        //Columnas
        for (int i = 0; i < 8; i++) {
            IntVar[] cols=new IntVar[8];
            for (int j = 0; j < 8; j++) {
                cols[j]=Cij[j][i];
            }
            model.sum(cols, "=", 1).post();
        }
        //Diagonales        
        for (int k = 0; k < 8; k++) {
            IntVar[] diag=new IntVar[8-k];
            int j=k;
            for (int i = 0; i < diag.length; i++) {
                diag[i]=Cij[i][j];
                System.out.print(i+""+j+",");
                j++;
            }
            System.out.println("");
            model.sum(diag, "<=", 1).post();
        }
        
        for (int k = 0; k < 8; k++) {
            IntVar[] diag=new IntVar[8-k];
            int j=k;
            for (int i = 0; i < diag.length; i++) {
                diag[i]=Cij[j][i];
                System.out.print(j+""+i+",");
                j++;
            }
            System.out.println("");
            model.sum(diag, "<=", 1).post();
        }
        
        //Diaganolas secundarias
        
        for (int k = 7; k >=0; k--) {
            IntVar[] diag=new IntVar[k+1];
            int j=k;
            for (int i = 0; i < diag.length; i++) {
                diag[i]=Cij[i][j];
                System.out.print(i+""+j+",");
                j--;
            }
            System.out.println("");
            model.sum(diag, "<=", 1).post();
        }
        
        for (int k = 0; k <8; k++) {
            IntVar[] diag=new IntVar[8-k];
            int j=k;
            for (int i = diag.length-1; i >=0 ; i--) {
                diag[i]=Cij[j][i+(8-diag.length)];
                System.out.print(j+""+(i+(8-diag.length))+",");
                j++;
            }
            System.out.println("");
            model.sum(diag, "<=", 1).post();
        }
        
        Solver s=model.getSolver();
        s.showStatistics();
        s.showSolutions();
        Solution sol=s.findSolution();
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Cij[i][j].getValue()==1){
                   JLabel lbl=tablero[i][j];
                   Color color=lbl.getBackground()==Color.WHITE?Color.BLACK:Color.WHITE;
                   lbl.setForeground(color);
                   lbl.setText("Q");
                   lbl.setFont(new Font("Serif", Font.PLAIN, 14));                  

                }
            }
        }
        
    }//GEN-LAST:event_lbl_SolucionarActionPerformed

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
            java.util.logging.Logger.getLogger(TallerReinasAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TallerReinasAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TallerReinasAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TallerReinasAjedrez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TallerReinasAjedrez().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton lbl_Solucionar;
    private javax.swing.JPanel pnl_tablero;
    // End of variables declaration//GEN-END:variables
}
