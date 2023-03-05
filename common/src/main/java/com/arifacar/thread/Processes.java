package com.arifacar.thread;

public class Processes implements Runnable {

    String name;

    public Processes(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " " + i);
        }
    }
}
