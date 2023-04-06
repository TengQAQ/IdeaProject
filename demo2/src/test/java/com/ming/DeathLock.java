package com.ming;

public class DeathLock {
	private static Object lockA = new Object();
	private static Object lockB = new Object();

	private static class A extends Thread{
		@Override
		public void run() {
			synchronized (lockA) { // 对lockA对象上锁
				System.out.println("A线程对lockA上锁了，正在尝试对lockB上锁");
				try {
					sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				// A线程尝试对lockB上锁
				synchronized (lockB) {
					System.out.println("A线程对lockB上锁了");
				}
			}
		}
	}

	private static class B extends Thread{
		@Override
		public void run() {
			synchronized (lockB) { // 对lockB对象上锁
				System.out.println("B线程对lockB上锁了，正在尝试对lockA上锁");
				try {
					sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				synchronized (lockA) {
					System.out.println("B线程对lockA上锁了");
				}
			}
		}
	}

	/**
	 * 不同的线程分别占用彼此需要的资源不放弃则形成了死锁；
	 * 出现死锁时，程序不会结束，但是也没有结果。
	 * @param args
	 */
	public static void main(String[] args) {
		Thread a = new A();
		Thread b = new B();
		a.start();
		b.start();
	}
}
