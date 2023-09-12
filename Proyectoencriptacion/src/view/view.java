/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author USER
 */
public class view {
    
/**
 * @see https://www.jc-mouse.net/
 * @author mouse
 */


    static final String PALABRA_SECRETA = "SUBORDINACION Y CONSTANCIA";

    public static void main(String[] args) {
        /**
         * Encriptando texto
         */
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(PALABRA_SECRETA);
        String myEncryptedText = textEncryptor.encrypt("Antes de que un software sea reutilizable debería ser utilizable");
        System.out.println("Texto encriptado:\n" + myEncryptedText);

        /**
         * Desencriptando
         */
        String plainText = textEncryptor.decrypt(myEncryptedText);
        System.out.println("Texto desencriptado:\n" + plainText);
    }
}

