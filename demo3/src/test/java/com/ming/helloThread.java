package com.ming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class helloThread extends Thread{
	public static class ticket{
		int i = 20;
		Lock lock = new ReentrantLock();

		public int getI() {
			return i;
		}
	}


	public void run() {
		while (getId() > 0){

		}
	}
	public static void main(String[] args) {

		Object o = new Object();
		Thread thread1 = new helloThread();
		Thread thread2 = new helloThread();
		thread1.start();
		thread2.start();
	}
}