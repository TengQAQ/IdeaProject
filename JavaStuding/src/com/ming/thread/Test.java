package com.ming.thread;

public class Test {
    public static void main(String[] args) {

        Thread thread = new Thread();
        thread.start();

        Thread thread1 = new Thread(new PrimeNumber());
        thread1.start();


    }
}
