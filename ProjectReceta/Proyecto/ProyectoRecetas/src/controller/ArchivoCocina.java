/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Componente.MyIcon;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Receta;

/**
 *
 * @author USER
 */
public class ArchivoCocina {

    private ObjectOutputStream oos;
    private FileOutputStream fos;

    private ObjectInputStream ois;
    private FileInputStream fis;

    private String ruta;

    private Cocina listaCocina;

    public Cocina getListaCocina() {
        return listaCocina;
    }

    public void setListaCocina(Cocina listaCocina) {
        this.listaCocina = listaCocina;
    }

    public ArchivoCocina(String ruta) {
        this.ruta = ruta;
    }

    public void escribir() {

        try {
            fos = new FileOutputStream(ruta);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(listaCocina);

            System.out.println("guardado con exito");

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("error por archivo no listo");
        } catch (IOException ex) {
            System.out.println("error por convercion de objeto a bytes" + ex.getLocalizedMessage());
        }

    }

    public void leer() {

        Cocina auxiliar;
        listaCocina = new Cocina();

        try {
            fis = new FileInputStream(ruta);
            ois = new ObjectInputStream(fis);

            auxiliar = (Cocina) ois.readObject();

            if (auxiliar != null) {
                listaCocina = auxiliar;
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
