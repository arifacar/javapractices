package com.arifacar.java8;

public class LambdaExpression {

    public static void main(String[] args) {
        MyMath myMath = a -> a * a;
        System.out.println(myMath.getResult(4));

        MyMath2 myMath2 = (a, b) -> a * b;
        System.out.println(myMath2.getResult(4, 2));

        MyMath2 myMath2Average = (a,b) -> {
            int sum = a + b;
            int avg = sum / 2;
            return avg;
        };
        System.out.println(myMath2Average.getResult(12,20));
    }

}

interface MyMath {
    int getResult(int a);

}

interface MyMath2 {
    int getResult(int a, int b);

}