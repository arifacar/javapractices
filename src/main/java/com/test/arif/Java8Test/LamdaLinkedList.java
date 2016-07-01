package com.test.arif.Java8Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by arifacar on 1/4/16.
 */
public class LamdaLinkedList {
    public static void main(String[] args) {
        List a= new LinkedList<>();
        a.add("Test 1");
        a.add("Test 2");

        a.stream().forEach(System.out::println);


        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        System.out.println( myList
                .stream()
                .findFirst());


    }
}
