package com.ming.thread;

import java.util.stream.IntStream;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        IntStream.rangeClosed(1,100)
                .filter(i -> i % 2 == 0)
                .forEach(i -> {
                    System.out.println("偶数：" + i);
                    try {
                        // 让当前线程休眠100毫秒
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
