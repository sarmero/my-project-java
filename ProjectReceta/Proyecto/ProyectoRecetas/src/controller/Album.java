/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JLabel;
import model.Foto;
import model.ProductoPedido;

/**
 *
 * @author USER
 */
public class Album extends Opcion implements Serializable {

    private String nombreAlbum;
    private ArrayList<Foto> fotos;
    private ArrayList<Object[]> listaFoto;
    private int x;
    private int y;

    public Album() {
        fotos = new ArrayList<>();
        listaFoto = new ArrayList<>();
        nombreAlbum = "";
        x = 5;
        y = 10;
    }

    public ArrayList<Object[]> getListaFoto() {
        return listaFoto;
    }

    public void agregarFoto(Foto foto) {
        foto.setFecha(fecha());
        fotos.add(foto);
        listaFoto.add(cargarFoto(foto));
        ordenarArrayFechaRev(listaFoto, 6);
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public ArrayList<ProductoPedido> obtenerOtProducto(String ruta) {
        for (int i = 0; i < fotos.size(); i++) {
            if (fotos.get(i).getRuta().equals(ruta)) {
                return fotos.get(i).getOtProductos();
            }
        }
        return null;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    public Foto obtenerFoto(String ruta) {
        for (int i = 0; i < fotos.size(); i++) {
            if (fotos.get(i).getRuta().equals(ruta)) {
                return fotos.get(i);
            }
        }
        return null;
    }

    public void removerFoto(String ruta) {
        for (int i = 0; i < fotos.size(); i++) {
            if (fotos.get(i).getRuta().equals(ruta)) {
                fotos.remove(i);
                listaFoto.remove(i);
            }
        }
    }

    public void modificarFoto(int idxAlb, Foto foto) {
        fotos.set(idxAlb, foto);
        listaFoto.set(idxAlb, cargarFoto(foto));
    }

    public void precargarFotos() {
        if (fotos.size() > 0) {
            fotos.stream().parallel().forEach(list -> {
                listaFoto.add(cargarFoto(list));
            });
        }
    }

    private Object[] cargarFoto(Foto foto) {

        Object[] fot = new Object[7];
        JLabel lblImgg = new JLabel();
        lblImgg.setBounds(0, 0, 100, 100);
        lblImgg = visualizadorImagen(lblImgg, foto.getRuta());
        lblImgg.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));

        fot[0] = lblImgg;
        fot[1] = foto.getRuta();
        fot[2] = foto.getDetalle();
        fot[3] = foto.getMedReferencia();
        fot[4] = foto.getOtProductos();
        fot[5] = foto.getReferenciaReceta();
        fot[6] = foto.getFecha();

        return fot;
    }

}
