/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Foto;

/**
 *
 * @author USER
 */
public class ListaAlbum extends Opcion implements Serializable {

    private static final long serialVersionUID = 0x1C8E3CF;

    private ArrayList<Album> listaAlbum;

    public ListaAlbum() {
        listaAlbum = new ArrayList<>();
    }

    public ArrayList<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(ArrayList<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    public void agregarAlbum(Album album) {
        listaAlbum.add(album);
        String ruta = getRutaArchivo();
        setRutaArchivo(ruta + "Album/");
        crearDirectorio(album.getNombreAlbum());
        setRutaArchivo(ruta);
        listaAlbum.sort((Album o1, Album o2) -> o1.getNombreAlbum().compareTo(o2.getNombreAlbum()));
    }

    public void agregarFoto(int idxAlb, Foto foto) {
        listaAlbum.get(idxAlb).agregarFoto(foto);
    }

    public void precargarFoto() {
        listaAlbum.stream().forEach(list -> {
            list.precargarFotos();
        });
    }

    public ArrayList<Object[]> obtenerListaFotos(int idxAlbum) {
        return listaAlbum.get(idxAlbum).getListaFoto();
    }

    public Object[] nombreAlbum() {
        Object[] cat = new Object[listaAlbum.size()];
        for (int i = 0; i < listaAlbum.size(); i++) {
            cat[i] = listaAlbum.get(i).getNombreAlbum();
        }
        return cat;
    }

    public int numeroFotos(String album) {
        for (int i = 0; i < listaAlbum.size(); i++) {
            if (listaAlbum.get(i).getNombreAlbum().equals(album)) {
                return listaAlbum.get(i).getFotos().size();
            }
        }

        return 0;
    }

    public ArrayList<Foto> obtenerFotos(int idxAlb) {
        return listaAlbum.get(idxAlb).getFotos();
    }

    public Foto obtenerFoto(int idxAlb, String ruta) {
        return listaAlbum.get(idxAlb).obtenerFoto(ruta);
    }

    public void removerImagen(String album, String ruta) {
        for (int i = 0; i < listaAlbum.size(); i++) {
            if (listaAlbum.get(i).getNombreAlbum().equals(album)) {
                listaAlbum.get(i).removerFoto(ruta);
                eliminarFichero(ruta);
                break;
            }
        }
    }

    public void modificarImagen(String album, Foto foto) {
        for (int i = 0; i < listaAlbum.size(); i++) {
            if (listaAlbum.get(i).getNombreAlbum().equals(album)) {
                listaAlbum.get(i).modificarFoto(i, foto);
                break;
            }
        }
    }

    public void modificarAlbum(String albumOld, String albumNew) {
        for (int i = 0; i < listaAlbum.size(); i++) {
            if (listaAlbum.get(i).getNombreAlbum().equals(albumOld)) {
                listaAlbum.get(i).setNombreAlbum(albumNew);
                break;
            }
        }
    }

    public void listaBoxAlbum(JComboBox cbxLista) {
        listaAlbum.stream().forEach(list -> {
            cbxLista.addItem(list.getNombreAlbum());
        });
    }

    public Object[] obtenerReferencia(int idxAlb, String ruta) {
        Foto foto = listaAlbum.get(idxAlb).obtenerFoto(ruta);
        Object[] ref = new Object[foto.getReferenciaReceta().size()];

        for (int i = 0; i < ref.length; i++) {
            ref[i] = foto.getReferenciaReceta().get(i)[0];
        }

        return ref;
    }

    public void moverFotoAlbum(String ruta, String albumOld, String albumNew) {
        for (int i = 0; i < listaAlbum.size(); i++) {
            if (listaAlbum.get(i).getNombreAlbum().equals(albumOld)) {
                for (int j = 0; j < listaAlbum.size(); j++) {
                    if (listaAlbum.get(j).getNombreAlbum().equals(albumNew)) {
                        listaAlbum.get(j).agregarFoto(listaAlbum.get(i).obtenerFoto(ruta));
                        break;
                    }
                }
                listaAlbum.get(i).removerFoto(ruta);
                break;
            }
        }
    }

    public Object[] obtenerlistaAlbum() {
        Object[] list = new Object[listaAlbum.size()];
        for (int i = 0; i < listaAlbum.size(); i++) {
            list[i] = listaAlbum.get(i).getNombreAlbum();
        }
        
        return list;
    }
    
    public void cambiarNombreAlbum(String nomOld, String nomNew){
        for (int i = 0; i < listaAlbum.size(); i++) {
           if(listaAlbum.get(i).getNombreAlbum().equals(nomOld)){
               listaAlbum.get(i).setNombreAlbum(nomNew);
               break;
           }
        }
    }

}
