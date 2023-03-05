package com.arifacar.test.arif.FP;

/**
 * Created by arifacar on 1/24/16.
 */
public class CaseFP1 {
    public static void main(String[] args) {
        // 3 ten büyük olan ilk çift sayının iki katını alan program

        /*
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9);

        values.forEach(System.out::print);

        int result = 0;
        for (int v : values) {
            if (v > 3 && v % 2 == 0) {
                result = v * 2;
                break;
            }
        }

        System.out.println(result);

        System.out.println(
                values.stream()
                        .filter(v -> v > 3)
                        .filter(v -> v % 2 == 0)
                        .map(v -> v * 2)
                        .findFirst()
                        .get()
        );

        System.out.println(
                values.stream()
                        .filter(CaseFP1::isGreaterThan3)
                        .filter(CaseFP1::isEven)
                        .map(v -> v * 2)
                        .findFirst()
                        .get()
        );


        int result1 = 0;
        for (int v : values) {
            if (isGreaterThan3(v) && isEven(v)) {
                result1 = v * 2;
                break;
            }
        }
*/

    }

    private static boolean isEven(Integer value) {
        System.out.println("isEven "+ value);
        return value % 2 == 0;
    }

    private static boolean isGreaterThan3(Integer value) {
        System.out.println("isGreaterThan3 "+ value);
        return value > 3;
    }
}
