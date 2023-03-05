package com.arifacar.test.arif.Collections;

import com.arifacar.test.arif.Common.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by arifacar on 1/18/16.
 */
public class SetCol {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();

        set.add(new Person("arif","acar",21));
        set.add(new Person("arif","acar",21));
        set.add(new Person("akif","acar",24));

        set.forEach(System.out::println);

        Set<String> setString = new HashSet<>();
        setString.add("Arif");
        setString.add("Acar");
        setString.add("Arif");

        setString.forEach(System.out::println);

        Set<Person> setPerson= new HashSet<>();
        Person person = new Person("Arif","Acar",21);
        Person person2 = new Person("Arif","Acar",21);
        setPerson.add(person);
        setPerson.add(person2);
        setPerson.forEach(System.out::println);


    }
}
