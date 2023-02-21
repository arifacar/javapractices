package com.arifacar.datastructure.collection.set;

import java.util.LinkedHashSet;

public class JavaUtilLinkedHashSet {

    public static void main(String[] args) {

        // LinkedinHashSet eklenen sırayla listelenir. Eğer bir eleman ikinci defa girilirse kopya kaydı eklemez ve sıralamayı da bozmaz.

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("Pazartesi");
        linkedHashSet.add("Salı");
        linkedHashSet.add("Çarşamba");
        linkedHashSet.add("Perşembe");
        linkedHashSet.add("Cuma");
        linkedHashSet.add("Cumartesi");
        linkedHashSet.add("Pazar");
        linkedHashSet.add("Pazartesi");
        linkedHashSet.add("Monday");

        linkedHashSet.forEach(System.out::println);


    }
}
