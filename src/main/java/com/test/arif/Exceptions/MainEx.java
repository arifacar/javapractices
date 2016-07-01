package com.test.arif.Exceptions;

import java.io.File;
import java.io.FileReader;

/**
 * Created by arifacar on 1/14/16.
 */
public class MainEx {
    public static void main(String[] args) {

        try {
            File file=new File("/Users/arifacar/Desktop/codestylesettings.xm");
            FileReader fr = new FileReader(file);
            System.out.println(fr.read());

        } catch (Exception e){
            System.out.println(e);
            throw new IllegalArgumentException("e");
        }


        //throw new IllegalArgumentException("Hello");

    }
}
