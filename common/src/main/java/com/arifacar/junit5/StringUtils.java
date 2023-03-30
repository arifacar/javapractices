package com.arifacar.junit5;

public class StringUtils {


    public static boolean isPalindrome(String candidate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(candidate);
        return candidate.equals(stringBuilder.reverse().toString());
    }
}
