package com.test.arif.WordUtils;

import org.apache.commons.lang3.text.WordUtils;

/**
 * Created by arifacar on 1/13/16.
 */
public class WordUtilsMain {
    public static void main(String[] args) {
        /*
        String str = "This is a sentence that we're using to test the wrap method";
        System.out.println("Original String 1:\n" + str);
        System.out.println("\nWrap length of 10:\n" + WordUtils.wrap(str, 10));
        System.out.println("\nWrap length of 20:\n" + WordUtils.wrap(str, 20));
        System.out.println("\nWrap length of 30:\n" + WordUtils.wrap(str, 30));

        String str = "This is a sentence that we're using to test the wrap method";

        String str2 = "This is a sentence that we're using to test the wrap method and hereisaveryveryveryverylongword";
        System.out.println("\nOriginal String 2:\n" + str2);
        System.out.println("\nWrap length of 10, <br/>\\n newline, wrap long words:\n"
                + WordUtils.wrap(str2, 10, "<br/>\n", true));
        System.out.println("\nWrap length of 20, \\n newline, don't wrap long words:\n"
                + WordUtils.wrap(str2, 20, "\n", false));
        */


        String str = "This is a sentence that we're using to test the wrap method";
        System.out.println(WordUtils.capitalize(str,' '));


    }
}
