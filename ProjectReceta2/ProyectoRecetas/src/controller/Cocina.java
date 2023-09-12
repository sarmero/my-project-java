/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Componente.CeldaRenderer;
import Componente.CeldaRendererCbx;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import model.ExportarImportar;
import model.Foto;
import model.Producto;
import model.ProductoPedido;
import model.ProductoReceta;
import model.Receta;

/**
 *
 * @author USER
 */
public class Cocina extends Opcion implements Serializable {

    private static final long serialVersionUID = 0x1C8E3CA;

    private ListaCategoria listaCategoria;
    private ListaProducto listaProducto;
    private ListaAlbum listaAlbum;
    private ListaPedido listaPedido;
    private ListaDespensa listaDespensa;
    private ArrayList<Object[]> inventario;
    private ListaCliente listaCliente;

    public Cocina() {
        listaCategoria = new ListaCategoria();
        listaProducto = new ListaProducto();
        listaAlbum = new ListaAlbum();
        listaPedido = new ListaPedido();
        listaDespensa = new ListaDespensa();
        sc = new StyleContext();
        inventario = new ArrayList<>();
        listaCliente = new ListaCliente();
        listaCategoria.listaProducto(listaProducto);
        listaPedido.setListaCategoria(listaCategoria);
        listaPedido.setListaProducto(listaProducto);
        listaPedido.setListaCliente(listaCliente);

    }

    public ListaCliente getListaCliente() {
        return listaCliente;
    }

    public ListaProducto getListaProducto() {
        return listaProducto;
    }

    public ListaAlbum getListaAlbum() {
        return listaAlbum;
    }

    public ListaPedido getListaPedido() {
        return listaPedido;
    }

    public ListaDespensa getListaDespensa() {
        return listaDespensa;
    }

    public ListaCategoria getListaCategoria() {
        return listaCategoria;
    }

    public void cargarInventario() {
        inventario();
    }

    public void precargarRecetaPedido() {
        listaCategoria.precargarReceta();
    }

    public void precargarDespensa() {
        listaDespensa.precargarDespensa();
    }

    public void precargarPedidos() {
        listaPedido.precargarPediddos();
    }

    public ArrayList<Object[]> obtenerClientePedido(String cliente) {
        int cod = listaCliente.obtenerCodigoCliente(cliente);
        ArrayList<Object[]> list = listaPedido.obtenerPedidoCliente(cod);
        return list;
    }

    public ArrayList<Object[]> obtenerPedidosPendiente() {
        ArrayList<Object[]> ped = listaPedido.pedidosPenndientes();
        ordenarArrayFecha(ped, 3);
        return ped;
    }

    public DefaultTableModel obtenerTablaRecetaProductos(JTable jTable1, int indCocina, int indReceta, double medida) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> pro = listaCategoria.obtenerRecetaProductos(indCocina, indReceta, medida);

        ordenarArrayObjectString(pro, 0);

        pro.stream().forEach(pedido -> {
            modelo.addRow(pedido);
        });

