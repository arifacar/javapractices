package com.arifacar.test.arif.Java8Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by arifacar on 2/6/16.
 */
public class MultiDimentionalArray {
        public static String[][] array = {
            {"a", "a", "a", "a", "a", "a", "a"},
            {"b", "b", "b", "b", "b"},
            {"c", "c", "c"},
    };

    public static void main(String[] args) {

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
               // array[row][col] = String.valueOf(0); // whatever you want goes here
                //System.out.println(array[row][col]);
            }
        }

        //TODO: Yukarıdaki işlemi lambda ile yap
        //TODO: http://stackoverflow.com/questions/35239500/aceess-multi-dimentional-arraay

        //IntStream.range(0,array.length).forEach(row -> array[row].toString();


    }

}
