package com.arifacar.datastructure.collection.queue;

import java.util.LinkedList;
import java.util.Queue;
public class JavaUtilQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(6);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2); // offer da ekleme yapar hata fırlatmaz

        System.out.println("QUEUE LIST: ");
        queue.stream().forEach(System.out::println);

        System.out.println("REMOVING: ");
        System.out.println(queue.remove()); // 6  - remove ve poll aynı, poll hata fırlatmaz.
        System.out.println(queue.remove()); // 5
        System.out.println(queue.remove()); // 4

        System.out.println("FIRST ITEM: ");
        System.out.println(queue.element()); // element ve peek,  peek hata fırlatmaz.

        System.out.println("ITEM SIZE: ");
        System.out.println(queue.size());

        System.out.println("LAST STATUS: ");
        queue.stream().forEach(System.out::println);
    }

}
