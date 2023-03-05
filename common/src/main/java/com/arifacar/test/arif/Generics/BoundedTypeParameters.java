package com.arifacar.test.arif.Generics;

import java.util.Comparator;

/**
 * Created by arifacar on 1/8/16.
 * ----
 * T extends Comparable<T>
 * ----
 * means
 * ----
 * public class Name implements Comparable<Name> {
 * ...
 * public int compareTo(Name n) { ... }
 * }
 * ----
 * y.compareTo(max) returns 0, 1, -1
 */
public class BoundedTypeParameters {

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        System.out.println(x + " " + y + " " + z);

        System.out.println("Define default max value = "+ x);
        T max=x;

        System.out.println("Check Y "+y.compareTo(max));
        if (y.compareTo(max)>0){
            max=y;
        }

        System.out.println("Check Z "+z.compareTo(max));
        if (z.compareTo(max)>0){
            max=z;
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println("Maximum= " + maximum(25,25, 7));
    }


}
