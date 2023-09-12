/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.Opcion.codigo;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Cliente;

/**
 *
 * @author USER
 */
public class ListaCliente implements Serializable {

    private static final long serialVersionUID = 0x1C0E3AA;
    private ArrayList<Cliente> listaCliente;

    public ListaCliente() {
        listaCliente = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        cliente.setCodigo(codigo(listaClienteCodigo()));
        listaCliente.add(cliente);
        listaCliente.sort((Cliente o1, Cliente o2) -> o1.getNombre().compareTo(o2.getNombre()));
    }

    private ArrayList<Integer> listaClienteCodigo() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < listaCliente.size(); i++) {
            list.add(listaCliente.get(i).getCodigo());
        }

        return list;
    }

    public void lisaCliente(JComboBox cbx) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).isVigente() == true) {
                cbx.addItem(listaCliente.get(i).getNombre());
            }
        }
    }

    public boolean verificarCliente(String cliente) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNombre().equals(cliente) && listaCliente.get(i).isVigente() == true) {
                return true;
            }
        }
        return false;
    }

    public void editarCliente(Cliente cliente, String oldCliente) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNombre().equals(oldCliente)) {
                cliente.setCodigo(listaCliente.get(i).getCodigo());
                listaCliente.set(i, cliente);
                break;
            }
        }
    }

    public void removerCliente(String cliente) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNombre().equals(cliente) && listaCliente.get(i).isVigente() == true) {
                listaCliente.get(i).setVigente(false);
                break;
            }
        }
    }

    public String obtenerNombreCliente(int codigo) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCodigo() == codigo) {
                return listaCliente.get(i).getNombre();
            }
        }
        return "";
    }

    public int obtenerCodigoCliente(String nombre) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNombre().equals(nombre)) {
                return listaCliente.get(i).getCodigo();
            }
        }
        return 0;
    }

    public Cliente obtenerCliente(String nombre) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNombre().equals(nombre)) {
                return listaCliente.get(i);
            }
        }
        return null;
    }

    public Cliente obtenerCliente(int codigo) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCodigo() == codigo) {
                return listaCliente.get(i);
            }
        }
        return null;
    }

}
