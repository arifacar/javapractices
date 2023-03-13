package com.arifacar.hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlippingMatrix {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        flippingMatrix(matrix);
    }


    public static int flippingMatrix(List<List<Integer>> matrix) {

        List<Integer> c2 = new ArrayList<>();
        List<Integer> r0 = new ArrayList<>();
        int result=0;

        for (int i=0; i<matrix.size(); i++) {
            c2.add(matrix.get(i).get(2));
        }

        Collections.reverse(c2);

        for (int i=0; i<matrix.size(); i++) {
            matrix.get(i).set(2, c2.get(i));
        }

        for (int i=0; i<matrix.size(); i++) {
            r0.add(matrix.get(0).get(i));
        }

        Collections.reverse(r0);

        for (int i=0; i<matrix.size(); i++) {
            matrix.get(0).set(i, r0.get(i));
        }

        for (int i=0; i<2 ; i++){
            for (int j=0; j<2 ; j++){
                result += matrix.get(i).get(j);
            }
        }

        return result;
    }
}
