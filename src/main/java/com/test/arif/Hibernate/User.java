package com.test.arif.Hibernate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by arifacar on 1/14/16.
 */
public class User {


    private Integer id;

    private String username;

    private String name;

    private String surname;

    private String phone;

    public User(Integer id, String username, String name, String surname, String phone) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                '}';
    }

}
