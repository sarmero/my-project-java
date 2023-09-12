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
public class Person {

    public String id;
    public String name;
    public int age;
    public char gender;
    public String phone;
    public String address;

    public Person(String id, String name, int age, char gender, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Id: " + id
                + " Name: " + name
                + " Age: " + age
                + " Gender: " + gender
                + " Phone: " + phone
                + " Address: " + address;
    }

}
