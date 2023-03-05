package com.arifacar.test.arif.Dozer;

/**
 * Created by arifacar on 1/14/16.
 */
public class DestObject {
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private Integer number;


    public DestObject(String name, String surname, Integer age, String address, Integer number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DestObject{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}
