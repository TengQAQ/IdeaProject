package com.ming.sellticket;

public class Demo2 {
    public static void main(String[] args) {
        Runnable runnable = new Ticket();

        // 同一个runnable对象被4个线程共享
        Thread a = new Thread(runnable,"A窗口");
        Thread b = new Thread(runnable,"B窗口");
        Thread c = new Thread(runnable,"C窗口");
        Thread d = new Thread(runnable,"D窗口");
        a.start();
        b.start();
        c.start();
        d.start();
    }

    private static class Ticket implements Runnable {
        int ticket = 10;
        // 一个标记
        private final Object lock = new Object();
        /**
         * run方法是一个代码逻辑片段，不会存储任何数据
         * 4个窗口的线程都使用相同的逻辑来共同销售100张票
         * 因此，将ticket称为多个线程的共享数据
         */
        @Override
        public void run() {

            // 只要还有余票，则当前线程继续卖票
            while (this.ticket > 0) {
                // 得到当前正在运行的线程对象
                Thread thread = Thread.currentThread();
                // 得到当前正在运行的线程名称
                String name = thread.getName();

                // 出现重复和跳票的原因： 这三行代码的执行被别的线程中断了
                // 解决方法： 想办法让当前线程在执行这三行代码时，不允许别的线程
                // 也来执行这里的代码
                // 坏处： cpu的控制权交给了线程本身，线程执行时间由线程本身控制
                // 如果执行代码比较耗时，则其他的线程都必须等待当前线程执行结束后才有机会得到执行

                // start transaction;
                System.out.println(ticket);
                synchronized (this.lock){ // 多个线程都能够访问到的共享锁
                    System.out.println(ticket);
//                    if (this.ticket > 0) { // 双重检查
                        System.out.print(name + "正在销售第" + this.ticket + "张票");
                        this.ticket--;
                        System.out.println(",余票" + this.ticket);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                    }
                }
                // commit;
            }
        }
    }
}