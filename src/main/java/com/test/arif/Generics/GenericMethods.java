package com.test.arif.Generics;

/**
 * Created by arifacar on 1/8/16.
 * http://www.tutorialspoint.com/java/java_generics.htm
 */
public class GenericMethods {

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.println(element);
        }
    }

    //Only for Int Array - Not Generic
    public static void intArrayMethod(Integer[] intArrays) {
        for (Integer e : intArrays) {
            System.out.println(e);
        }
    }

    //Only for String Array - Not Generic
    public static void charArrayMethod(Character[] charArrays){
        for (Character c:charArrays){
            System.out.println(c);
        }
    }


    public static void main(String args[]) {

        Integer[] intArray = {3, 5, 7, 10};
        Character[] charArray = {'A', 'R', 'I', 'F'};

        printArray(intArray);
        printArray(charArray);

        System.out.println();

        intArrayMethod(intArray);
        charArrayMethod(charArray);

    }

}
