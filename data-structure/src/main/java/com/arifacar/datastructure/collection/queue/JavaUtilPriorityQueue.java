package com.arifacar.datastructure.collection.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaUtilPriorityQueue {

    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue();

        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(50);
        priorityQueue.add(40);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }

}
