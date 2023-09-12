
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sebastian
 */
public class ventanaSudoku extends JDialog {

    private static final long serialVersionUID = 1L;

    private JTextField txtA11, txtA12, txtA13, txtA21, txtA22, txtA23, txtA31, txtA32, txtA33, txtB14, txtB15, txtB16, txtB24, txtB25, txtB26, txtB34, txtB35, txtB36, txtC17, txtC18, txtC19, txtC27, txtC28, txtC29, txtC37, txtC38, txtC39, txtD41, txtD42, txtD43, txtD51, txtD52, txtD53, txtD61, txtD62, txtD63, txtE44, txtE45, txtE46, txtE54, txtE55, txtE56, txtE64, txtE65, txtE66, txtF47, txtF48, txtF49, txtF57, txtF58, txtF59, txtF67, txtF68, txtF69, txtG71, txtG72, txtG73, txtG81, txtG82, txtG83, txtG91, txtG92, txtG93, txtH74, txtH75, txtH76, txtH84, txtH85, txtH86, txtH94, txtH95, txtH96, txtI77, txtI78, txtI79, txtI87, txtI88, txtI89, txtI97, txtI98, txtI99;

    private int matriz[][];
    private JLabel lblTitulo;
    int nn = 0;

    private JButton btnIniciar,btnSalir,btnLimpiar;

    public ventanaSudoku() {

        btnIniciar = new JButton();
        btnSalir = new JButton();
        btnLimpiar = new JButton();
        lblTitulo = new JLabel();
        matriz = new int[9][9];
        txtA11 = new JTextField();
        txtA12 = new JTextField();
        txtA13 = new JTextField();
        txtA21 = new JTextField();
        txtA22 = new JTextField();
        txtA23 = new JTextField();
        txtA31 = new JTextField();
        txtA32 = new JTextField();
        txtA33 = new JTextField();
        txtB14 = new JTextField();
        txtB15 = new JTextField();
        txtB16 = new JTextField();
        txtB24 = new JTextField();
        txtB25 = new JTextField();
        txtB26 = new JTextField();
        txtB34 = new JTextField();
        txtB35 = new JTextField();
        txtB36 = new JTextField();
        txtC17 = new JTextField();
        txtC18 = new JTextField();
        txtC19 = new JTextField();
        txtC27 = new JTextField();
        txtC28 = new JTextField();
        txtC29 = new JTextField();
        txtC37 = new JTextField();
        txtC38 = new JTextField();
        txtC39 = new JTextField();
        txtD41 = new JTextField();
        txtD42 = new JTextField();
        txtD43 = new JTextField();
        txtD51 = new JTextField();
        txtD52 = new JTextField();
        txtD53 = new JTextField();
        txtD61 = new JTextField();
        txtD62 = new JTextField();
        txtD63 = new JTextField();
        txtE44 = new JTextField();
        txtE45 = new JTextField();
        txtE46 = new JTextField();
        txtE54 = new JTextField();
        txtE55 = new JTextField();
        txtE56 = new JTextField();
        txtE64 = new JTextField();
        txtE65 = new JTextField();
        txtE66 = new JTextField();
        txtF47 = new JTextField();
        txtF48 = new JTextField();
        txtF49 = new JTextField();
        txtF57 = new JTextField();
        txtF58 = new JTextField();
        txtF59 = new JTextField();
        txtF67 = new JTextField();
        txtF68 = new JTextField();
        txtF69 = new JTextField();
        txtG71 = new JTextField();
        txtG72 = new JTextField();
        txtG73 = new JTextField();
        txtG81 = new JTextField();
        txtG82 = new JTextField();
        txtG83 = new JTextField();
        txtG91 = new JTextField();
        txtG92 = new JTextField();
        txtG93 = new JTextField();
        txtH74 = new JTextField();
        txtH75 = new JTextField();
        txtH76 = new JTextField();
        txtH84 = new JTextField();
        txtH85 = new JTextField();
        txtH86 = new JTextField();
        txtH94 = new JTextField();
        txtH95 = new JTextField();
        txtH96 = new JTextField();
        txtI77 = new JTextField();
        txtI78 = new JTextField();
        txtI79 = new JTextField();
        txtI87 = new JTextField();
        txtI88 = new JTextField();
        txtI89 = new JTextField();
        txtI97 = new JTextField();
        txtI98 = new JTextField();
        txtI99 = new JTextField();

        configurarComponentes();
        procesarEventos();

    }

