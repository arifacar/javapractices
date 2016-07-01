package com.test.arif.Common;

/**
 * Created by arifacar on 1/4/16.
 */
public class Student {
    private String name;
    private String surname;
    private String classname;
    private String degree;

    public Student(){

    }

    public Student(String name, String surname, String classname, String degree) {
        this.name = name;
        this.surname = surname;
        this.classname = classname;
        this.degree = degree;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", classname='" + classname + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}
