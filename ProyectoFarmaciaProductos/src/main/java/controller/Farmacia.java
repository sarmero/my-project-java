/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Productos;

/**
 *
 * @author USER
 */
public class Farmacia {

    

    public boolean guardarProducto(Productos prod) {

        ConexionBD conexion = new ConexionBD();

        String sentencia = "INSERT INTO productos (id, nombre, temperatura, valorBase) "
                + " VALUES ('" + prod.getId() + "'," + prod.getNombre() + ",'" + prod.getTemperatura() + "'," + prod.getValorBase() + ");";

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
        } else {
            conexion.cerrarConexion();
            return false;
        }
    }

    public boolean actualizarProducto(Productos pro) {

        ConexionBD conexion = new ConexionBD();

        String sentencia = "UPDATE `productos` SET id ='" + pro.getId() + "',nombre ='" + pro.getNombre()
                + "',temperatura ='" + pro.getTemperatura() + "',valorBase ='" + pro.getValorBase() + "WHERE id=" + pro.getId() + ";";
        if (conexion.setAutcCommitBD(false)) {

            if (conexion.actualizarBD(sentencia)) {
                conexion.commitBD();
                conexion.cerrarConexion();
                return true;
            } else {
                conexion.rollbackBD();
                conexion.cerrarConexion();
                return false;
            }
        } else {
            conexion.cerrarConexion();
            return false;
        }
    }

    public boolean borrarProducto(String id) {
        String sentencia = "DELETE FROM `productos` WHERE `id`='" + id + "'";
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutcCommitBD(false)) {

            if (conexion.actualizarBD(sentencia)) {
                conexion.commitBD();
                conexion.cerrarConexion();
                return true;
            } else {
                conexion.rollbackBD();
                conexion.cerrarConexion();
                return false;
            }
        } else {
            conexion.cerrarConexion();
            return false;
        }
    }

    public Productos getProducto(String id) {
        Productos prod = new Productos();

        ConexionBD conexion = new ConexionBD();

        String sql = "select * from productos where id=" + id + "";

        ResultSet rs = conexion.consultarBD(sql);

        try {

            if (rs.next()) {
                prod.setId(rs.getString("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setTemperatura(rs.getDouble("temperatura"));
                prod.setValorBase(rs.getDouble("valorBase"));

                conexion.cerrarConexion();

            } else {
                conexion.cerrarConexion();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return prod;
    }

    public List<Productos> listarProductos() {

        ConexionBD conexion = new ConexionBD();

        List<Productos> listaProductos = new ArrayList<>();

        String sql = "select * from productos";
        ResultSet rs = conexion.consultarBD(sql);
        Productos p;
        try {
            while (rs.next()) {
                p = new Productos();
                p.setId(rs.getString("id"));
                p.setNombre(rs.getString("nombre"));
                p.setTemperatura(rs.getDouble("temperatura"));
                p.setValorBase(rs.getDouble("valorBase"));
                listaProductos.add(p);
            }

            conexion.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return listaProductos;
    }

    

}