    private void configurarComponentes() {
        Container conPrincipal;

        conPrincipal = getContentPane();//obtener el area del contenido de la ventana
        conPrincipal.setBackground(new Color(159, 159, 0));
        setLayout(null);//desabilitar los conponetes por defetos
        
        lblTitulo.setText("SUDOKU");
        lblTitulo.setBounds(250, 25, 590, 45);
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 27));

        txtA11.setBounds(100, 125, 35, 35);
        txtA11.setText("");

        txtA12.setBounds(135, 125, 35, 35);
        txtA13.setBounds(170, 125, 35, 35);
        txtA21.setBounds(100, 160, 35, 35);
        txtA22.setBounds(135, 160, 35, 35);
        txtA23.setBounds(170, 160, 35, 35);
        txtA31.setBounds(100, 195, 35, 35);
        txtA32.setBounds(135, 195, 35, 35);
        txtA33.setBounds(170, 195, 35, 35);

        txtB14.setBounds(205, 125, 35, 35);
        txtB14.setBackground(new Color(12, 16, 190));
        txtB14.setForeground(new Color(255, 255, 255));
        txtB15.setBounds(240, 125, 35, 35);
        txtB15.setBackground(new Color(12, 16, 190));
        txtB15.setForeground(new Color(255, 255, 255));
        txtB16.setBounds(275, 125, 35, 35);
        txtB16.setBackground(new Color(12, 16, 190));
        txtB16.setForeground(new Color(255, 255, 255));
        txtB24.setBounds(205, 160, 35, 35);
        txtB24.setBackground(new Color(12, 16, 190));
        txtB24.setForeground(new Color(255, 255, 255));
        txtB25.setBounds(240, 160, 35, 35);
        txtB25.setBackground(new Color(12, 16, 190));
        txtB25.setForeground(new Color(255, 255, 255));
        txtB26.setBounds(275, 160, 35, 35);
        txtB26.setBackground(new Color(12, 16, 190));
        txtB26.setForeground(new Color(255, 255, 255));
        txtB34.setBounds(205, 195, 35, 35);
        txtB34.setBackground(new Color(12, 16, 190));
        txtB34.setForeground(new Color(255, 255, 255));
        txtB35.setBounds(240, 195, 35, 35);
        txtB35.setBackground(new Color(12, 16, 190));
        txtB35.setForeground(new Color(255, 255, 255));
        txtB36.setBounds(275, 195, 35, 35);
        txtB36.setBackground(new Color(12, 16, 190));
        txtB36.setForeground(new Color(255, 255, 255));

        txtC17.setBounds(310, 125, 35, 35);
        txtC18.setBounds(345, 125, 35, 35);
        txtC19.setBounds(380, 125, 35, 35);
        txtC27.setBounds(310, 160, 35, 35);
        txtC28.setBounds(345, 160, 35, 35);
        txtC29.setBounds(380, 160, 35, 35);
        txtC37.setBounds(310, 195, 35, 35);
        txtC38.setBounds(345, 195, 35, 35);
        txtC39.setBounds(380, 195, 35, 35);

        txtD41.setBounds(100, 230, 35, 35);
        txtD41.setBackground(new Color(12, 16, 190));
        txtD41.setForeground(new Color(255, 255, 255));
        txtD42.setBounds(135, 230, 35, 35);
        txtD42.setBackground(new Color(12, 16, 190));
        txtD42.setForeground(new Color(255, 255, 255));
        txtD43.setBounds(170, 230, 35, 35);
        txtD43.setBackground(new Color(12, 16, 190));
        txtD43.setForeground(new Color(255, 255, 255));
        txtD51.setBounds(100, 265, 35, 35);
        txtD51.setBackground(new Color(12, 16, 190));
        txtD51.setForeground(new Color(255, 255, 255));
        txtD52.setBounds(135, 265, 35, 35);
        txtD52.setBackground(new Color(12, 16, 190));
        txtD52.setForeground(new Color(255, 255, 255));
        txtD53.setBounds(170, 265, 35, 35);
        txtD53.setBackground(new Color(12, 16, 190));
        txtD53.setForeground(new Color(255, 255, 255));
        txtD61.setBounds(100, 300, 35, 35);
        txtD61.setBackground(new Color(12, 16, 190));
        txtD61.setForeground(new Color(255, 255, 255));
        txtD62.setBounds(135, 300, 35, 35);
        txtD62.setBackground(new Color(12, 16, 190));
        txtD62.setForeground(new Color(255, 255, 255));
        txtD63.setBounds(170, 300, 35, 35);
        txtD63.setBackground(new Color(12, 16, 190));
        txtD63.setForeground(new Color(255, 255, 255));

        txtE44.setBounds(205, 230, 35, 35);
        txtE45.setBounds(240, 230, 35, 35);
        txtE46.setBounds(275, 230, 35, 35);
        txtE54.setBounds(205, 265, 35, 35);
        txtE55.setBounds(240, 265, 35, 35);
        txtE56.setBounds(275, 265, 35, 35);
        txtE64.setBounds(205, 300, 35, 35);
        txtE65.setBounds(240, 300, 35, 35);
        txtE66.setBounds(275, 300, 35, 35);

        txtF47.setBounds(310, 230, 35, 35);
        txtF47.setBackground(new Color(12, 16, 190));
        txtF47.setForeground(new Color(255, 255, 255));
        txtF48.setBounds(345, 230, 35, 35);
        txtF48.setBackground(new Color(12, 16, 190));
        txtF48.setForeground(new Color(255, 255, 255));
        txtF49.setBounds(380, 230, 35, 35);
        txtF49.setBackground(new Color(12, 16, 190));
        txtF49.setForeground(new Color(255, 255, 255));
        txtF57.setBounds(310, 265, 35, 35);
        txtF57.setBackground(new Color(12, 16, 190));
        txtF57.setForeground(new Color(255, 255, 255));
        txtF58.setBounds(345, 265, 35, 35);
        txtF58.setBackground(new Color(12, 16, 190));
        txtF58.setForeground(new Color(255, 255, 255));
        txtF59.setBounds(380, 265, 35, 35);
        txtF59.setBackground(new Color(12, 16, 190));
        txtF59.setForeground(new Color(255, 255, 255));
        txtF67.setBounds(310, 300, 35, 35);
        txtF67.setBackground(new Color(12, 16, 190));
        txtF67.setForeground(new Color(255, 255, 255));
        txtF68.setBounds(345, 300, 35, 35);
        txtF68.setBackground(new Color(12, 16, 190));
        txtF68.setForeground(new Color(255, 255, 255));
        txtF69.setBounds(380, 300, 35, 35);
        txtF69.setBackground(new Color(12, 16, 190));
        txtF69.setForeground(new Color(255, 255, 255));

        txtG71.setBounds(100, 335, 35, 35);
        txtG72.setBounds(135, 335, 35, 35);
        txtG73.setBounds(170, 335, 35, 35);
        txtG81.setBounds(100, 370, 35, 35);
        txtG82.setBounds(135, 370, 35, 35);
        txtG83.setBounds(170, 370, 35, 35);
        txtG91.setBounds(100, 405, 35, 35);
        txtG92.setBounds(135, 405, 35, 35);
        txtG93.setBounds(170, 405, 35, 35);

        txtH74.setBounds(205, 335, 35, 35);
        txtH74.setBackground(new Color(12, 16, 190));
        txtH74.setForeground(new Color(255, 255, 255));
        txtH75.setBounds(240, 335, 35, 35);
        txtH75.setBackground(new Color(12, 16, 190));
        txtH75.setForeground(new Color(255, 255, 255));
        txtH76.setBounds(275, 335, 35, 35);
        txtH76.setBackground(new Color(12, 16, 190));
        txtH76.setForeground(new Color(255, 255, 255));
        txtH84.setBounds(205, 370, 35, 35);
        txtH84.setBackground(new Color(12, 16, 190));
        txtH84.setForeground(new Color(255, 255, 255));
        txtH85.setBounds(240, 370, 35, 35);
        txtH85.setBackground(new Color(12, 16, 190));
        txtH85.setForeground(new Color(255, 255, 255));
        txtH86.setBounds(275, 370, 35, 35);
        txtH86.setBackground(new Color(12, 16, 190));
        txtH86.setForeground(new Color(255, 255, 255));
        txtH94.setBounds(205, 405, 35, 35);
        txtH94.setBackground(new Color(12, 16, 190));
        txtH94.setForeground(new Color(255, 255, 255));
        txtH95.setBounds(240, 405, 35, 35);
        txtH95.setBackground(new Color(12, 16, 190));
        txtH95.setForeground(new Color(255, 255, 255));
        txtH96.setBounds(275, 405, 35, 35);
        txtH96.setBackground(new Color(12, 16, 190));
        txtH96.setForeground(new Color(255, 255, 255));

        txtI77.setBounds(310, 335, 35, 35);
        txtI78.setBounds(345, 335, 35, 35);
        txtI79.setBounds(380, 335, 35, 35);
        txtI87.setBounds(310, 370, 35, 35);
        txtI88.setBounds(345, 370, 35, 35);
        txtI89.setBounds(380, 370, 35, 35);
        txtI97.setBounds(310, 405, 35, 35);
        txtI98.setBounds(345, 405, 35, 35);
        txtI99.setBounds(380, 405, 35, 35);

        LimpiarSudoku();

        btnIniciar.setText("INICIAR");
        btnIniciar.setOpaque(true);
        btnIniciar.setBackground(new Color(196, 49, 6));
        btnIniciar.setForeground(new Color(255, 255, 255));
        btnIniciar.setFont(new Font("Andale Mono", Font.BOLD, 14));
        btnIniciar.setBounds(470, 150, 110, 55);
        
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setOpaque(true);
        btnLimpiar.setBackground(new Color(196, 49, 6));
        btnLimpiar.setForeground(new Color(255, 255, 255));
        btnLimpiar.setFont(new Font("Andale Mono", Font.BOLD, 14));
        btnLimpiar.setBounds(470, 270, 110, 55);
        
        btnSalir.setText("SALIR");
        btnSalir.setOpaque(true);
        btnSalir.setBackground(new Color(196, 49, 6));
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setFont(new Font("Andale Mono", Font.BOLD, 14));
        btnSalir.setBounds(470, 370, 110, 55);

