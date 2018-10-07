package com.concurrency;

import java.util.concurrent.Semaphore;

public class ProdConUsingSemaphore {
	public static void main(String[] args) {
		Q q = new Q();
		new ConsumerThread(q);
		new ProducerThread(q);
	}

}

class Q {
	int n;
	// Start with consumer semaphore unavailable.Notice that semCon is initialized with no available permits. This ensures that put( )
//	executes first. The ability to set the initial synchronization state is one of the more powerful
//	aspects of a semaphore.
	static Semaphore semCon = new Semaphore(0);
	static Semaphore semProd = new Semaphore(1);

	void get() {
		try {
			semCon.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		System.out.println("Got: " + n);
		semProd.release();
	}

	void put(int n) {
		try {
			semProd.acquire(); //If the counter is greater than zero, then access is allowed
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		this.n = n;
		System.out.println("Put: " + n);
		semCon.release(); //increment semCon count by 1 for consumer and get() method runs.
	}
}

class ProducerThread implements Runnable {
	Q q;

	ProducerThread(Q q) {
		this.q = q;
		new Thread(this, "ProducerThread").start();
	}

	public void run() {
		for (int i = 0; i < 20; i++)
			q.put(i);
	}
}

class ConsumerThread implements Runnable {
	Q q;

	ConsumerThread(Q q) {
		this.q = q;
		new Thread(this, "ConsumerThread").start();
	}

	public void run() {
		for (int i = 0; i < 20; i++)
			q.get();
	}
}