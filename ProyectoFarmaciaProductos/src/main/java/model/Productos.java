/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ConexionBD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Productos {
    
   private String nombre;
   private String id;
   private double temperatura;
   private double valorBase;

    public Productos(String nombre, String id, double temperatura, double valorBase) {
        this.nombre = nombre;
        this.id = id;
        this.temperatura = temperatura;
        this.valorBase = valorBase;
    }
    
    public Productos() {
        this.nombre = "";
        this.id = "";
        this.temperatura = 0;
        this.valorBase = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    
    public boolean guardarProducto() {

        ConexionBD conexion = new ConexionBD();

        String sentencia = "INSERT INTO productos (id, nombre, temperatura, valorBase) "
                + " VALUES ('" + this.id + "','" + this.nombre + "'," + this.temperatura +"',"+ this.valorBase + ");";

        if (conexion.setAutcCommitBD(false)) {

            if (conexion.insertarBD(sentencia)) {
                conexion.commitBD();

                conexion.cerrarConexion();

                return true;
            } else {
                conexion.rollbackBD();
                conexion.cerrarConexion();
                return false;
            }
        }else { 
            conexion.cerrarConexion();
            return false;
        }
    }
    
}
