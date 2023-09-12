/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Pet;
import java.util.ArrayList;

/**
 *
 * @author JRivera
 */
public class ManagePet {

    public static ArrayList<Pet> petList = new ArrayList<Pet>();

    public static void showList() {
        for (int i = 0; i < petList.size(); i++) {
            Pet p = petList.get(i);
            System.out.println("************************");
            System.out.println(
                    "\nid: " + p.id
                    + "\nname:" + p.name
                    + "\nage: " + p.age
                    + "\ntipo: " + p.tipo
                    + "\nraza: " + p.raza
                    + "\ngender: " + p.gender
                    + "\nphone: " + p.phone
                    + "\naddress: " + p.address
            );
            System.out.println("--------------------------");
        }
    }

    public static String listToString() {
        String ret = "";
        for (int i = 0; i < petList.size(); i++) {
            Pet p = petList.get(i);
            ret += "************************\n";
            ret
                    += "\nid: " + p.id
                    + "\nname:" + p.name
                    + "\nage: " + p.age
                    + "\ntipo: " + p.tipo
                    + "\nraza: " + p.raza
                    + "\ngender: " + p.gender
                    + "\nphone: " + p.phone
                    + "\naddress: " + p.address;
            ret += "--------------------------\n";
        }
        
        return ret;
    }

}
