package com.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//four tasks share the two threads that are in the pool.
public class ExecutorServiceExample {
	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(4);
		System.out.println("Starting");
		// Start the threads.
		es.execute(new MyThreadExample(cdl, "A"));
		es.execute(new MyThreadExample(cdl2, "B"));
		es.execute(new MyThreadExample(cdl3, "C"));
		es.execute(new MyThreadExample(cdl4, "D"));
		try {
			cdl.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		es.shutdown();
		System.out.println("Done");
	}

}

class MyThreadExample implements Runnable {
	String name;
	CountDownLatch latch;

	MyThreadExample(CountDownLatch c, String n) {
		latch = c;
		name = n;
		new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}