//        valoresPrincipales();

        conPrincipal.add(btnIniciar);
        conPrincipal.add(btnSalir);
        conPrincipal.add(btnLimpiar);
        
        conPrincipal.add(lblTitulo);
        conPrincipal.add(txtA11);
        conPrincipal.add(txtA12);
        conPrincipal.add(txtA13);
        conPrincipal.add(txtA21);
        conPrincipal.add(txtA22);
        conPrincipal.add(txtA23);
        conPrincipal.add(txtA31);
        conPrincipal.add(txtA32);
        conPrincipal.add(txtA33);
        conPrincipal.add(txtB14);
        conPrincipal.add(txtB15);
        conPrincipal.add(txtB16);
        conPrincipal.add(txtB24);
        conPrincipal.add(txtB25);
        conPrincipal.add(txtB26);
        conPrincipal.add(txtB34);
        conPrincipal.add(txtB35);
        conPrincipal.add(txtB36);
        conPrincipal.add(txtC18);
        conPrincipal.add(txtC19);
        conPrincipal.add(txtC17);
        conPrincipal.add(txtC27);
        conPrincipal.add(txtC28);
        conPrincipal.add(txtC29);
        conPrincipal.add(txtC37);
        conPrincipal.add(txtC38);
        conPrincipal.add(txtC39);
        conPrincipal.add(txtD41);
        conPrincipal.add(txtD42);
        conPrincipal.add(txtD43);
        conPrincipal.add(txtD51);
        conPrincipal.add(txtD52);
        conPrincipal.add(txtD53);
        conPrincipal.add(txtD61);
        conPrincipal.add(txtD62);
        conPrincipal.add(txtD63);
        conPrincipal.add(txtE44);
        conPrincipal.add(txtE45);
        conPrincipal.add(txtE46);
        conPrincipal.add(txtE54);
        conPrincipal.add(txtE55);
        conPrincipal.add(txtE56);
        conPrincipal.add(txtE64);
        conPrincipal.add(txtE65);
        conPrincipal.add(txtE66);
        conPrincipal.add(txtF47);
        conPrincipal.add(txtF48);
        conPrincipal.add(txtF49);
        conPrincipal.add(txtF57);
        conPrincipal.add(txtF58);
        conPrincipal.add(txtF59);
        conPrincipal.add(txtF67);
        conPrincipal.add(txtF68);
        conPrincipal.add(txtF69);
        conPrincipal.add(txtG71);
        conPrincipal.add(txtG72);
        conPrincipal.add(txtG73);
        conPrincipal.add(txtG81);
        conPrincipal.add(txtG82);
        conPrincipal.add(txtG83);
        conPrincipal.add(txtG91);
        conPrincipal.add(txtG92);
        conPrincipal.add(txtG93);
        conPrincipal.add(txtH74);
        conPrincipal.add(txtH75);
        conPrincipal.add(txtH76);
        conPrincipal.add(txtH84);
        conPrincipal.add(txtH85);
        conPrincipal.add(txtH86);
        conPrincipal.add(txtH94);
        conPrincipal.add(txtH95);
        conPrincipal.add(txtH96);

        conPrincipal.add(txtI77);
        conPrincipal.add(txtI78);
        conPrincipal.add(txtI79);
        conPrincipal.add(txtI87);
        conPrincipal.add(txtI88);
        conPrincipal.add(txtI89);
        conPrincipal.add(txtI97);
        conPrincipal.add(txtI98);
        conPrincipal.add(txtI99);

        setSize(700, 550);//tamaño de la ventana(ancho,alto)
        setTitle("Ventana Sudoku");
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(false);
    }
    
    private void LimpiarSudoku(){
        txtA12.setText("");
        txtA13.setText("");
        txtA21.setText("");
        txtA22.setText("");
        txtA23.setText("");
        txtA31.setText("");
        txtA32.setText("");
        txtA33.setText("");
        txtB14.setText("");
        txtB15.setText("");
        txtB16.setText("");
        txtB24.setText("");
        txtB25.setText("");
        txtB26.setText("");
        txtB34.setText("");
        txtB35.setText("");
        txtB36.setText("");
        txtC17.setText("");
        txtC18.setText("");
        txtC19.setText("");
        txtC27.setText("");
        txtC28.setText("");
        txtC29.setText("");
        txtC37.setText("");
        txtC38.setText("");
        txtC39.setText("");
        txtD41.setText("");
        txtD42.setText("");
        txtD43.setText("");
        txtD51.setText("");
        txtD52.setText("");
        txtD53.setText("");
        txtD61.setText("");
        txtD62.setText("");
        txtD63.setText("");
        txtE44.setText("");
        txtE45.setText("");
        txtE46.setText("");
        txtE54.setText("");
        txtE55.setText("");
        txtE56.setText("");
        txtE64.setText("");
        txtE65.setText("");
        txtE66.setText("");
        txtF47.setText("");
        txtF48.setText("");
        txtF49.setText("");
        txtF57.setText("");
        txtF58.setText("");
        txtF59.setText("");
        txtF67.setText("");
        txtF68.setText("");
        txtF69.setText("");
        txtG71.setText("");
        txtG72.setText("");
        txtG73.setText("");
        txtG81.setText("");
        txtG82.setText("");
        txtG83.setText("");
        txtG91.setText("");
        txtG92.setText("");
        txtG93.setText("");
        txtH74.setText("");
        txtH75.setText("");
        txtH76.setText("");
        txtH84.setText("");
        txtH85.setText("");
        txtH86.setText("");
        txtH94.setText("");
        txtH95.setText("");
        txtH96.setText("");
        txtI77.setText("");
        txtI78.setText("");
        txtI79.setText("");
        txtI87.setText("");
        txtI88.setText("");
        txtI89.setText("");
        txtI97.setText("");
        txtI98.setText("");
        txtI99.setText("");
    }

    private int obtenerValor(String texto) {
        int valor;

        if (texto.equals("")) {
            valor = 0;
        } else {
            valor = Integer.parseInt(texto);
        }

        return valor;
    }

    private void iniciarBusqeda() {

        int vectorA[];
        int vectorB[];
        int vectorC[];
        int vectorD[];
        int vectorE[];
        int vectorF[];
        int vectorG[];
        int vectorH[];
        int vectorI[];

        vectorA = new int[9];
        vectorB = new int[9];
        vectorC = new int[9];
        vectorD = new int[9];
        vectorE = new int[9];
        vectorF = new int[9];
        vectorG = new int[9];
        vectorH = new int[9];
        vectorI = new int[9];

        vectorA[0] = obtenerValor(txtA11.getText());
        vectorA[1] = obtenerValor(txtA12.getText());
        vectorA[3] = obtenerValor(txtA21.getText());
        vectorA[2] = obtenerValor(txtA13.getText());
        vectorA[4] = obtenerValor(txtA22.getText());
        vectorA[5] = obtenerValor(txtA23.getText());
        vectorA[6] = obtenerValor(txtA31.getText());
        vectorA[7] = obtenerValor(txtA32.getText());
        vectorA[8] = obtenerValor(txtA33.getText());

        vectorB[0] = obtenerValor(txtB14.getText());
        vectorB[1] = obtenerValor(txtB15.getText());
        vectorB[2] = obtenerValor(txtB16.getText());
        vectorB[3] = obtenerValor(txtB24.getText());
        vectorB[4] = obtenerValor(txtB25.getText());
        vectorB[5] = obtenerValor(txtB26.getText());
        vectorB[6] = obtenerValor(txtB34.getText());
        vectorB[7] = obtenerValor(txtB35.getText());
        vectorB[8] = obtenerValor(txtB36.getText());

        vectorC[0] = obtenerValor(txtC17.getText());
        vectorC[1] = obtenerValor(txtC18.getText());
        vectorC[2] = obtenerValor(txtC19.getText());
        vectorC[3] = obtenerValor(txtC27.getText());
        vectorC[4] = obtenerValor(txtC28.getText());
        vectorC[5] = obtenerValor(txtC29.getText());
        vectorC[6] = obtenerValor(txtC37.getText());
        vectorC[7] = obtenerValor(txtC38.getText());
        vectorC[8] = obtenerValor(txtC39.getText());

        vectorD[0] = obtenerValor(txtD41.getText());
        vectorD[1] = obtenerValor(txtD42.getText());
        vectorD[2] = obtenerValor(txtD43.getText());
        vectorD[3] = obtenerValor(txtD51.getText());
        vectorD[4] = obtenerValor(txtD52.getText());
        vectorD[5] = obtenerValor(txtD53.getText());
        vectorD[6] = obtenerValor(txtD61.getText());
        vectorD[7] = obtenerValor(txtD62.getText());
        vectorD[8] = obtenerValor(txtD63.getText());


        vectorE[0] = obtenerValor(txtE44.getText());
        vectorE[1] = obtenerValor(txtE45.getText());
        vectorE[2] = obtenerValor(txtE46.getText());
        vectorE[3] = obtenerValor(txtE54.getText());
        vectorE[4] = obtenerValor(txtE55.getText());
        vectorE[5] = obtenerValor(txtE56.getText());
        vectorE[6] = obtenerValor(txtE64.getText());
        vectorE[7] = obtenerValor(txtE65.getText());
        vectorE[8] = obtenerValor(txtE66.getText());

        vectorF[0] = obtenerValor(txtF47.getText());
        vectorF[1] = obtenerValor(txtF48.getText());
        vectorF[2] = obtenerValor(txtF49.getText());
        vectorF[3] = obtenerValor(txtF57.getText());
        vectorF[4] = obtenerValor(txtF58.getText());
        vectorF[5] = obtenerValor(txtF59.getText());
        vectorF[6] = obtenerValor(txtF67.getText());
        vectorF[7] = obtenerValor(txtF68.getText());
        vectorF[8] = obtenerValor(txtF69.getText());

        vectorG[0] = obtenerValor(txtG71.getText());
        vectorG[1] = obtenerValor(txtG72.getText());
        vectorG[2] = obtenerValor(txtG73.getText());
        vectorG[3] = obtenerValor(txtG81.getText());
        vectorG[4] = obtenerValor(txtG82.getText());
        vectorG[5] = obtenerValor(txtG83.getText());
        vectorG[6] = obtenerValor(txtG91.getText());
        vectorG[7] = obtenerValor(txtG92.getText());
        vectorG[8] = obtenerValor(txtG93.getText());

        vectorH[0] = obtenerValor(txtH74.getText());
        vectorH[1] = obtenerValor(txtH75.getText());
        vectorH[2] = obtenerValor(txtH76.getText());
        vectorH[3] = obtenerValor(txtH84.getText());
        vectorH[4] = obtenerValor(txtH85.getText());
        vectorH[5] = obtenerValor(txtH86.getText());
        vectorH[6] = obtenerValor(txtH94.getText());
        vectorH[7] = obtenerValor(txtH95.getText());
        vectorH[8] = obtenerValor(txtH96.getText());

        vectorI[0] = obtenerValor(txtI77.getText());
        vectorI[1] = obtenerValor(txtI78.getText());
        vectorI[2] = obtenerValor(txtI79.getText());
        vectorI[3] = obtenerValor(txtI87.getText());
        vectorI[4] = obtenerValor(txtI88.getText());
        vectorI[5] = obtenerValor(txtI89.getText());
        vectorI[6] = obtenerValor(txtI97.getText());
        vectorI[7] = obtenerValor(txtI98.getText());
        vectorI[8] = obtenerValor(txtI99.getText());

        llenarMatriz(1, 1, vectorA);
        llenarMatriz(1, 4, vectorB);
        llenarMatriz(1, 7, vectorC);
        llenarMatriz(4, 1, vectorD);
        llenarMatriz(4, 4, vectorE);
        llenarMatriz(4, 7, vectorF);
        llenarMatriz(7, 1, vectorG);
        llenarMatriz(7, 4, vectorH);
        llenarMatriz(7, 7, vectorI);

//        mostrarMatriz(1, 4, vectorB);
        //procesarSudoku();
        ejecutarPasos();
        ejecutarPasoCinco();
        nuevosDatos();
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
    
    
    

    public void valoresPrincipales() {
        txtA11.setText("7");
        txtA12.setText("2");
        txtA13.setText("");
        txtA21.setText("6");
        txtA22.setText("");
        txtA23.setText("");
        txtA31.setText("");
        txtA32.setText("");
        txtA33.setText("8");
        txtB14.setText("8");
        txtB15.setText("");
        txtB16.setText("");
        txtB24.setText("");
        txtB25.setText("");
        txtB26.setText("");
        txtB34.setText("");
        txtB35.setText("7");
        txtB36.setText("5");
        txtC17.setText("");
        txtC18.setText("");
        txtC19.setText("1");
        txtC27.setText("");
        txtC28.setText("3");
        txtC29.setText("");
        txtC37.setText("6");
        txtC38.setText("");
        txtC39.setText("");
        txtD41.setText("9");
        txtD42.setText("7");
        txtD43.setText("");
        txtD51.setText("");
        txtD52.setText("6");
        txtD53.setText("");
        txtD61.setText("3");
        txtD62.setText("8");
        txtD63.setText("");
        txtE44.setText("");
        txtE45.setText("");
        txtE46.setText("");
        txtE54.setText("");
        txtE55.setText("");
        txtE56.setText("");
        txtE64.setText("");
        txtE65.setText("");
        txtE66.setText("");
        txtF47.setText("");
        txtF48.setText("6");
        txtF49.setText("");
        txtF57.setText("7");
        txtF58.setText("");
        txtF59.setText("");
        txtF67.setText("");
        txtF68.setText("");
        txtF69.setText("2");
        txtG71.setText("");
        txtG72.setText("1");
        txtG73.setText("");
        txtG81.setText("8");
        txtG82.setText("9");
        txtG83.setText("");
        txtG91.setText("");
        txtG92.setText("");
        txtG93.setText("");
        txtH74.setText("");
        txtH75.setText("9");
        txtH76.setText("");
        txtH84.setText("");
        txtH85.setText("5");
        txtH86.setText("");
        txtH94.setText("");
        txtH95.setText("");
        txtH96.setText("");
        txtI77.setText("3");
        txtI78.setText("");
        txtI79.setText("");
        txtI87.setText("");
        txtI88.setText("");
        txtI89.setText("");
        txtI97.setText("5");
        txtI98.setText("");
        txtI99.setText("6");
    }

    

    public void llenarMatriz(int j, int i, int vec[]) {
        int n = 0;
        for (int k = j; k < (j + 3); k++) {
            for (int l = i; l < (i + 3); l++) {
                matriz[(k - 1)][(l - 1)] = vec[n];
                n++;
            }
        }

    }

    public void mostrarMatriz(int j, int i, int matrix[][]) {

        for (int k = j; k < (j + 3); k++) {
            for (int l = i; l < (i + 3); l++) {
                System.out.println("pos " + " [ " + (k) + "]" + " [ " + (l) + "]" + "= " + matrix[(k - 1)][(l - 1)]);

            }
        }

    }

    public String obtenerNumero(int fil, int col) {
        String aux;

        aux = String.valueOf(matriz[fil][col]);

        if (aux.equals("0")) {
            aux = "";
        }

        return aux;
    }

    public void nuevosDatos() {

        txtA11.setText(obtenerNumero(0, 0));
        txtA12.setText(obtenerNumero(0, 1));
        txtA13.setText(obtenerNumero(0, 2));
        txtA21.setText(obtenerNumero(1, 0));
        txtA22.setText(obtenerNumero(1, 1));
        txtA23.setText(obtenerNumero(1, 2));
        txtA31.setText(obtenerNumero(2, 0));
        txtA32.setText(obtenerNumero(2, 1));
        txtA33.setText(obtenerNumero(2, 2));

        txtB14.setText(obtenerNumero(0, 3));
        txtB15.setText(obtenerNumero(0, 4));
        txtB16.setText(obtenerNumero(0, 5));
        txtB24.setText(obtenerNumero(1, 3));
        txtB25.setText(obtenerNumero(1, 4));
        txtB26.setText(obtenerNumero(1, 5));
        txtB34.setText(obtenerNumero(2, 3));
        txtB35.setText(obtenerNumero(2, 4));
        txtB36.setText(obtenerNumero(2, 5));

        txtC17.setText(obtenerNumero(0, 6));
        txtC18.setText(obtenerNumero(0, 7));
        txtC19.setText(obtenerNumero(0, 8));
        txtC27.setText(obtenerNumero(1, 6));
        txtC28.setText(obtenerNumero(1, 7));
        txtC29.setText(obtenerNumero(1, 8));
        txtC37.setText(obtenerNumero(2, 6));
        txtC38.setText(obtenerNumero(2, 7));
        txtC39.setText(obtenerNumero(2, 8));

        txtD41.setText(obtenerNumero(3, 0));
        txtD42.setText(obtenerNumero(3, 1));
        txtD43.setText(obtenerNumero(3, 2));
        txtD51.setText(obtenerNumero(4, 0));
        txtD52.setText(obtenerNumero(4, 1));
        txtD53.setText(obtenerNumero(4, 2));
        txtD61.setText(obtenerNumero(5, 0));
        txtD62.setText(obtenerNumero(5, 1));
        txtD63.setText(obtenerNumero(5, 2));

        txtE44.setText(obtenerNumero(3, 3));
        txtE45.setText(obtenerNumero(3, 4));
        txtE46.setText(obtenerNumero(3, 5));
        txtE54.setText(obtenerNumero(4, 3));
        txtE55.setText(obtenerNumero(4, 4));
        txtE56.setText(obtenerNumero(4, 5));
        txtE64.setText(obtenerNumero(5, 3));
        txtE65.setText(obtenerNumero(5, 4));
        txtE66.setText(obtenerNumero(5, 5));

        txtF47.setText(obtenerNumero(3, 6));
        txtF48.setText(obtenerNumero(3, 7));
        txtF49.setText(obtenerNumero(3, 8));
        txtF57.setText(obtenerNumero(4, 6));
        txtF58.setText(obtenerNumero(4, 7));
        txtF59.setText(obtenerNumero(4, 8));
        txtF67.setText(obtenerNumero(5, 6));
        txtF68.setText(obtenerNumero(5, 7));
        txtF69.setText(obtenerNumero(5, 8));

        txtG71.setText(obtenerNumero(6, 0));
        txtG72.setText(obtenerNumero(6, 1));
        txtG73.setText(obtenerNumero(6, 2));
        txtG81.setText(obtenerNumero(7, 0));
        txtG82.setText(obtenerNumero(7, 1));
        txtG83.setText(obtenerNumero(7, 2));
        txtG91.setText(obtenerNumero(8, 0));
        txtG92.setText(obtenerNumero(8, 1));
        txtG93.setText(obtenerNumero(8, 2));

        txtH74.setText(obtenerNumero(6, 3));
        txtH75.setText(obtenerNumero(6, 4));
        txtH76.setText(obtenerNumero(6, 5));
        txtH84.setText(obtenerNumero(7, 3));
        txtH85.setText(obtenerNumero(7, 4));
        txtH86.setText(obtenerNumero(7, 5));
        txtH94.setText(obtenerNumero(8, 3));
        txtH95.setText(obtenerNumero(8, 4));
        txtH96.setText(obtenerNumero(8, 5));

        txtI77.setText(obtenerNumero(6, 6));
        txtI78.setText(obtenerNumero(6, 7));
        txtI79.setText(obtenerNumero(6, 8));
        txtI87.setText(obtenerNumero(7, 6));
        txtI88.setText(obtenerNumero(7, 7));
        txtI89.setText(obtenerNumero(7, 8));
        txtI97.setText(obtenerNumero(8, 6));
        txtI98.setText(obtenerNumero(8, 7));
        txtI99.setText(obtenerNumero(8, 8));

    }

    public static void main(String[] args) {
        ventanaSudoku sudoku = new ventanaSudoku();
        sudoku.setVisible(true);
    }

    public void procesarEventos() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }
        });

        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                iniciarBusqeda();

            }
        });
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                System.exit(0);

            }
        });
        
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                LimpiarSudoku();

            }
        });
    }

    public void ejecutarPasos() {

        ejecutarPasoDos();
        ejecutarPasoTres();
        ejecutarPasoCuatro();
        

    }

    public void ejecutarPasoDos() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        PasoNumeroDos pasoDos = new PasoNumeroDos();
        pasoDos.ejecutarPasDos(matriz);
        ban = compararMatrices(mat);

        matriz = pasoDos.getMatrizAux();

        if (ban == true) {
            ejecutarPasoDos();
        }

    }

    private int[][] obtenerdatosMatriz() {

        int mat[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                mat[j][i] = matriz[j][i];
            }
        }

        return mat;
    }

    public void ejecutarPasoTres() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        PasoTres pasoNumeroTres = new PasoTres();

        pasoNumeroTres.obtenerPasoTres(matriz);

        ban = compararMatrices(mat);

        matriz = pasoNumeroTres.getMatrizAux();

        if (ban) {
            ejecutarPasos();
        }

    }

    public void ejecutarPasoCuatro() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        PasoCuatro pasoNumeroCuatro = new PasoCuatro();
        pasoNumeroCuatro.ejecuutarPasoCuatro(matriz);

        ban = compararMatrices(mat);

        matriz = pasoNumeroCuatro.getMatrizAux();

        if (ban) {
            ejecutarPasos();
        }

        
    }
    
    public void ejecutarPasoCinco() {
        boolean ban;
        int mat[][] = obtenerdatosMatriz();
        PasoCinco pasoNumeroCinco = new PasoCinco();
        pasoNumeroCinco.ejecuutarPasoCinco(matriz);

        ban = compararMatrices(mat);

        matriz = pasoNumeroCinco.getMatrizAux();

        
    }

    public boolean compararMatrices(int mat[][]) {
        boolean ban = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

//                System.out.println(j+""+i+"  matris 1 "+mat[j][i]+"  matris 2 "+ matriz[j][i]);
                if (mat[j][i] != matriz[j][i]) {

                    ban = true;
                }
            }
        }

        return ban;
    }

}
