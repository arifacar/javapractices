package com.arifacar.datastructure.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaUtilLinkedHashMap {

    public static void main(String[] args) {

        // LinkedHashMap; HashMap 'ten farklı olarak eklenen sırayla kayıtları tutar.

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("z", 10);
        linkedHashMap.put("b", 5);
        linkedHashMap.put("a", 40);
        linkedHashMap.put("t", 20);

        linkedHashMap.forEach((key, value) -> System.out.println("key : " + key + " - value : " + value));

    }
}
