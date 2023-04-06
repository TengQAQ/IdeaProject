package com.ming.consumerandproductor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Productor implements Runnable {
    private Store store;
    AtomicInteger ai = new AtomicInteger();
    List<String> name = Arrays.asList("吐司面包","黎协面包","寿司面包","王欣俊面包");
    List<Double> prises = Arrays.asList(10.0,20.0,30.0,40.0);
    public Productor(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        Bread bread = new Bread();
        bread.setName(name.get(Integer.valueOf(ai.toString())));
        bread.setDate(new Date(System.currentTimeMillis()));
        bread.setPrice(prises.get(Integer.valueOf(ai.toString())));
        bread.setCodeid(ai.getAndIncrement());
        store.MakingBread(bread);
    }
}
