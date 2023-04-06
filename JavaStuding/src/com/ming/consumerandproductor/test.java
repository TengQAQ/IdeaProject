package com.ming.consumerandproductor;

public class test {
    public static void main(String[] args) {
        Store store = new Store();
        Runnable c1 = new Consumer(store);
        Runnable p1 = new Productor(store);

        Thread t1 = new Thread(c1,"小张");
        Thread t2 = new Thread(p1, "老李");
        Thread t3 = new Thread(c1, "小王");
        Thread t4 = new Thread(p1, "老刘");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
