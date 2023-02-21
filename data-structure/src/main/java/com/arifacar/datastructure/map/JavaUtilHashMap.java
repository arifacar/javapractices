package com.arifacar.datastructure.map;

import java.util.HashMap;
import java.util.Map;

public class JavaUtilHashMap {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap();
        map.put("z", "Zahide");
        map.put("a", "Arif");
        map.put("b", "Birol");
        map.put("t", "Turgut");

        map.forEach((key, value) -> System.out.println("key : " + key + " - value : " + value));

    }
}
