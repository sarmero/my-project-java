/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Componente.Vista;
import controller.ArchivoCocina;
import controller.Categoria;
import controller.Cocina;
import controller.ListaUsuario;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.ExportarImportar;
import model.Usuario;

/**
 *
 * @author USER
 */
public class VentanaPrincipal extends javax.swing.JFrame implements Observer {

    private ArchivoCocina gestorArchivoReceta;
    private Cocina gestorListaCocina;
    private VentanaRegistrarReceta ventanaRegistrarReceta;
    private VentanaProductos ventanaProducto;
    private VentanaRecetas ventanaReceta;
    private VentanaRegistrarPedido ventanaRegistrarVentas;
    private VentanaPedido ventanaVentas;
    private VentanaDespensa ventanaDespensa;
    private VentanaIventario ventanaInventario;
    private VentanaCategoria ventanaCategoria;
    private VentanaUsuario ventanaUsuario;
    private VentanaGaleria ventanaGaleria;
    private VentanaSubirImagen ventanaSubirImagen;
    private VentanaBienes ventanaBienes;
    private VentanaVisualisarPedido ventanaVisualisarPedido;
    private ArrayList<Integer> listCodigo;
    private VentanaClientes ventanaClientes;
    private VentanaRegistrarCliente ventanaRegistrarCliente;
    private Usuario user;
    private boolean atualizarUsuario;
    private ListaUsuario gestorListaUsuario;
    private VentanaCreditos ventanaCreditos;

    private boolean vent;
    private Vista vis;

    /**
     * Creates new form Principal
     */
    public void setGestorListaUsuario(ListaUsuario gestorListaUsuario, Usuario user) {
        this.gestorListaUsuario = gestorListaUsuario;
        ventanaUsuario.setGestorUsuario(gestorListaUsuario);
        ventanaUsuario.cargarUsuario(user);
        this.user = user;
        mostrarUsuario();
    }

    public VentanaPrincipal() {
        initComponents();
        ventanaRegistrarReceta = new VentanaRegistrarReceta();
        ventanaProducto = new VentanaProductos();
        ventanaReceta = new VentanaRecetas();
        ventanaRegistrarVentas = new VentanaRegistrarPedido();
        ventanaDespensa = new VentanaDespensa();
        ventanaInventario = new VentanaIventario();
        ventanaVentas = new VentanaPedido();
        ventanaCategoria = new VentanaCategoria();
        ventanaUsuario = new VentanaUsuario();
        ventanaGaleria = new VentanaGaleria();
        ventanaSubirImagen = new VentanaSubirImagen();
        ventanaBienes = new VentanaBienes();
        ventanaVisualisarPedido = new VentanaVisualisarPedido(this, true);
        ventanaClientes = new VentanaClientes();
        ventanaRegistrarCliente = new VentanaRegistrarCliente();
        ventanaCreditos = new VentanaCreditos(this, true);

        vent = false;
        vis = new Vista();
        atualizarUsuario = false;
    }

