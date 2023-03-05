package com.arifacar.test.arif.FP;

import org.apache.tools.ant.filters.StringInputStream;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by arifacar on 1/23/16.
 */
public class Prime {

    public static void main(String[] args) {
        System.out.println(isPrime(3));
        System.out.println(isPrimeFP(5));
    }


    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return number > 1;
    }

    private static boolean isPrimeFP(int number) {
        // burada sayının asal sayı olup olmadığını kontrol ediyoruz.

        return number > 1 &&
                IntStream.range(2, number)
                        .noneMatch(index -> number % index == 0);
    }


}
