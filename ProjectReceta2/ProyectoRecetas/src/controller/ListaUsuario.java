/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import model.Usuario;

/**
 *
 * @author USER
 */
public class ListaUsuario extends Opcion implements Serializable {

    private static final long serialVersionUID = 0x1C6E3A;
    private final ArchivoUsuario gestorArchivoUsuario;
    private ArrayList<Usuario> listaUsuario;
    private final Correo correo;

    public ListaUsuario() {
        gestorArchivoUsuario = new ArchivoUsuario("usuarios.dat");
        gestorArchivoUsuario.leer();
        listaUsuario = gestorArchivoUsuario.getListaUsuario();
        correo = new Correo();
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public void agregarUsuario(Usuario usuario) {
        usuario.setCodigo(codigo(listacodigo()));
        listaUsuario.add(usuario);
        ArchivarUsuario();
    }

    private ArrayList<Integer> listacodigo() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < listaUsuario.size(); i++) {
            list.add(listaUsuario.get(i).getCodigo());
        }

        return list;
    }

    public void rutaArchivo() {
        String ruta = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        String[] ru = ruta.split("/");
        ruta = "";
        for (int i = 1; i < ru.length - 3; i++) {
            ruta = ruta + ru[i] + "/";
        }
        rutaArchivo = ruta;
        crearDirectorio("User");
        rutaArchivo += "User/";
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public Usuario buscarUsuario(String usuario, String contraseña) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getUsuario().equals(usuario) && listaUsuario.get(i).getContraseña().equals(contraseña)) {
                listaUsuario.get(i).setPin(-1);
                return listaUsuario.get(i);
            }
        }

        return null;
    }

    public Usuario obtenerUsuario(int codigo) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getCodigo() == codigo) {
                return listaUsuario.get(i);
            }
        }

        return null;
    }

    public Usuario buscarUsuario(int pin) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getPin() == pin) {
                return listaUsuario.get(i);
            }
        }

        return null;
    }

    public Usuario buscarUsuario(String usuario) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getUsuario().equals(usuario)) {
                return listaUsuario.get(i);
            }
        }

        return null;
    }

    public void ArchivarUsuario() {
        gestorArchivoUsuario.setListaUsuario(listaUsuario);
        gestorArchivoUsuario.escribir();
    }

    private String generarCodigo() {

        String codigo = "";
        Random mat = new Random();

        for (int i = 0; i < 10; i++) {
            codigo = codigo + mat.nextInt(9);
        }

        return String.valueOf(codigo);
    }

    public String codigoRecuperacion(String cRemitente) {

        String codigo = generarCodigo();
        System.out.println("codigo: " + codigo);

        String asunto = "Restablecer Contraseña";

        String mensaje = "Hola!<br> Has realizado una solicitud de cambio de contraseña.<br><br>"
                + "Para activar una nueva contraseña ingresa el codigo: <b>" + codigo + "</b><br>"
                + "Recuerda que para garantizar la seguridad de tu cuenta de usuario, la contraseña de acceso debe cumplir los siguientes requisitos:<br>"
                + "- La longitud mínima debe ser de 8 caracteres o dígitos.<br>"
                + "- No puede contener el nombre de usuario, ninguno de los apellidos ni fecha de nacimiento del usuario.<br>";

        correo.enviarCorreo(cRemitente, asunto, mensaje);
        return codigo;
    }

    public void canbiarContraseña(String contraseña, String user) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getUsuario().equals(user)) {
                listaUsuario.get(i).setContraseña(contraseña);
                break;
            }
        }
        ArchivarUsuario();
    }

    public void ingresarPin(int pin) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getPin() == pin) {
                listaUsuario.get(i).setPin(pin);
                break;
            }
        }
        ArchivarUsuario();
    }

    public boolean validarContraseña(String usuario, String contraseña) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getUsuario().equals(usuario) && listaUsuario.get(i).getContraseña().equals(contraseña)) {
                System.out.println("usuario " + listaUsuario.get(i).getUsuario());
                return true;
            }
        }

        return false;
    }

    public void modificarUsuario(Usuario user) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            if (listaUsuario.get(i).getUsuario().equals(user.getUsuario())) {
                user.setCodigo(listaUsuario.get(i).getCodigo());
                listaUsuario.set(i, user);
            }
        }
    }

}