    public void gestorArchivo(String archivo, String rutaUser) {
        gestorArchivoReceta = new ArchivoCocina(archivo + ".dat");
        gestorArchivoReceta.leer();
        gestorListaCocina = gestorArchivoReceta.getListaCocina();
        gestorListaCocina.setRutaArchivo(rutaUser);
        gestorListaCocina.crearCarpetas();

        ventanaProducto.setGestorListaCocina(gestorListaCocina);
        ventanaRegistrarReceta.setGestorListaCocina(gestorListaCocina);
        ventanaReceta.setGestorListaCocina(gestorListaCocina);
        ventanaRegistrarVentas.setGestorListaCocina(gestorListaCocina);
        ventanaVentas.setGestorListaCocina(gestorListaCocina);
        ventanaDespensa.setGestorListaCocina(gestorListaCocina);
        ventanaInventario.setGestorListaCocina(gestorListaCocina);
        ventanaCategoria.setGestorListaCocina(gestorListaCocina);
        ventanaGaleria.setGestorListaCocina(gestorListaCocina);
        ventanaSubirImagen.setGestorListaCocina(gestorListaCocina);
        ventanaSubirImagen.crearAlbumnesPruebas();
        gestorListaCocina.getListaAlbum().precargarFoto();
        ventanaRegistrarVentas.setGaleria(ventanaGaleria);
        ventanaBienes.setGestorListaCocina(gestorListaCocina);
        ventanaVisualisarPedido.setGestorListaCocina(gestorListaCocina);
        ventanaRegistrarCliente.setGestorListaCocina(gestorListaCocina);
        ventanaClientes.setGestorListaCocina(gestorListaCocina);

        ventanaRegistrarCliente.pruebaCliente();
        ventanaProducto.pruebaProducto();
        ventanaRegistrarReceta.pruebaReceta();
        ventanaRegistrarVentas.pruebaVenta();
        ventanaDespensa.prueba();

//        gestorListaCocina.precargarRecetaPedido();
//        gestorListaCocina.precargarPedidos();
//        gestorListaCocina.precargarDespensa();
        gestorListaCocina.cargarInventario();

        obtenerPedidos();

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
        jPanel2 = new javax.swing.JPanel();
        lblUsuarioIcon = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menArchivo = new javax.swing.JMenu();
        miPerfil = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        minEntrada = new javax.swing.JMenuItem();
        minInventario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        minCocina = new javax.swing.JMenuItem();
        minBienes = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        minCategoria = new javax.swing.JMenuItem();
        menReceta = new javax.swing.JMenu();
        miReceta = new javax.swing.JMenuItem();
        miAddReceta = new javax.swing.JMenuItem();
        minImportar = new javax.swing.JMenuItem();
        minProducto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        miCerrar = new javax.swing.JMenuItem();
        minTema = new javax.swing.JMenu();
        minAcerca = new javax.swing.JMenuItem();

        setTitle("Pastelito");
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 191, 154));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(98, 50, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblUsuarioIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, 40, 40));

        lblNombre.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(204, 255, 204));
        lblNombre.setText("juan andres Perez Rodrigues");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 6, 342, -1));

        lblUsuario.setFont(new java.awt.Font("Comic Sans MS", 2, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(204, 255, 204));
        lblUsuario.setText("Invitado");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 30, 150, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imgFondo2.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, 570, 52));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(98, 50, 35));
        jLabel6.setText("Pedidos:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jTable2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(98, 50, 35));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Producto", "Cantidad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionBackground(new java.awt.Color(98, 50, 35));
        jTable2.setSelectionForeground(new java.awt.Color(255, 191, 154));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 570, 460));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imgFondoPrincipal.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 580));

        jMenuBar1.setBackground(new java.awt.Color(98, 50, 35));

        menArchivo.setBackground(new java.awt.Color(98, 50, 35));
        menArchivo.setForeground(new java.awt.Color(255, 191, 154));
        menArchivo.setText("Archivo");
        menArchivo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        miPerfil.setBackground(new java.awt.Color(98, 50, 35));
        miPerfil.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        miPerfil.setForeground(new java.awt.Color(255, 191, 154));
        miPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/user.png"))); // NOI18N
        miPerfil.setText("Usuario");
        miPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPerfilActionPerformed(evt);
            }
        });
        menArchivo.add(miPerfil);

        jMenu4.setBackground(new java.awt.Color(98, 50, 35));
        jMenu4.setForeground(new java.awt.Color(255, 191, 154));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/galeria.png"))); // NOI18N
        jMenu4.setText("Galeria");
        jMenu4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jMenuItem4.setBackground(new java.awt.Color(98, 50, 35));
        jMenuItem4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(255, 191, 154));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/album.png"))); // NOI18N
        jMenuItem4.setText("Album");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem3.setBackground(new java.awt.Color(98, 50, 35));
        jMenuItem3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 191, 154));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/subirImagen.png"))); // NOI18N
        jMenuItem3.setText("Subir imagen");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        menArchivo.add(jMenu4);
        menArchivo.add(jSeparator2);

        jMenu3.setBackground(new java.awt.Color(98, 50, 35));
        jMenu3.setForeground(new java.awt.Color(255, 191, 154));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/bodega.png"))); // NOI18N
        jMenu3.setText("Almacen");
        jMenu3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        minEntrada.setBackground(new java.awt.Color(98, 50, 35));
        minEntrada.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        minEntrada.setForeground(new java.awt.Color(255, 191, 154));
        minEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/despensa.png"))); // NOI18N
        minEntrada.setText("Despensa");
        minEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEntradaActionPerformed(evt);
            }
        });
        jMenu3.add(minEntrada);

        minInventario.setBackground(new java.awt.Color(98, 50, 35));
        minInventario.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        minInventario.setForeground(new java.awt.Color(255, 191, 154));
        minInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/Inventario.png"))); // NOI18N
        minInventario.setText("Inventario");
        minInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minInventarioActionPerformed(evt);
            }
        });
        jMenu3.add(minInventario);

        menArchivo.add(jMenu3);

        jMenu2.setBackground(new java.awt.Color(98, 50, 35));
        jMenu2.setForeground(new java.awt.Color(255, 191, 154));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/pedido.png"))); // NOI18N
        jMenu2.setText("Pedido");
        jMenu2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jMenuItem2.setBackground(new java.awt.Color(98, 50, 35));
        jMenuItem2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(255, 191, 154));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/mostrar.png"))); // NOI18N
        jMenuItem2.setText("Mostrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        minCocina.setBackground(new java.awt.Color(98, 50, 35));
        minCocina.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        minCocina.setForeground(new java.awt.Color(255, 191, 154));
        minCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/añadir.png"))); // NOI18N
        minCocina.setText("Añadir");
        minCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minCocinaActionPerformed(evt);
            }
        });
        jMenu2.add(minCocina);

        minBienes.setBackground(new java.awt.Color(98, 50, 35));
        minBienes.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        minBienes.setForeground(new java.awt.Color(255, 191, 154));
        minBienes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/bienes.png"))); // NOI18N
        minBienes.setText("Bienes");
        minBienes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minBienesActionPerformed(evt);
            }
        });
        jMenu2.add(minBienes);

        jMenu5.setBackground(new java.awt.Color(98, 50, 35));
        jMenu5.setForeground(new java.awt.Color(255, 191, 154));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/cliente.png"))); // NOI18N
        jMenu5.setText("Cliente");
        jMenu5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jMenuItem6.setBackground(new java.awt.Color(98, 50, 35));
        jMenuItem6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(255, 191, 154));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/añadir.png"))); // NOI18N
        jMenuItem6.setText("añadir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem5.setBackground(new java.awt.Color(98, 50, 35));
        jMenuItem5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(255, 191, 154));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/mostrar.png"))); // NOI18N
        jMenuItem5.setText("Mostrar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenu2.add(jMenu5);

        menArchivo.add(jMenu2);
        menArchivo.add(jSeparator4);

        jMenu1.setBackground(new java.awt.Color(98, 50, 35));
        jMenu1.setForeground(new java.awt.Color(255, 191, 154));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/categoria.png"))); // NOI18N
        jMenu1.setText("Categoria");
        jMenu1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(98, 50, 35));
        jMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 191, 154));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/mostrar.png"))); // NOI18N
        jMenuItem1.setText("Mostrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        minCategoria.setBackground(new java.awt.Color(98, 50, 35));
        minCategoria.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        minCategoria.setForeground(new java.awt.Color(255, 191, 154));
        minCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/añadir.png"))); // NOI18N
        minCategoria.setText("Añadir");
        minCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(minCategoria);

        menArchivo.add(jMenu1);

        menReceta.setBackground(new java.awt.Color(98, 50, 35));
        menReceta.setForeground(new java.awt.Color(255, 191, 154));
        menReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/receta.png"))); // NOI18N
        menReceta.setText("Receta");
        menReceta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        miReceta.setBackground(new java.awt.Color(98, 50, 35));
        miReceta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        miReceta.setForeground(new java.awt.Color(255, 191, 154));
        miReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/mostrar.png"))); // NOI18N
        miReceta.setText("Mostrar");
        miReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRecetaActionPerformed(evt);
            }
        });
        menReceta.add(miReceta);

        miAddReceta.setBackground(new java.awt.Color(98, 50, 35));
        miAddReceta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        miAddReceta.setForeground(new java.awt.Color(255, 191, 154));
        miAddReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/añadir.png"))); // NOI18N
        miAddReceta.setText("Añadir");
        miAddReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddRecetaActionPerformed(evt);
            }
        });
        menReceta.add(miAddReceta);

        minImportar.setBackground(new java.awt.Color(98, 50, 35));
        minImportar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        minImportar.setForeground(new java.awt.Color(255, 191, 154));
        minImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/importar.png"))); // NOI18N
        minImportar.setText("Importar");
        minImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minImportarActionPerformed(evt);
            }
        });
        menReceta.add(minImportar);

        menArchivo.add(menReceta);

        minProducto.setBackground(new java.awt.Color(98, 50, 35));
        minProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        minProducto.setForeground(new java.awt.Color(255, 191, 154));
        minProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/producto.png"))); // NOI18N
        minProducto.setText("Producto");
        minProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minProductoActionPerformed(evt);
            }
        });
        menArchivo.add(minProducto);
        menArchivo.add(jSeparator1);

        jMenuItem7.setBackground(new java.awt.Color(98, 50, 35));
        jMenuItem7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(255, 191, 154));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/guardar.png"))); // NOI18N
        jMenuItem7.setText("Guardar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menArchivo.add(jMenuItem7);

        miCerrar.setBackground(new java.awt.Color(98, 50, 35));
        miCerrar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        miCerrar.setForeground(new java.awt.Color(255, 191, 154));
        miCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/salir.png"))); // NOI18N
        miCerrar.setText("Cerrar");
        miCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarActionPerformed(evt);
            }
        });
        menArchivo.add(miCerrar);

        jMenuBar1.add(menArchivo);

        minTema.setBackground(new java.awt.Color(98, 50, 35));
        minTema.setForeground(new java.awt.Color(255, 191, 154));
        minTema.setText("Creditos");
        minTema.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        minAcerca.setBackground(new java.awt.Color(98, 50, 35));
        minAcerca.setForeground(new java.awt.Color(255, 191, 154));
        minAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Icon/acerca.png"))); // NOI18N
        minAcerca.setText("Acerca de");
        minAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAcercaActionPerformed(evt);
            }
        });
        minTema.add(minAcerca);

        jMenuBar1.add(minTema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miAddRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddRecetaActionPerformed
        ventanaRegistrarReceta.setVisible(true);
        ventanaRegistrarReceta.llenarcbx(this);
        vent = true;
        setVisible(false);
    }//GEN-LAST:event_miAddRecetaActionPerformed

    private void miRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRecetaActionPerformed
        ventanaReceta.setVisible(true);
        ventanaReceta.obtenerDatos(this);
        vent = true;
        setVisible(false);
    }//GEN-LAST:event_miRecetaActionPerformed

    private void minCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minCategoriaActionPerformed
        String respuesta;
        respuesta = JOptionPane.showInputDialog(
                null,
                "Escriba nombre de la Categoria",
                JOptionPane.QUESTION_MESSAGE
        );

        Categoria cocina = new Categoria();

        if (respuesta != null) {
            if (!respuesta.equals("")) {
                cocina.setCategoria(respuesta);
                gestorListaCocina.getListaCategoria().agregarCategoria(cocina);
                gestorListaCocina.mensaje("Categoria agregada Corretamente", "Categoria", 0);
            }
        }
    }//GEN-LAST:event_minCategoriaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int n = gestorListaCocina.mensajeConfirmar("Desea salir guardar los cambios", "Salir");

        if (n == 0) {
            gestorArchivoReceta.setListaCocina(gestorListaCocina);
            gestorArchivoReceta.escribir();
            vis.setBan(true);
        }else {
            vis.setBan(true);
        }

    }//GEN-LAST:event_formWindowClosing

    private void minCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minCocinaActionPerformed
        ventanaRegistrarVentas.setVisible(true);
        ventanaRegistrarVentas.llenarcbx(this);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_minCocinaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ventanaVentas.setVisible(true);
        ventanaVentas.llenarTabla();
        ventanaVentas.Observer(this, user);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void minEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minEntradaActionPerformed
        ventanaDespensa.setVisible(true);
        ventanaDespensa.llenarComboBox();
        ventanaDespensa.observer(this);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_minEntradaActionPerformed

    private void minInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minInventarioActionPerformed
        ventanaInventario.setVisible(true);
        ventanaInventario.llenarComboBox(this);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_minInventarioActionPerformed

    private void minProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minProductoActionPerformed
        ventanaProducto.obtenerProductos();
        ventanaProducto.setVisible(true);
        ventanaProducto.oservador(this, user);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_minProductoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ventanaCategoria.setVisible(true);
        ventanaCategoria.obtenerReceta();
        ventanaCategoria.observer(this);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void miPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPerfilActionPerformed
        ventanaUsuario.setVisible(true);
        ventanaUsuario.observer(this);
        setVisible(false);
        vent = true;
        atualizarUsuario = true;
    }//GEN-LAST:event_miPerfilActionPerformed

    private void minImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minImportarActionPerformed
        String ruta = gestorListaCocina.abrirArchivo("RXC Archivo", "rxc");
        System.out.println("ruta: " + ruta);
        if (!"".equals(ruta)) {
            ExportarImportar imp = gestorListaCocina.importarReceta(ruta);
            VentanaImportar ven = new VentanaImportar();
            ven.setGestorListaCocina(gestorListaCocina);
            ven.setVisible(true);
            ven.receta(imp, this);
            setVisible(false);
            vent = true;
        }

    }//GEN-LAST:event_minImportarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ventanaGaleria.setVisible(true);
        ventanaGaleria.llenarCombo(this);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ventanaSubirImagen.setVisible(true);
        ventanaSubirImagen.obtenerDatos(this);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void minBienesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minBienesActionPerformed
        ventanaBienes.setVisible(true);
        ventanaBienes.llenarcbx(this);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_minBienesActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (evt.getClickCount() == 2) {
            int row = jTable2.getSelectedRow();
            if (row >= 0) {
                ventanaVisualisarPedido.visualizarPedido(listCodigo.get(row));
                ventanaVisualisarPedido.setVisible(true);
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ventanaClientes.datos(this,user);
        ventanaClientes.setVisible(true);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ventanaRegistrarCliente.datos(this);
        ventanaRegistrarCliente.setVisible(true);
        setVisible(false);
        vent = true;
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        gestorArchivoReceta.setListaCocina(gestorListaCocina);
        gestorArchivoReceta.escribir();
        gestorListaCocina.mensaje("Guardado con exito", "Guardar", 0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void miCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarActionPerformed
        setVisible(false);
        vis.setBan(true);
    }//GEN-LAST:event_miCerrarActionPerformed

    private void minAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minAcercaActionPerformed
        ventanaCreditos.setVisible(true);
    }//GEN-LAST:event_minAcercaActionPerformed

    private void lookAndFeel(String nomStyle) {
        try {
            javax.swing.UIManager.setLookAndFeel(nomStyle);
            javax.swing.SwingUtilities.updateComponentTreeUI(VentanaPrincipal.this);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public void observer(Observer ven) {
        vis.addObserver(ven);
    }

    private void obtenerPedidos() {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setRowCount(0);
        listCodigo = new ArrayList<>();

        ArrayList<Object[]> ped = gestorListaCocina.obtenerPedidosPendiente();

        ped.stream().forEach(pedido -> {
            listCodigo.add((int) pedido[4]);
            pedido[0] = gestorListaCocina.getListaCliente().obtenerNombreCliente((int) pedido[0]);
            modelo.addRow(pedido);
        });

    }

    private void mostrarUsuario() {
        lblNombre.setText(user.getNombre() + " " + user.getNegocio());
        lblUsuario.setText(user.getNegocio());
        gestorListaUsuario.visualizadorImagen2(lblUsuarioIcon, user.getRutaImagen());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Boolean && vent == true) {
            setVisible(true);
            vent = false;
            obtenerPedidos();
            if (atualizarUsuario == true) {
                user = gestorListaUsuario.obtenerUsuario(user.getCodigo());
                mostrarUsuario();
                atualizarUsuario = false;
            }
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
            javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioIcon;
    private javax.swing.JMenu menArchivo;
    private javax.swing.JMenu menReceta;
    private javax.swing.JMenuItem miAddReceta;
    private javax.swing.JMenuItem miCerrar;
    private javax.swing.JMenuItem miPerfil;
    private javax.swing.JMenuItem miReceta;
    private javax.swing.JMenuItem minAcerca;
    private javax.swing.JMenuItem minBienes;
    private javax.swing.JMenuItem minCategoria;
    private javax.swing.JMenuItem minCocina;
    private javax.swing.JMenuItem minEntrada;
    private javax.swing.JMenuItem minImportar;
    private javax.swing.JMenuItem minInventario;
    private javax.swing.JMenuItem minProducto;
    private javax.swing.JMenu minTema;
    // End of variables declaration//GEN-END:variables

}
