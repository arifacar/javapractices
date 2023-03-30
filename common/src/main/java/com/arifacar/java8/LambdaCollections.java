package com.arifacar.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaCollections {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("CCCC");
        list.add("BB");
        list.add("ZZZZZZZZ");
        list.add("TTTTTT");


        // sort

        // list.sort((a,b) -> a.length() - b.length());
        // list.sort(Comparator.comparing(a -> a.length()));
        // list.sort(Comparator.comparingInt(String::length));
        //list.sort(Comparator.comparing(String::length));

        // removeIf

        // list.removeIf(a -> a.length()<3);

        // list.forEach(System.out::println);


        // merge(key, value, remappingFunction)

        Map<String, String> names = new HashMap<>();
        names.put("Arif", "Acar?");
        names.put("Ali", "Velili");
        names.put("Roberto", "Car");

        names.merge("Arif", "Acarrrr", (o,n) -> o.substring(0,3) + n);


        names.forEach((key, value) -> {
            System.out.println(key);
        });



    }
}
