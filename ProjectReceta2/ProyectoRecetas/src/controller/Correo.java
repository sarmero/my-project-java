/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import model.Conexion;

/**
 *
 * @author USER
 */
public class Correo {

    private String passwordRemitente;
    private String correoRemitente;

    public Correo() {
        correoRemitente = "pastelitocoke@gmail.com";
        passwordRemitente = "cjrmgmdwjffacwih";
    }

    public void enviarCorreo(String correoReceptor, String asunto, String mensaje) {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

//            String correoRemitente = correo;
//            String passwordRemitente = "coke7cr7";
//            String correoReceptor = cRecetor;
//            String asunto = "Mi primero correo en Java";
//            String mensaje = "Hola<br>Este es el contenido de mi primer correo desde <b>java</b><br><br>Por <b>Códigos de Programación</b>";
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
            System.out.println("Correo Electronico Enviado");
//            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

        } catch (AddressException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarCorreoAdjunto(String correoReceptor, String asunto, String mensaje, String rutaArchivo, String nomArchivo) {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

//            String correoRemitente = "micorreo@gmail.com";
//            String passwordRemitente = "password";
//            String correoReceptor = txtCorreo.getText();
//            String asunto = "Mi primero correo en Java";
//            String mensaje = "Hola<br>Este es el contenido de mi primer correo desde <b>java</b><br><br>Por <b>Códigos de Programación</b>";
            BodyPart texto = new MimeBodyPart();
            texto.setContent(mensaje, "text/html");

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(rutaArchivo)));
            adjunto.setFileName(nomArchivo);

            MimeMultipart miltiParte = new MimeMultipart();
            miltiParte.addBodyPart(texto);
            miltiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setContent(miltiParte);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

//            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
            System.out.println("Correo Electronico Enviado");

        } catch (AddressException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarCorreoMasivo(String correoReceptor, String asunto, String mensaje) {
        try {

            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();

            String sql = "SELECT nombre, email FROM persona";
            String[] correos_destinos = null;

            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                ResultSetMetaData rd = rs.getMetaData(); // Obtenemos el metadata desde el resulset
                int filas = rd.getColumnCount();
                correos_destinos = new String[filas + 1];
                int indice = 0;

                while (rs.next()) {
                    correos_destinos[indice] = rs.getString("email");
                    indice++;
                }

            } catch (SQLException ex) {
                Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
            }

//---------------------Email
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

// Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

//Recoger los datos
//            String correoRemitente = "micorreo@gmail.com";
//            String passRemitente = "password";
//            String asunto = "El asunto";
//            String mensaje = "Hola<br>Este es correo fue enviado desde <b>Java</b>.<br><br>Por <b>Códigos de Programación</b>";
// Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            Address[] receptores = new Address[correos_destinos.length];
            int j = 0;
            while (j < correos_destinos.length) {
                receptores[j] = new InternetAddress(correos_destinos[j]);
                j++;
            }

//receptor.
            message.addRecipients(Message.RecipientType.TO, receptores);
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

// Cierre de la conexion.
            t.close();
            System.out.println("Correo Electronico Enviado");
//            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

        } catch (AddressException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Correo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        Correo cor = new Correo();
////        cor.enviarCorreo("sebazeco314@gmail.com", "funciona", "sebas si funciona");
//    }
}
