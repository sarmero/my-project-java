/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;

/**
 *
 * @author USER
 */
public class principal {
    

    
    public static void main(String[] args) {
    
        PasswordEncryptor encryptor = new BasicPasswordEncryptor();
        
        /**
         * Encriptar password de usuario
         */
        String encryptedPassword = encryptor.encryptPassword("123456");
        System.out.println("Password encriptado (123456) : " + encryptedPassword );
        
        /**
         * Compara el password cifrado con nuestra palabra secreta
         */
        if (encryptor.checkPassword("123456", encryptedPassword )) {
            System.out.println("Bienvenido!!!");
        } else {
            System.out.println("Acceso Denegado!!!");
        }
    }    
}


