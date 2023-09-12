/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Componente.MyIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import model.ExportarImportar;
import view.VentanaGaleria;

/**
 *
 * @author USER
 */
public abstract class Opcion {

    protected String rutaArchivo;
    protected static DecimalFormat formato = new DecimalFormat("#.##");
    protected SimpleAttributeSet attrs = new SimpleAttributeSet();
    protected StyleContext sc;
    protected DefaultStyledDocument doc;

    ;

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public static String format(double doobl) {
        return formato.format(doobl);
    }

    public void crearCarpetas() {
        crearDirectorio("Album");
        crearDirectorio("ImagenReceta");
        crearDirectorio("ImagenProducto");
        crearDirectorio("Temp");
    }

    protected void exportar(ExportarImportar exportar, String ruta) {
        ObjectOutputStream oos;
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(ruta);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(exportar);

            JOptionPane.showMessageDialog(null,
                    "Exportado con exito",
                    "Exportar",
                    JOptionPane.DEFAULT_OPTION, new MyIcon("/image/icon.png")
            );

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("error por archivo no listo");
        } catch (IOException ex) {
            System.out.println("error por convercion de objeto a bytes" + ex.getLocalizedMessage());
        }
    }

    protected ExportarImportar importar(String ruta) {
        ObjectInputStream ois;
        FileInputStream fis;

        try {
            fis = new FileInputStream(ruta);
            ois = new ObjectInputStream(fis);

            ExportarImportar auxiliar = (ExportarImportar) ois.readObject();

            if (auxiliar != null) {
                JOptionPane.showMessageDialog(null,
                        "Importado con exito",
                        "Exportar",
                        JOptionPane.DEFAULT_OPTION, new MyIcon("/image/icon.png")
                );

                return auxiliar;
            }

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Problema en la traducion de Objetos " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema en la convercion de Objetos");
        }

        return null;
    }

    public DefaultTableModel eliminarFila(JTable jTable1, ArrayList<Object[]> listPrecio, int row) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        listPrecio.remove(row);

        for (int i = 0; i < listPrecio.size(); i++) {
            modelo.addRow(listPrecio.get(i));
        }

        return modelo;
    }

    public DefaultTableModel editarMedidaFila(JTable jTable1, ArrayList<Object[]> listPrecio, int row, double med) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        listPrecio.get(row)[1] = med;

        for (int i = 0; i < listPrecio.size(); i++) {
            modelo.addRow(listPrecio.get(i));
        }

        return modelo;
    }

    public void eliminarFichero(String ru) {
        if (!ru.equals("")) {

            Path path = Paths.get(ru);

            try {
                Files.delete(path);
            } catch (IOException ex) {
                Logger.getLogger(Cocina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String copiarFichero(String nomFichero, String rutaFile, String carpeta) {

        String ruta = "";
        if (!rutaFile.equals("")) {

            ruta = crearDirectorio(carpeta);

            ruta = ruta + "/" + nomFichero + ".png";

            Path sourcePath = Paths.get(rutaFile);
            Path targetPath = Paths.get(ruta);

            try {
                Files.copy(sourcePath, targetPath);
            } catch (FileAlreadyExistsException ex) {
                System.out.println("The target path already has a target file");
            } catch (IOException exception) {
                System.out.format("I/O error: %s%n", exception);
            }
        }

        return ruta;
    }

    public String crearDirectorio(String nomDirectorio) {
        String ruta = rutaArchivo;

        ruta = ruta + nomDirectorio;

        File directorio = new File(ruta);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado en: " + ruta);
            } else {
                System.out.println("Error al crear directorio");
            }
        }

        return ruta;
    }

    public Image Icono() {
        Image icon = new ImageIcon(getClass().getResource("/image/icon2.png")).getImage();
        return icon;
    }

    public static String fecha() {
        Calendar c = Calendar.getInstance();
        String dia;
        String mes;
        if (c.get(Calendar.DATE) < 10) {
            dia = "0" + Integer.toString(c.get(Calendar.DATE));
        } else {
            dia = Integer.toString(c.get(Calendar.DATE));
        }

        if ((c.get(Calendar.MONTH) + 1) < 10) {
            mes = "0" + Integer.toString(c.get(Calendar.MONTH) + 1);
        } else {
            mes = Integer.toString(c.get(Calendar.MONTH) + 1);
        }

        String anio = Integer.toString(c.get(Calendar.YEAR));

        return (dia + "/" + mes + "/" + anio);
    }

    public void mensaje(String mensaje, String titulo, int n) {
        String icono;

        switch (n) {
            case 0:
                //confirmar
                icono = "/image/Icon/confirmar.png";
                break;
            case 1:
                //removido
                icono = "/image/Icon/remover.png";
                break;

            case 2:
                //Error 
                icono = "/image/Icon/error.png";
                break;
            case 3:
                //advertencia 
                icono = "/image/Icon/advertencia.png";
                break;
            default:
                //defaul;
                icono = "/image/icon.png";
                break;
        }

        JOptionPane.showMessageDialog(null,
                mensaje,
                titulo,
                JOptionPane.DEFAULT_OPTION, new MyIcon(icono)
        );

    }

    public int mensajeConfirmar(String mensaje, String titulo) {
        int ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, mensaje,
                titulo,
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        return ventanaYesNotCancel;
    }

    public KeyEvent consumir(KeyEvent evt, String txt) {
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros && key != 46) {
            evt.consume();
        }

        if (key == 46) {
            for (int i = 0; i < txt.length() - 1; i++) {
                if (txt.charAt(i) == '.') {
                    evt.consume();
                }
            }
        }

        return evt;
    }

    public KeyEvent consumir(KeyEvent evt) {
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        return evt;
    }

    public KeyEvent consumirSinEspacio(KeyEvent evt) {
        int key = evt.getKeyChar();

        if (key == 32) {
            evt.consume();
        }

        return evt;
    }

    public JLabel visualizadorImagen(JLabel lbl, String ruta) {
        lbl.setIcon(null);
        ImageIcon image;
        Icon icon;
        try {

            if (!ruta.equals("")) {
                image = new ImageIcon(ruta);
            } else {
                image = new ImageIcon("pastelito.png");
            }

            icon = new ImageIcon(
                    image.getImage().getScaledInstance(
                            lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT)
            );
            lbl.setIcon(icon);
            lbl.repaint();

            return lbl;

        } catch (Exception e) {

        }

        return lbl;
    }

    public JLabel visualizadorImagen2(JLabel lbl, String ruta) {
        lbl.setIcon(null);
        ImageIcon image;
        Icon icon;
        try {

            if (!ruta.equals("")) {
                image = new ImageIcon(getClass().getResource(ruta));
            } else {
                image = new ImageIcon("pastelito.png");
            }

            icon = new ImageIcon(
                    image.getImage().getScaledInstance(
                            lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT)
            );
            lbl.setIcon(icon);
            lbl.repaint();

            return lbl;

        } catch (Exception e) {

        }

        return lbl;
    }

    public JLabel colorBorde(JLabel lbl, Color color) {
        lbl.setBorder(javax.swing.BorderFactory.createLineBorder(color));
        lbl.repaint();
        return lbl;
    }

    public String abrirImagen() {
        JFileChooser jfile = new JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("PNG Images", "png");
        jfile.setAcceptAllFileFilterUsed(false);
        jfile.setFileFilter(imgFilter);

        int resultado = jfile.showOpenDialog(jfile);

        if (resultado != JFileChooser.CANCEL_OPTION) {

            File fileName = jfile.getSelectedFile();

            return fileName.getAbsolutePath();
        }

        return "";
    }

    public String abrirArchivo(String descripcion, String tipo) {
        JFileChooser jfile = new JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter(descripcion, tipo);
        jfile.setAcceptAllFileFilterUsed(false);
        jfile.setFileFilter(imgFilter);

        int resultado = jfile.showOpenDialog(jfile);

        if (resultado != JFileChooser.CANCEL_OPTION) {

            File fileName = jfile.getSelectedFile();

            return fileName.getAbsolutePath();
        }

        return "";
    }

    public String guardarArchivo(String descripcion, String tipo) {
        JFileChooser jfile = new JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter(descripcion, tipo);
        jfile.setAcceptAllFileFilterUsed(false);
        jfile.setFileFilter(imgFilter);

        int resultado = jfile.showSaveDialog(jfile);

        if (resultado != JFileChooser.CANCEL_OPTION) {

            File fileName = jfile.getSelectedFile();

            return fileName.getAbsolutePath();
        }

        return "";
    }

    /* devuelve una imagen de tamaño 100x100 VISTA PREVIA */
    public Icon imagenPrevia(ImageIcon foto, int dim, int dim2) {
        Image mini = foto.getImage().getScaledInstance(dim, dim2, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(mini);
    }

    /* devuelve la foto original, pero si el tamaño es mayor al contenedor, lo redimensiona */
    public Icon getFoto(Dimension d, ImageIcon foto) {

        //si la foto es mas grande que el contendor -> redimensionar
        if (foto.getIconWidth() > d.getWidth()) {
            float v = getValor(foto.getIconWidth(), d.width);
            return Disminuir(foto, v);
        } else if (foto.getIconHeight() > d.getHeight()) {
            float v = getValor(foto.getIconHeight(), d.height);
            return Disminuir(foto, v);
        } else {
            return foto;
        }

    }

    /* redimensiona la imagen en para que ingrese al contendor pero manteniendo sus proporciones*/
    private ImageIcon Disminuir(ImageIcon i, float v) {
        int valEscalaX = (int) (i.getIconWidth() * v);
        int valEscalaY = (int) (i.getIconHeight() * v);
        Image mini = i.getImage().getScaledInstance(valEscalaX, valEscalaY, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(mini);
    }

    /* devuelve el valor de escala para redimensionar la imagen*/
    private float getValor(int a, int b) {
        return Math.abs((a / new Float(b)) - 2f);
    }

    public void cambiarTamañoImage(String imagePathToRead,//direcion de la imagen a cargar
            String imagePathToWrite,//direcion donde se va a guardar
            int resizeWidth, int resizeHeight) {//los nuevos tamaño
        imagePathToWrite = rutaArchivo + imagePathToWrite;
        try {
            System.out.println("ruta " + imagePathToRead);
            File fileToRead = new File(imagePathToRead);
            BufferedImage bufferedImageInput = ImageIO.read(fileToRead);

            BufferedImage bufferedImageOutput = new BufferedImage(resizeWidth,
                    resizeHeight, bufferedImageInput.getType());

            Graphics2D g2d = bufferedImageOutput.createGraphics();
            g2d.drawImage(bufferedImageInput, 0, 0, resizeWidth, resizeHeight, null);
            g2d.dispose();

            String formatName = imagePathToWrite.substring(imagePathToWrite.lastIndexOf(".") + 1);

            ImageIO.write(bufferedImageOutput, formatName, new File(imagePathToWrite));

        } catch (IOException ex) {
            Logger.getLogger(Opcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int obtenerDiasFecha(String fecha) {
        int dia, mes, año;
        String[] fec = fecha.split("/");

        dia = Integer.valueOf(fec[0]);
        mes = Integer.valueOf(fec[1]);
        año = Integer.valueOf(fec[2]);

        return (365 * año) + obtenerDiasMes(mes) + dia;
    }

    public static int obtenerDiasMes(int mes) {
        int n = 0;
        for (int i = 0; i < mes; i++) {
            n = n + diasMeses(i);
        }
        return n;
    }

    private static int diasMeses(int mes) {

        switch (mes) {
            case 1:
                return 31;
            case 2:
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }

    private static String formatoNumero(String[] num) {

        String p = "";
        String m = "";
        String n = num[0];

        for (int i = 0; i < n.length(); i++) {
            if (i > 1 && ((i + 1) != n.length() || n.length() < 11)) {
                if (i % 3 == 0) {
                    m += ".";
                }
            }

            m += n.charAt(n.length() - 1 - i);

        }

        for (int i = 0; i < m.length(); i++) {
            p += m.charAt(m.length() - 1 - i);
        }

        if (num.length > 1) {
            p += "," + num[1];
        }

        return p;
    }

    public static String formatoNumero(double efe) {
        String[] num;
        String o = format(efe);
        num = o.split(",");
        String p;

        if (num.length > 1) {
            p = formatoNumero(num);
        } else {
            num[0] = o;
            p = formatoNumero(num);
        }

        return p;
    }

    public static String formatContabilidad(double efe) {
        String p = "$ " + formatoNumero(efe);
        return p;
    }

    public static String formatContabilidad(String efe) {
        String p = "$ " + formatoNumero(Double.valueOf(efe.replace(",", ".")));
        return p;
    }

    private ArrayList<Integer> idxPalabras(String txt, String bus) {
        int idx = 0;
        String tx;
        int sum;
        ArrayList<Integer> pos = new ArrayList<>();

        while (idx != -1) {

            idx = txt.indexOf(bus);

            if (idx >= 0) {
                pos.add(idx);
                sum = idx + bus.length();
                tx = "";

                for (int i = 0; i < txt.length(); i++) {
                    if (i >= idx && i < sum) {
                        tx += "+";
                    } else {
                        tx += txt.charAt(i);
                    }
                }

                txt = tx;
            }
        }

        return pos;
    }

    private String cambiarToMinuscula(String txt) {
        int res;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) >= 65 && txt.charAt(i) <= 90) {
                res = (txt.charAt(i) + 32);
                txt = txt.replace(txt.charAt(i), (char) res);
            }
        }

        return txt;
    }

    protected void formatoJtexPanelx(JTextPane txa, Color color, ArrayList<String> list) {
        ArrayList<Integer> pos;
        int tam;

        for (int i = 0; i < list.size(); i++) {

            pos = idxPalabras(txa.getText(), list.get(i));

            for (int k = 0; k < 2; k++) {
                for (int j = 0; j < pos.size(); j++) {
                    tam = list.get(i).length();
                    Style sty = sc.addStyle("ConstantWidth", null);
                    StyleConstants.setForeground(sty, color);
                    txa.getStyledDocument().setCharacterAttributes(pos.get(j), tam, sty, false);
                }

                pos = idxPalabras(txa.getText(), cambiarToMinuscula(list.get(i)));
            }
        }
    }

    public static int codigo(ArrayList<Integer> list) {

        String codigo = "";
        Random mat = new Random();
        int cod = 0;
        boolean ban = true;

        while (ban == true) {

            for (int i = 0; i < 4; i++) {
                codigo = codigo + mat.nextInt(9);
            }
            cod = Integer.valueOf(codigo);
            ban = verificarCodigo(cod, list);

            if (ban == false) {
                break;
            } else {
                codigo = "";
            }
        }

        return cod;
    }

    private static boolean verificarCodigo(int codigo, ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == codigo) {
                return true;
            }
        }

        return false;
    }

    public static void ordenarArrayObjectString(ArrayList<Object[]> list, int idx) {
        list.sort((Object[] o1, Object[] o2) -> (o1[idx] + "").compareTo(o2[idx] + ""));
    }

    public static void ordenarArrayString(ArrayList<String> list) {
        list.sort((String o1, String o2) -> o1.compareTo(o2));
    }

    public static void ordenarArrayObject(ArrayList<Object[]> list, int idx) {
        list.sort((Object[] o1, Object[] o2) -> (o1[idx] + "").compareTo(o2[idx] + ""));
    }

    public static void ordenarArrayFecha(ArrayList<Object[]> list, int idx) {
        list.sort((Object[] o1, Object[] o2) -> new Integer(obtenerDiasFecha(o1[idx] + "")).compareTo(obtenerDiasFecha(o2[idx] + "")));
    }

    public static void ordenarArrayDouble(ArrayList<Object[]> list, int idx) {
        list.sort((Object[] o1, Object[] o2) -> new Double(o2[idx] + "").compareTo(Double.valueOf(o1[idx] + "")));
    }

    public static void ordenarArrayFechaRev(ArrayList<Object[]> list, int idx) {
        list.sort((Object[] o1, Object[] o2) -> new Integer(obtenerDiasFecha(o2[idx] + "")).compareTo(obtenerDiasFecha(o1[idx] + "")));
    }

}
