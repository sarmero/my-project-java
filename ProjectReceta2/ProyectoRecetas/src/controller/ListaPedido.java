/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Opcion.codigo;
import static controller.Opcion.fecha;
import static controller.Opcion.formatContabilidad;
import static controller.Opcion.formatoNumero;
import java.io.Serializable;
import java.util.ArrayList;
import model.Cliente;
import model.Pedido;
import model.Producto;
import model.ProductoPedido;

/**
 *
 * @author USER
 */
public class ListaPedido implements Serializable {

    private static final long serialVersionUID = 0x1C8E3AA;

    private ArrayList<Pedido> listaPedido;
    private ArrayList<Object[]> listaProductosPedidos;
    private ListaCategoria listaCategoria;
    private ListaProducto listaProducto;
    private ListaCliente listaCliente;

    public ListaPedido() {
        listaPedido = new ArrayList<>();
        listaCategoria = new ListaCategoria();
        listaProducto = new ListaProducto();
        listaProductosPedidos = new ArrayList<>();
        listaCliente = new ListaCliente();
    }

    public void setListaCategoria(ListaCategoria listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public void setListaProducto(ListaProducto listaProducto) {
        this.listaProducto = listaProducto;
    }

    public ArrayList<Pedido> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(ArrayList<Pedido> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public void setListaCliente(ListaCliente listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList<Object[]> pedidosPenndientes() {
        Object[] pedido;
        ArrayList<Object[]> ped = new ArrayList();

        for (int i = 0; i < listaPedido.size(); i++) {
            if (listaPedido.get(i).isEstado() == false) {
                pedido = new Object[5];

                pedido[0] = listaPedido.get(i).getCodCliente();
                pedido[1] = listaPedido.get(i).getReceta().getNombreReceta();
                pedido[2] = formatoNumero(listaPedido.get(i).getCantidad()) + "g";
                pedido[3] = listaPedido.get(i).getFechaEntrega();
                pedido[4] = listaPedido.get(i).getCodigo();

                ped.add(pedido);
            }
        }

        return ped;
    }

    public ArrayList<Object[]> obtenerBienes(String receta) {
        ArrayList<Object[]> ped = new ArrayList<>();

        Object[] bie;

        for (int i = 0; i < listaPedido.size(); i++) {

            if ((receta.equals(listaPedido.get(i).getReceta().getNombreReceta()) || "".equals(receta))
                    && listaPedido.get(i).isEstado() == true) {
                bie = new Object[6];
                bie[0] = listaPedido.get(i).getReceta().getNombreReceta();
                bie[1] = formatoNumero(listaPedido.get(i).getCantidad()) + "g";
                bie[2] = formatContabilidad(listaPedido.get(i).getValorGasto());
                bie[3] = formatContabilidad(listaPedido.get(i).getPrecioVenta());
                bie[4] = formatContabilidad(listaPedido.get(i).getPrecioVenta() - listaPedido.get(i).getValorGasto());
                bie[5] = listaPedido.get(i).getFechaEntrega();
                ped.add(bie);
            }
        }

        return ped;
    }

    public ArrayList<Object[]> obtenerPedidoCliente(int cliente) {
        ArrayList<Object[]> list = new ArrayList<>();
        Object[] ven;

        for (int i = 0; i < listaPedido.size(); i++) {
            if (listaPedido.get(i).getCodCliente() == cliente || cliente == 0 ) {
                ven = new Object[6];
                ven[0] = listaPedido.get(i).getCodCliente();
                ven[1] = listaPedido.get(i).getReceta().getNombreReceta();
                ven[2] = formatoNumero(listaPedido.get(i).getCantidad());
                ven[3] = formatContabilidad(listaPedido.get(i).getPrecioVenta());
                ven[4] = listaPedido.get(i).getFechaEntrega();
                ven[5] = listaPedido.get(i).getCodigo();
                list.add(ven);
            }
        }

        return list;
    }

    public ArrayList<Object[]> obtenerPedidos() {
        Object[] venta;
        Object[] ven;
        ArrayList<Object[]> ped = new ArrayList<>();

        for (int i = 0; i < listaPedido.size(); i++) {
            venta = listaPedido.get(i).Venta();
            ven = new Object[7];
            ven[0] = listaCliente.obtenerNombreCliente((int) venta[1]);
            ven[1] = venta[0];
            ven[2] = formatoNumero((double) venta[3]);
            ven[3] = venta[9];
            ven[5] = venta[10];
            ven[6] = venta[11];

            if ((boolean) venta[4] == true) {
                ven[4] = "Entregado";
            } else {
                ven[4] = "Pendiente";
            }

            ped.add(ven);
        }

        return ped;
    }

    public void cambiarEstado(int idx, boolean estado) {
        listaPedido.get(idx).setEstado(estado);
        if (estado == true) {
            listaProductosPedidos.set(idx, listaProductoPedido(listaPedido.get(idx)));
        } else {
            listaProductosPedidos.remove(idx);
        }

    }

    public Object[] obtenerVenta(int idxVenta) {
        return listaPedido.get(idxVenta).Venta();
    }

    public void agregarVenta(Pedido venta) {
        venta.setCodigo(codigo(listacodigo()));
        venta.setFechaPedido(fecha());
        listaPedido.add(venta);
        listaProductosPedidos.add(listaProductoPedido(venta));
    }

    private ArrayList<Integer> listacodigo() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < listaPedido.size(); i++) {
            list.add(listaPedido.get(i).getCodigo());
        }

        return list;
    }

    public void editarVenta(Pedido venta, int idxVenta) {
        venta.setFechaPedido(fecha());
        listaPedido.set(idxVenta, venta);
        listaProductosPedidos.set(idxVenta, listaProductoPedido(venta));
    }

    public void eliminarVenta(int idx) {
        listaPedido.remove(idx);
        listaProductosPedidos.remove(idx);
    }

    public void eliminarAllVenta() {
        listaPedido.removeAll(listaPedido);
        listaProductosPedidos.removeAll(listaProductosPedidos);
    }

    public Object[] obtenerPedido(int codigo) {
        Object[] vent;
        Cliente cli;
        for (int i = 0; i < listaPedido.size(); i++) {
            if (listaPedido.get(i).getCodigo() == codigo) {
                vent = listaPedido.get(i).Venta();
                cli = listaCliente.obtenerCliente((int) vent[1]);
                vent[1] = cli.getNombre();
                vent[6] = cli.getAvatar();
                return vent;
            }
        }
        return null;
    }

    public Object[] productoPedido(int codigo) {
        for (int i = 0; i < listaProductosPedidos.size(); i++) {
            if ((int) listaProductosPedidos.get(i)[0] == codigo) {
                return listaProductosPedidos.get(i);
            }
        }

        return null;
    }

    public void precargarPediddos() {
        listaProductosPedidos = new ArrayList<>();
        for (int i = 0; i < listaPedido.size(); i++) {
            if (listaPedido.get(i).isEstado() == true) {
                listaProductosPedidos.add(listaProductoPedido(listaPedido.get(i)));
            }
        }
    }

    private Object[] listaProductoPedido(Pedido pedido) {
        ArrayList<Object[]> list = new ArrayList<>();
        Object[] gasto;
        ProductoPedido pro;
        Producto prod;

        ArrayList<ProductoPedido> otPro = pedido.getOtProductos();
        String fecha = pedido.getFechaEntrega();
        listProductoRecetaPedido(list, pedido.getReceta().getCodigo(), pedido.getCantidad());

        for (int j = 0; j < otPro.size(); j++) {
            pro = otPro.get(j);
            prod = listaProducto.obtenerProducto(pro.getCodProducto());

            if (prod != null) {
                gasto = new Object[3];
                gasto[0] = prod.getNombre();
                gasto[1] = pro.getCantidad();
                gasto[2] = fecha;
                list.add(gasto);
            } else {
                listProductoRecetaPedido(list, pro.getCodProducto(), pro.getCantidad());
            }
        }

        Object[] ped = new Object[2];
        ped[0] = pedido.getCodigo();
        ped[1] = list;

        return ped;
    }

    private void listProductoRecetaPedido(ArrayList<Object[]> list, int codigo, double cantidad) {
        Object[] recet;
        ArrayList<Object[]> listProd = new ArrayList<>();
        recet = listaCategoria.productosReceta(codigo);
        if (recet != null) {
            listProd = (ArrayList<Object[]>) recet[1];
            sumarProductos(list, listProd, cantidad);
        }
    }

    public void sumarProductos(ArrayList<Object[]> list, ArrayList<Object[]> listProd, double cantidad) {
        Object[] gasto;
        boolean ban;
        for (int k = 0; k < listProd.size(); k++) {
            ban = false;
            for (int l = 0; l < list.size(); l++) {
                if (list.get(l)[0].equals(listProd.get(k)[0])) {
                    list.get(l)[1] = (double) list.get(l)[1] + (double) listProd.get(k)[1] * cantidad;
                    ban = true;
                    break;
                }
            }

            if (ban == false) {
                gasto = new Object[3];
                gasto[0] = listProd.get(k)[0];
                gasto[1] = (double) listProd.get(k)[1] * cantidad;
                gasto[2] = "";
                list.add(gasto);
            }
        }
    }

    public ArrayList<Object[]> salidaProductos() {
        ArrayList<Object[]> list = new ArrayList<>();
        for (int i = 0; i < listaProductosPedidos.size(); i++) {
            sumarProductos(list, (ArrayList<Object[]>) listaProductosPedidos.get(i)[1], 1);
        }

        return list;
    }

    public double productosPedido(String nombre) {
        ArrayList<Object[]> list = salidaProductos();
        for (int i = 0; i < list.size(); i++) {
            if (nombre.equals(list.get(i)[0])) {
                return (double) list.get(i)[1];
            }
        }

        return 0;
    }

    public String informacionPedidos(String receta, double cantidad) {
        double rec = 0;
        double can = 0;
        String re, tt;

        String info;

        for (int i = 0; i < listaPedido.size(); i++) {
            if (listaPedido.get(i).getReceta().getNombreReceta().equals(receta)
                    && listaPedido.get(i).isEstado() == true) {
                rec++;
                if (listaPedido.get(i).getCantidad() == cantidad) {
                    can++;
                }
            }
        }

        re = formatoNumero(can / rec * 100.0);
        tt = formatoNumero(can / totalVentas() * 100.0);

        info = receta + " de " + formatoNumero(cantidad) + "g, actualmente sean vendido " + formatoNumero(can)
                + " unidades con un porcentaje de " + re + "% de " + receta + " vendidas y el " + tt + "% en el total de ventas";

        return info;
    }

    public String[] estadistica() {
        String receta;
        ArrayList<Object[]> list = new ArrayList<>();
        Object[] obj;
        double rec = 0;
        int vent = totalVentas();

        for (int i = 0; i < listaPedido.size(); i++) {
            receta = listaPedido.get(i).getReceta().getNombreReceta();

            if (verificar(list, receta) == false) {
                rec = 0;
                for (int j = 0; j < listaPedido.size(); j++) {
                    if (listaPedido.get(j).getReceta().getNombreReceta().equals(receta)
                            && listaPedido.get(j).isEstado() == true) {
                        rec++;
                    }
                }

                obj = new Object[2];

                obj[0] = receta;
                obj[1] = (double) rec / vent * 100.0;

                list.add(obj);
            }
        }

        Opcion.ordenarArrayDouble(list, 1);

        String[] est = new String[5];

        est[0] = "Ventas total: " + formatoNumero(vent) + " und";

        if (list.size() > 4) {
            double n = 0;

            est[1] = list.get(0)[0] + ": " + formatoNumero((double) list.get(0)[1]) + "%";
            est[2] = list.get(1)[0] + ": " + formatoNumero((double) list.get(1)[1]) + "%";
            est[3] = list.get(2)[0] + ": " + formatoNumero((double) list.get(2)[1]) + "%";

            for (int i = 3; i < list.size(); i++) {
                n += (double) list.get(i)[1];
            }

            est[4] = "Otros: " + formatoNumero(n) + "%";
        } else {
            for (int i = 0; i < list.size(); i++) {
                est[i + 1] = list.get(i)[0] + ": " + formatoNumero((double) list.get(i)[1]) + "%";
            }
        }

        return est;
    }

    private boolean verificar(ArrayList<Object[]> list, String receta) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0].equals(receta)) {
                return true;
            }
        }

        return false;
    }

    private int totalVentas() {
        int n = 0;
        for (int j = 0; j < listaPedido.size(); j++) {
            if (listaPedido.get(j).isEstado() == true ) {
                n++;
            }
        }

        return n;
    }

}
