package com.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		System.out.println("Starting");
		new MyThreadDemo(cb, "A");
		new MyThreadDemo(cb, "B");
		new MyThreadDemo(cb, "C");
	}

}

class MyThreadDemo implements Runnable {
	CyclicBarrier cbar;
	String name;

	MyThreadDemo(CyclicBarrier c, String n) {
		cbar = c;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println(name);
		try {			
			System.out.println("await method returns" + cbar.await());//threads wait for each other by calling await()
		} catch (BrokenBarrierException exc) {
			System.out.println(exc);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
	}
}

// An object of this class is called when the CyclicBarrier ends.
class BarAction implements Runnable {
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Barrier Reached!");
	}
}