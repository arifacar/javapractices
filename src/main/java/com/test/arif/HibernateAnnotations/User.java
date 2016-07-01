package com.test.arif.HibernateAnnotations;

import javax.persistence.*;

/**
 * Created by arifacar on 1/14/16.
 */
@Entity
@Table(name = "test_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    public User(String username, String name, String surname, String phone) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
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
