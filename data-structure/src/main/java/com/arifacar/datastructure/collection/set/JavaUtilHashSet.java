package com.arifacar.datastructure.collection.set;

import java.util.HashSet;

public class JavaUtilHashSet {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        hashSet.add(1);
        hashSet.add(3);
        hashSet.add(99);
        hashSet.add("Arif");
        hashSet.add("Acar");
        hashSet.add(true);
        hashSet.add(false);
        hashSet.add(1.2);

        hashSet.forEach(System.out::println); // Sırayla eklemediğini görürüz.


    }
}
