package com.multithreading;

public class Multithreading_program {

	public static void main(String[] args) {
		new newThread();
		System.out.println("Main thread completed");
	}

}

class newThread extends Thread {
	Thread t;

	newThread() {
		t = new Thread(this, "My Thread");
		t.start();
	}

	public void run() {
		try {
		//	t.join();
			System.out.println(t.getName());
			System.out.println(Thread.currentThread().getName());
		}

		catch (Exception e) {
			System.out.println("Exception");
		}
	}
}