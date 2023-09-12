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
 * @param <T>
 */
public abstract class ListaAeropuerto {

    protected ArrayList<Object> listaAeropuerto;

    public ListaAeropuerto() {
        listaAeropuerto = new ArrayList();
    }

    public ArrayList getListaAeropuerto() {
        return listaAeropuerto;
    }

    public void setListaAeropuerto(ArrayList<Object> listaAeropuerto) {
        this.listaAeropuerto = listaAeropuerto;
    }

    public void AddAeropuerto(ArrayList<Object> listAeropuerto) {
        listaAeropuerto.add(listAeropuerto);
    }

    public void edit(ArrayList listAeropuerto) {

    }

    public void remove(ArrayList listAeropuerto) {

    }

}
