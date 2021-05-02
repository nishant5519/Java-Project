package concurrency;

import java.util.Scanner;

public class WaitandNotifyDemo {
	public static void main(String[] args) throws InterruptedException {
		final Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException ignored) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException ignored) {
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}

class Processor {

	/*
	 * public synchronized void getSomething(){ this.hello = "hello World"; }
	 * public void getSomething(){ synchronized(this){ this.hello = "hello
	 * World"; } } two code blocks by specification, functionally identical.
	 */

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running ....");
			wait();// this.wait() is fine.
			System.out.println("Resumed.");
		}
	}

	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			System.out.println("Return key pressed.");
			notify();
			Thread.sleep(5000);
			System.out.println("Consumption done.");
		}
	}
}
