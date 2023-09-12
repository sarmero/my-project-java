/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import model.Receta;
import model.Usuario;

/**
 *
 * @author USER
 */
public class ArchivoUsuario {

    private ObjectOutputStream oos;
    private FileOutputStream fos;

    private ObjectInputStream ois;
    private FileInputStream fis;

    private String ruta;

    private ArrayList<Usuario> listaUsuario;

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public ArchivoUsuario(String ruta) {
        this.ruta = ruta;
    }

    public void escribir() {
        Usuario auxiliar;
        try {
            fos = new FileOutputStream(ruta);
            oos = new ObjectOutputStream(fos);

            for (int i = 0; i < listaUsuario.size(); i++) {
                auxiliar = listaUsuario.get(i);
                oos.writeObject(auxiliar);
            }

            System.out.println("Guardado con exito");

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("error por archivo no listo");
        } catch (IOException ex) {
            System.out.println("error por convercion de objeto a bytes" + ex.getLocalizedMessage());
        }

    }

    public void leer() {

        Usuario auxiliar;
        listaUsuario = new ArrayList<>();

        try {
            fis = new FileInputStream(ruta);
            ois = new ObjectInputStream(fis);

            auxiliar = (Usuario) ois.readObject();

            if (auxiliar != null) {
                System.out.println("paso");
                listaUsuario.add(auxiliar);
                auxiliar = (Usuario) ois.readObject();
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
    }

    
}
