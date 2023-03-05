package com.arifacar.test.arif.Collections;

import java.util.HashMap;

/**
 * Created by arifacar on 1/19/16.
 */
public class HashMapCol {
    public static void main(String[] args) {
        HashMap hm = new HashMap();

        hm.put(1,"Arif");
        hm.put("soyad","Acar");

        System.out.println(hm);
        System.out.println(hm.get(1));
        System.out.println(hm.get("soyad"));


    }
}
