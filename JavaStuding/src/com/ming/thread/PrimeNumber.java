package com.ming.thread;


import java.util.stream.IntStream;

/**
 * 输出1-100的素数
 */
public class PrimeNumber implements Runnable{
    @Override
    public void run() {
        IntStream.range(2,100)
                .filter(i -> {
                    for (int j = 2; j < i; j++) {
                        if (i % j == 0)
                            return false;
                    }
                    return true;
                })
                .forEach(i -> {
                    System.out.println("素数：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
