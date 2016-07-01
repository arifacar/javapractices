package com.test.effectiveJava;

public class Item1 {

    public static void main(String[] args) {
        System.out.println(valueOf(1 == 2));
    }


    public static Boolean valueOf(Boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

}
