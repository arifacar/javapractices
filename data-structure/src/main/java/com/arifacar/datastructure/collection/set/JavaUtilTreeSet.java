
package com.arifacar.datastructure.collection.set;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class JavaUtilTreeSet {

    public static void main(String[] args) {

        // TreeSet elementler artan bir sırayla tutulur. null kabul etmez. Değerleri küçükten büyüğe artan bir sırayla verir.

        TreeSet treeSet = new TreeSet();
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(44);
        treeSet.add(16);

        treeSet.forEach(System.out::println);


    }
}