        return modelo;
    }

    public DefaultTableModel obtenerTablaRecetaImportado(JTable jTable1, Receta receta) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> pro = listaCategoria.recetaProductos(receta, receta.getCantidad());

        pro.stream().forEach(pedido -> {
            modelo.addRow(pedido);
        });

        return modelo;
    }

    public DefaultTableModel obtenerTablaReceta(JTable jTable1, int indCocina) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> pro = listaCategoria.obtenerReceta(indCocina);

        pro.stream().forEach(receta -> {
            modelo.addRow(receta);
        });

        return modelo;
    }

    public DefaultTableModel obtenerTablaOtProducto(JTable jTable1, int idxVenta) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> list = otProductoList(listaPedido.getListaPedido().get(idxVenta).getOtProductos(), false);

        list.forEach(otProd -> {
            modelo.addRow(otProd);
        });

        return modelo;
    }

    public DefaultTableModel formatTablaOtProducto(DefaultTableModel modelo) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(formatoNumero((double) modelo.getValueAt(i, 1)), i, 1);
            modelo.setValueAt(formatContabilidad((double) modelo.getValueAt(i, 2)), i, 2);
        }

        return modelo;
    }

    public DefaultTableModel obtenerTablaOtProductoFoto(JTable jTable1, int idxAlbum, String ruta) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> list = otProductoList(listaAlbum.getListaAlbum().get(idxAlbum).obtenerOtProducto(ruta), false);

        list.stream().forEach((otProd) -> {
            modelo.addRow(otProd);
        });

        return modelo;
    }

    public ArrayList<Object[]> obtenerListaOtProducto(int idxPedido) {
        return otProductoList(listaPedido.getListaPedido().get(idxPedido).getOtProductos(), true);
    }

    public ArrayList<Object[]> obtenerListaOtProducto(int idxAlbum, String ruta) {
        return otProductoList(listaAlbum.getListaAlbum().get(idxAlbum).obtenerOtProducto(ruta), true);
    }

    private ArrayList<Object[]> otProductoList(ArrayList<ProductoPedido> list, boolean format) {
        ArrayList<Object[]> pro = new ArrayList<>();
        list.stream().forEach((otProd) -> {
            Object[] otProducto = new Object[3];
            otProducto[0] = otProductoNombre(otProd.getCodProducto());
            otProducto[1] = format ? otProd.getCantidad() : formatoNumero((double) otProd.getCantidad());
            otProducto[2] = format ? otProd.getPrecio() : formatContabilidad((double) otProd.getPrecio());
            pro.add(otProducto);
        });

        ordenarArrayObjectString(pro, 0);

        return pro;
    }

    public ArrayList<ProductoPedido> ConvertirOtProducto(ArrayList<Object[]> list) {
        ArrayList<ProductoPedido> pro = new ArrayList<>();

        list.forEach((otProd) -> {
            ProductoPedido ot = new ProductoPedido();
            ot.setCodProducto(otProductoCodigo((String) otProd[0]));
            ot.setCantidad((double) otProd[1]);
            ot.setPrecio((double) otProd[2]);
            pro.add(ot);
        });
        return pro;
    }

    private String otProductoNombre(int codigo) {
        String pro = listaProducto.obtenerProductoNombre(codigo);
        String rece;

        if (pro == null) {
            rece = listaCategoria.obtenerRecetaNombre(codigo);
            if (rece == null) {
                return "No Existe";
            }

            return rece;
        } else {
            return pro;
        }
    }

    private int otProductoCodigo(String nom) {
        int pro = listaProducto.obtenerCodigoProducto(nom);
        int rece;

        if (pro == -1) {
            rece = listaCategoria.obtenerCodigoReceta(nom);
            if (rece == -1) {
                return -1;
            }

            return rece;
        } else {
            return pro;
        }
    }

    public DefaultTableModel obtenerTablaReporte(JTable jTable1, String receta, String ruta, int idx, double med) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> pro = new ArrayList();
        ArrayList<ProductoPedido> fot = null;
        ProductoPedido producto;
        Foto foto = new Foto();
        boolean ban;
        Object[] prod;

        double medida = 0;

        if (idx < 0) {
            for (int i = 0; i < listaAlbum.getListaAlbum().size(); i++) {
                foto = listaAlbum.getListaAlbum().get(i).obtenerFoto(ruta);
                if (foto != null) {
                    medida = foto.getMedReferencia();
                    fot = foto.getOtProductos();
                    break;
                }
            }
        } else {
            fot = listaPedido.getListaPedido().get(idx).getOtProductos();
            medida = med;
        }

        Receta rece = listaCategoria.obtenerReceta(receta);
        if (rece != null) {

            productoReporte(pro, rece, medida);
            String nomProd;

            for (int i = 0; i < fot.size(); i++) {
                producto = fot.get(i);
                ban = false;
                nomProd = otProductoNombre(producto.getCodProducto());

                for (int j = 0; j < pro.size(); j++) {
                    if (nomProd.equals(pro.get(j)[0])) {
                        pro.get(j)[1] = (double) pro.get(j)[1] + (double) producto.getCantidad();
                        ban = true;
                    }
                }

                if (ban == false) {
                    rece = listaCategoria.obtenerReceta(nomProd);
                    if (rece != null) {
                        productoReporte(pro, rece, (double) producto.getCantidad());
                    } else {
                        prod = new Object[3];
                        prod[0] = nomProd;
                        prod[1] = medida;
                        prod[2] = 0;
                        pro.add(prod);
                    }

                }
            }

            ordenarArrayObjectString(pro, 0);
        }

        for (int i = 0; i < pro.size(); i++) {
            for (int j = 0; j < inventario.size(); j++) {
                if (inventario.get(j)[0].equals((String) pro.get(i)[0])) {
                    prod = new Object[5];
                    prod[0] = pro.get(i)[0];
                    prod[1] = formatoNumero((double) pro.get(i)[1]);
                    prod[2] = formatContabilidad(listaProducto.obtenerCostoProducto((String) prod[0], (double) pro.get(i)[1]));
                    prod[3] = formatoNumero((double) inventario.get(j)[4]);
                    prod[4] = formatoNumero((double) inventario.get(j)[4] - (double) pro.get(i)[1]);
                    modelo.addRow(prod);
                }
            }

        }

        jTable1.getColumnModel().getColumn(4).setCellRenderer(new CeldaRenderer(4));

        return modelo;
    }

    private void productoReporte(ArrayList<Object[]> pro, Receta receta, double medida) {
        Object[] recet = listaCategoria.productosReceta(receta.getCodigo());
        ArrayList<Object[]> recePro;

        if (recet != null) {
            recePro = (ArrayList<Object[]>) recet[1];
            listaPedido.sumarProductos(pro, recePro, medida);
        }
    }

    public DefaultTableModel obtenerBienesFecha(JTable jTable1, String receta) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> ped = listaPedido.obtenerBienes(receta);

        ped.stream().forEach(pedido -> {
            modelo.addRow(pedido);
        });

        return modelo;

    }

    public ArrayList<Object[]> obtenerTablaVentas() {
        ArrayList<Object[]> ped = listaPedido.obtenerPedidos();
        ordenarArrayFecha(ped, 5);
        return ped;
    }

    public Object[] datosProductoReceta(String producto, double cantidad) {
        Object[] fila = new Object[2];
        Object[] pro = listaProducto.obtenerproducto(producto);

        fila[0] = pro[0];
        fila[1] = formatoNumero(cantidad);

        return fila;
    }

    public Object[] datosOtProductos(int sel, int rec, double can, String producto) {
        Object[] fila = new Object[3];
        Object[] rece;

        if (sel >= rec) {
            rece = listaProducto.obtenerproducto(producto);
            fila[2] = Double.valueOf((listaProducto.obtenerCostoProducto((String) rece[0], can)));
        } else {
            rece = listaCategoria.obtenerRecetaObject(producto);
            fila[2] = listaCategoria.obtenerCostoReceta(listaCategoria.obtenerReceta(producto)) * can;
        }

        fila[0] = rece[0];
        fila[1] = formatoNumero(can);
        fila[2] = formatContabilidad((double) fila[2]);

        return fila;
    }

    public Object[] obtenerDatosVenta(int idxVenta) {
        Object[] venta = listaPedido.obtenerVenta(idxVenta);
        Object[] ven = new Object[5];

        ven[0] = formatContabilidad((double) venta[8]);
        ven[1] = formatContabilidad((double) venta[2]);
        ven[2] = formatContabilidad((double) venta[2] - (double) venta[8]);
        ven[3] = venta[7];
        ven[4] = venta[6];

        return ven;
    }

    public String costoReporte(DefaultTableModel modelo, int col) {
        double n = 0;
        String costo;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            costo = (modelo.getValueAt(i, col) + "").replace(".", "");
            costo = costo.replace("$ ", "");
            costo = costo.replace(",", ".");
            n += Double.valueOf(costo);
        }

        return formatContabilidad(n);
    }

    public Object[] obtenerDatosReceta(int cat, int rec, double cantidad) {
        Object[] rece = new Object[5];
        Receta receta = listaCategoria.obtenerRecet(cat, rec);

        rece[0] = formatoNumero(receta.getCantidad()) + "g";
        rece[1] = receta.getRuta();
        rece[2] = formatContabilidad(listaCategoria.obtenerCostoReceta(receta) * cantidad);
        rece[4] = receta.getPreparacion();

        if (receta.isComplemento() == true) {
            rece[3] = "Añadidura";
        } else {
            rece[3] = "Base";
        }

        return rece;
    }

    public Receta obtenerReceta(ArrayList<Object[]> lista) {
        Receta rec;
        rec = new Receta();
        Object[] productos;

        for (int i = 0; i < lista.size(); i++) {
            productos = lista.get(i);
            rec.getProductos().add(new ProductoReceta((Integer) productos[0], Double.valueOf((String) productos[1])));
        }

        return rec;
    }

    public double costoOtProducto(ArrayList<Object[]> otProducto) {
        double valor = 0;
        for (int i = 0; i < otProducto.size(); i++) {
            valor += (double) otProducto.get(i)[2];
        }

        return valor;
    }

    public String costoPedido(int cat, int rec, double cantidad, ArrayList<Object[]> listaOtProducto) {
        Receta receta = listaCategoria.obtenerRecet(cat, rec);
        double costo = listaCategoria.obtenerCostoReceta(receta);

        System.out.println("");

        if (cantidad > 0) {
            costo = costo * cantidad;
        } else {
            costo = 0;
        }

        if (listaOtProducto.size() > 0) {
            costo += costoOtProducto(listaOtProducto);
        }

        return formatContabilidad(costo);
    }

    public DefaultTableModel obtenerListaEntradas(JTable jTable1, String fecha, int producto) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> list = listaDespensa.obtenerListaDespensa(true, fecha, producto, listaProducto);

        list.stream().forEach(pedido -> {
            modelo.addRow(pedido);
        });

        return modelo;
    }

    public DefaultTableModel obtenerListaBaja(JTable jTable1, String fecha, int producto) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        ArrayList<Object[]> list = listaDespensa.obtenerListaDespensa(false, fecha, producto, listaProducto);

        list.stream().forEach(pedido -> {
            modelo.addRow(pedido);
        });

        return modelo;
    }

    public DefaultTableModel obtenerListaInventario(JTable jTable1, int producto) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        Object[] inv;

        if (producto == 0) {
            for (int i = 0; i < inventario.size(); i++) {
                inv = new Object[5];
                inv[0] = inventario.get(i)[5];
                inv[1] = formatoNumero((double) inventario.get(i)[1]);
                inv[2] = formatoNumero((double) inventario.get(i)[2]);
                inv[3] = formatoNumero((double) inventario.get(i)[3]);
                inv[4] = formatoNumero((double) inventario.get(i)[4]);

                modelo.addRow(inv);
            }
        } else if (producto != 0) {
            for (int i = 0; i < inventario.size(); i++) {
                if (listaProducto.getListaProducto().get(producto - 1).getNombre().equals(inventario.get(i)[0])) {
                    inv = new Object[5];
                    inv[0] = inventario.get(i)[5];
                    inv[1] = formatoNumero((double) inventario.get(i)[1]);
                    inv[2] = formatoNumero((double) inventario.get(i)[2]);
                    inv[3] = formatoNumero((double) inventario.get(i)[3]);
                    inv[4] = formatoNumero((double) inventario.get(i)[4]);

                    modelo.addRow(inv);
                }
            }
        }

        jTable1.getColumnModel().getColumn(4).setCellRenderer(new CeldaRenderer(4));

        return modelo;
    }

    private String quitarMedidaProducto(String nom) {
        String nombre = "";
        nom = nom.replace(" (", "(");
        for (int j = 0; j < nom.length(); j++) {
            if (nom.charAt(j) == '(') {
                return nombre;
            } else {
                nombre += nom.charAt(j);
            }

        }
        return "";
    }

    public Object[] bienes() {
        Object[] bienes = new Object[6];
        bienes[0] = 0.0;
        bienes[1] = 0.0;
        bienes[3] = 0.0;
        bienes[4] = 0.0;

        String nombre = "";
        double pre = 0;

        for (int i = 0; i < inventario.size(); i++) {

            nombre = (String) inventario.get(i)[0];

            pre = (double) inventario.get(i)[3];
            bienes[3] = (double) bienes[3] + Double.valueOf(listaProducto.obtenerCostoProducto(nombre, pre).replace(",", "."));
            pre = (double) inventario.get(i)[4];
            bienes[4] = (double) bienes[4] + Double.valueOf(listaProducto.obtenerCostoProducto(nombre, pre).replace(",", "."));
        }

        for (int i = 0; i < listaPedido.getListaPedido().size(); i++) {
            if (listaPedido.getListaPedido().get(i).isEstado() == true) {
                bienes[0] = (double) bienes[0] + listaPedido.getListaPedido().get(i).getPrecioVenta();
                bienes[1] = (double) bienes[1] + listaPedido.getListaPedido().get(i).getValorGasto();
            }
        }

        bienes[2] = (double) bienes[0] - (double) bienes[1];
        bienes[5] = (double) bienes[4] + (double) bienes[2];

        for (int i = 0; i < 6; i++) {
            bienes[i] = formatContabilidad((double) bienes[i]);
        }

        return bienes;
    }

    private void inventario() {
        inventario = new ArrayList<>();
        Object[] inven;
        String nombre;

        for (int h = 0; h < listaProducto.getListaProducto().size(); h++) {
            inven = new Object[6];
            nombre = listaProducto.getListaProducto().get(h).getNombre();

            inven[0] = nombre;
            inven[1] = listaDespensa.productosDespensa(true, nombre);
            inven[2] = listaPedido.productosPedido(nombre);
            inven[3] = listaDespensa.productosDespensa(false, nombre);
            inven[4] = (double) inven[1] - (double) inven[2] - (double) inven[3];
            inven[5] = nombre + " (" + formatoNumero(listaProducto.getListaProducto().get(h).getContenido()) + "g)";

            inventario.add(inven);
        }
    }

    public DefaultTableModel obtenerListaProducto(JTable jTable1) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        Object[] producto;

        for (int i = 0; i < listaProducto.getListaProducto().size(); i++) {
            producto = listaProducto.obtenerproducto(i);
            if ((boolean) producto[5] == true) {
                producto[1] = formatoNumero((double) producto[1]);
                producto[2] = formatContabilidad((double) producto[2]);

                modelo.addRow(producto);
            }

        }

        return modelo;
    }

    public void exportarReceta(String nombre, String ruta) {
        ExportarImportar exp = new ExportarImportar();
        Receta receta = listaCategoria.obtenerReceta(nombre);
        receta.setCodigo(11);

        exp.setReceta(receta);

        for (int i = 0; i < receta.getProductos().size(); i++) {
            exp.getProductos().add(listaProducto.obtenerProducto(receta.getProductos().get(i).getCodProducto()));
        }

        exportar(exp, ruta);
    }

    public ExportarImportar importarReceta(String ruta) {
        return importar(ruta);
    }

    public DefaultTableModel obtenerProductosImportados(JTable jTable1, ExportarImportar imp) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        JComboBox cbxProducto = new JComboBox();
        cbxProducto.addItem("Crear nuevo Producto");

        listaProducto.getListaProducto().stream().forEach(pro -> {
            if (pro.isVigente() == true) {
                cbxProducto.addItem(pro.getNombre() + " (" + pro.getContenido() + ")g");
            }
        });

        cbxProducto.setSelectedIndex(0);

        jTable1.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cbxProducto));
        jTable1.setDefaultRenderer(Object.class, new CeldaRendererCbx(3));

        imp.getProductos().stream().forEach(produ -> {
            Object[] pro = new Object[4];
            pro[0] = produ.getNombre();
            pro[1] = produ.getContenido();
            pro[2] = produ.getPrecio();
            modelo.addRow(pro);
        });

        return modelo;
    }

    public Receta realizarCambiosReceta(ExportarImportar imp, ArrayList<String> list) {
        Receta receta = imp.getReceta();
        Producto producto;
        int codigo;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("Crear nuevo Producto")) {
                codigo = listaProducto.obtenerCodigoProducto(quitarMedidaProducto(list.get(i)));
                receta.getProductos().get(i).setCodProducto(codigo);
            } else {

                for (int j = 0; j < imp.getProductos().size(); j++) {
                    if (imp.getProductos().get(j).getCodigo() == receta.getProductos().get(i).getCodProducto()) {
                        producto = imp.getProductos().get(j);
                        producto.setVigente(true);
                        listaProducto.agregarProducto(producto);
                        break;
                    }
                }
            }
        }

        return receta;
    }

    public void formatoJtexPanel(JTextPane txa) {
        ArrayList<String> list = new ArrayList<>();
        formatoJtexPanelx(txa, Color.blue, listaProducto.listaProductos());
        formatoJtexPanelx(txa, Color.red, listaCategoria.listaRecetas());

        list.add(":");
        list.add("%");
        list.add("Paso");
        for (int i = 48; i <= 57; i++) {
            list.add(String.valueOf((char) i));
        }
        formatoJtexPanelx(txa, new Color(153, 153, 0), list);
    }

    public String productoDiseño(ArrayList<ProductoPedido> productos, ArrayList<Object[]> referencia, String fecha, double med) {
        String diseño = "\n\n------------------ Referencia -------------------------\n";

        for (int i = 0; i < referencia.size(); i++) {
            if ((boolean) referencia.get(i)[1] == true) {
                diseño += "* " + referencia.get(i)[0] + "\n";
            }
        }

        if (med >= 0) {
            diseño += "\n------------------ Productos del diseño -------------------\n";

            for (int i = 0; i < productos.size(); i++) {
                diseño += "* " + otProductoNombre(productos.get(i).getCodProducto()) + ": " + productos.get(i).getCantidad() + "\n";
            }

            diseño += "\n----------------------\nCantidad: " + med + "g\n----------------------\n";

        }

        diseño += "\n" + fecha;

        return diseño;
    }

    public Object[] vizualizarProducto(String producto) {
        Object[] prod = listaProducto.obtenerproducto(producto);
        if (prod != null) {
            prod[1] = formatoNumero((double) prod[1]) + "g";
            prod[2] = formatContabilidad((double) prod[2]);
            return prod;
        }
        return null;
    }

    public Object[] vizualizarPedido(int codigo) {
        Object[] ped = listaPedido.obtenerPedido(codigo);
        ped[2] = formatContabilidad((double) ped[2]);
        ped[3] = formatoNumero((double) ped[3]) + "g";
        return ped;
    }

    public Object[] vizualizarReceta(String receta) {
        Object[] ped = listaCategoria.obtenerRecetaObject(receta);
        if (ped != null) {
            ped[2] = formatContabilidad(listaCategoria.obtenerCostoReceta(listaCategoria.obtenerReceta(ped[0] + "")));
            ped[6] = formatoNumero((double) ped[6]) + "g";
            return ped;
        }
        return null;
    }

}
