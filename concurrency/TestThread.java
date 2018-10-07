package com.concurrency;

public class TestThread {
	static int x = 10;

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();
				System.out.println("Running Thread in Job1 "
						+ "and thread name is " + Thread.currentThread()
						+ "and Value of x is " + x);

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();
				System.out.println("Running Thread in Job2 "
						+ "and thread name is " + Thread.currentThread()
						+ "and Value of x is " + x);
			}
		});

		t1.start();
		t2.start();
		System.out.println("Current Thread:" + Thread.currentThread());
		System.out.println("Value of x:" + x);
		System.out.println("Main thread ends");
	}

	static synchronized void increment() {
		x++;
	}

}
