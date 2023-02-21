package com.arifacar.datastructure.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class JavaUtilTreeMap {

    public static void main(String[] args) {

        // TreeMap; HashMap 'ten farklı olarak key'lerin sıralı olarak sıralanmasını sağlar.

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("z", 10);
        treeMap.put("b", 5);
        treeMap.put("a", 40);
        treeMap.put("t", 20);

        treeMap.forEach((key, value) -> System.out.println("key : " + key + " - value : " + value));

    }
}
