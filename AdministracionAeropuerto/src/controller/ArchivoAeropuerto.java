/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Aerolinea;

/**
 *
 * @author USER
 */
public class ArchivoAeropuerto {

    private ObjectOutputStream oos;
    private FileOutputStream fos;

    private ObjectInputStream ois;
    private FileInputStream fis;

    private String ruta;

    private ArrayList listaObjecto;

    public ArrayList getListaNumero() {
        return listaObjecto;
    }

    public void setListaNumero(ArrayList listaObjecto) {
        this.listaObjecto = listaObjecto;
    }

    public ArchivoAeropuerto(String ruta) {
        this.ruta = ruta;
    }

    public void escribir() {

        Object aux;

        try {
            fos = new FileOutputStream(ruta);
            oos = new ObjectOutputStream(fos);
            System.out.println(listaObjecto.size());
            for (int i = 0; i < listaObjecto.size(); i++) {
                aux = listaObjecto.get(i);
                oos.writeObject(aux);
            }

            System.out.println("guardado con exito");

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("error por archivo no listo");
        } catch (IOException ex) {
            System.out.println("error por convercion de objeto a bytes");
        }

    }

    public void leer() {

        listaObjecto = new ArrayList();
        Object aux;

        try {
            fis = new FileInputStream(ruta);
            ois = new ObjectInputStream(fis);

            aux = ois.readObject();

            while (aux != null) {
                listaObjecto.add(aux);
                aux = ois.readObject();   
            }
            
            System.out.println(listaObjecto.size());

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {

//            System.out.println("Problema en la traducion de Objetos");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema en la convercion de Objetos");
        }

    }

}
