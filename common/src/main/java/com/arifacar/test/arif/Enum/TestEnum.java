package com.arifacar.test.arif.Enum;

/**
 * Created by arifacar on 1/13/16.
 */
public class TestEnum {
    public static void main(String[] args) {
        Currency currency = Currency.EUR;
        System.out.println(currency);

        System.out.println("---");

        //Enum Iteration
        for (Currency c : Currency.values()) {
            System.out.println(c);
        }

        System.out.println("---");


        System.out.println(currency.getCurrencyCode());

    }
}
