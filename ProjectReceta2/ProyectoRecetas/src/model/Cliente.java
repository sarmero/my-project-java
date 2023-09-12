/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Cliente implements Serializable{
    
    private String nombre;
    private String correo;
    private String celular;
    private String domicilio;
    private int codigo;
    private String avatar;
    private boolean vigente;

    public Cliente() {
        nombre = "";
        correo = "";
        celular = "";
        domicilio = "";
        codigo = 0;
        avatar = "/image/IconAvatar/img6.png";
        vigente = true;
    }

    public Cliente(String nombre, String correo, String celular, String direcion, int codigo) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.domicilio = direcion;
        this.codigo = codigo;
        avatar = "/image/IconAvatar/img6.png";
        vigente = true;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
