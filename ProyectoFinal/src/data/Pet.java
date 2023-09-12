/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author JRivera
 */
public class Pet {

    public String id;
    public String name;
    public int age;
    public String tipo;
    public String raza;
    public char gender;
    public String phone;
    public String address;

    public Pet(String id, String name, int age, String tipo, String raza, char gender, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tipo = tipo;
        this.raza = raza;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Id: " + id
                + " Name: " + name
                + " Age: " + age
                + " Tipo: " + tipo
                + " Raza: " + raza
                + " Gender: " + gender
                + " Phone: " + phone
                + " Address: " + address;
    }

}
