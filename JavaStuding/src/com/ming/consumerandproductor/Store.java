package com.ming.consumerandproductor;

import java.util.concurrent.ArrayBlockingQueue;

public class Store {
    ArrayBlockingQueue<Bread> aQueue=new ArrayBlockingQueue<Bread>(10);

    public synchronized void MakingBread(Bread bread){

        if (aQueue.size() >= 10){
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }else {
            aQueue.offer(bread);
            System.out.println(Thread.currentThread().getName() + "已经生产秒爆" + bread.toString());
        }
        notifyAll();
    }

    public synchronized void sellBread(){
        if (aQueue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        }else {
            aQueue.poll();
            System.out.println(Thread.currentThread().getName() + "已经销售了面包。" + "当前数量：" + aQueue.size());
        }

    }

}
