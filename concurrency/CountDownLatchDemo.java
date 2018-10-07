package com.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	// creates a latch that requires five events to occur before it opens.
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		System.out.println("Starting");
		new MyThread(cdl);
		try {
			cdl.await();// this causes execution of the main thread to pause
						// until cdl’s count has been decremented five times
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println("Done");
	}
}

class MyThread implements Runnable {
	CountDownLatch latch;

	MyThread(CountDownLatch c) {
		latch = c;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			latch.countDown(); // decrement count
		}
	}

}
