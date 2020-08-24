package com.multithreading;

public class WaitAndNotifyEasyExample {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();//new thread created
		synchronized (b) { // At this line ,Current main thread owns b object
							// monitor
			try {
				System.out.println(b + "::Waiting for b to complete...");
				b.wait(); // Main Thread gives up the lock on b and go to sleep.
				System.out.println("waiting completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Total is: " + b.total);
		}

	}

}

class ThreadB extends Thread {
	int total;

	@Override
	public void run() {
		synchronized (this) {
			System.out.println(this + "::Inside for loop");
			for (int i = 0; i < 50; i++) {
				total += i;
			}
			notify(); // wakes up the main thread on object b.
		}
	}
}
