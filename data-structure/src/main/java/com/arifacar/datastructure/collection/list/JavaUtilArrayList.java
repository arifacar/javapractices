package com.arifacar.datastructure.collection.list;

import java.util.ArrayList;

public class JavaUtilArrayList {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");

        arrayList.forEach(System.out::println);

    }
}
