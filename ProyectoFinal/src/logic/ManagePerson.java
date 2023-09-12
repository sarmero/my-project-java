/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Person;
import java.util.ArrayList;

/**
 *
 * @author JRivera
 */
public class ManagePerson {

    public static ArrayList<Person> pList = new ArrayList<Person>();

    public static void showList() {
        for (int i = 0; i < pList.size(); i++) {
            Person p = pList.get(i);
            System.out.println("************************");
            System.out.println(
                    "\nid: " + p.id
                    + "\nname:" + p.name
                    + "\nage: " + p.age
                    + "\ngender: " + p.gender
                    + "\nphone: " + p.phone
                    + "\naddress: " + p.address
            );
            System.out.println("--------------------------");
        }
    }

    public static String listToString() {
        String ret = "";
        for (int i = 0; i < pList.size(); i++) {
            Person p = pList.get(i);
            ret += "************************\n";
            ret
                    += "\nid: " + p.id
                    + "\nname:" + p.name
                    + "\nage: " + p.age
                    + "\ngender: " + p.gender
                    + "\nphone: " + p.phone
                    + "\naddress: " + p.address;
            ret += "--------------------------\n";
        }
        
        return ret;
    }

}
