package com.arifacar.datastructure.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class JavaUtilLinkedList {

    public static void main(String[] args) {

        // ArrayList'ten farkı arama algoritmaları farklılık gösterir.
        // ArrayList aramada, Linkedlist ise ekleme ve silmede daha hızlıdır.
        // Aramada Linkedlist O(n), ArrayList O(1)
        // Ekelem ve silmede Linkedlist O(1), ArrayList O(n)

        LinkedList linkedList = new LinkedList();

        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        linkedList.forEach(System.out::println);


    }
}
