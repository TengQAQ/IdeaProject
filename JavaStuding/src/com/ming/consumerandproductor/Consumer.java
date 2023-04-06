package com.ming.consumerandproductor;

public class Consumer implements Runnable {
    private Store store;

    @Override
    public void run() {
        store.sellBread();
    }

    public Consumer(Store store) {
        this.store = store;
    }
}
