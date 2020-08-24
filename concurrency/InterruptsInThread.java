package com.concurrency;

import java.util.Random;

public class InterruptsInThread {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting. ");

		Thread t1 = new Thread(() -> {
			Random ran = new Random();

			for (int i = 0; i < 1E8; i++) {
				/*try{
					Thread.sleep(1);
				}
				catch(InterruptedException e){
					System.out.println("Thread have been interrupted");
					break;
				}*/
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Interrupted!");
					break;
				}
				Math.sin(ran.nextDouble());
			}

		});
		t1.start();
		Thread.sleep(500);
		t1.interrupt();

		t1.join();
		System.out.println("Finished");
	}

}
