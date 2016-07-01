package com.test.arif.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by arifacar on 1/19/16.
 */
public class LinkedListCol {
    public static void main(String[] args) {
        List l1 = new LinkedList();
        List a1 = new ArrayList();

        for (int i=0;i<100000;i++){
            if (i==99990){
                l1.add("HELLO");
            }
            l1.add(Math.random() * 50 + 1);
        }

        for (int i=0;i<100000;i++){
            if (i==99990){
                a1.add("HELLO");
            }
            a1.add(Math.random() * 50 + 1);
        }

        long LS =  System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            if (l1.get(i)=="HELLO"){
                break;
            }
        }
        long LE = System.currentTimeMillis();

        System.out.println("Linked TIME " + (LE - LS));


        long AS =  System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            if (a1.get(i)=="HELLO"){
                break;
            }
        }
        long AE = System.currentTimeMillis();

        System.out.println("Array TIME " + (AE - AS));



    }

}
