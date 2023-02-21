package com.arifacar.datastructure.collection.list;

import java.util.Vector;

public class JavaUtilVector {

    public static void main(String[] args) {

        // Çok kullanılmıyor, eski bir collection ve Senkronize olarak çalışır.

        Vector vector = new Vector();
        vector.add("A");

        // Hafıza'da 10 boyutluk bir yer ayırır. 11. yi eklediğinizde kapasite 20 olur.

        System.out.println(vector.capacity());


        // Kapasiteyi 4'er arttırmak için "Vector vector = new Vector(4)" diyebiliriz.
        // new Vector(4, 2) kapasite 4'ten başlayıp 2şer artar.

    }
}
