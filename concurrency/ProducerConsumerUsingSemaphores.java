package com.concurrency;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProducerConsumerUsingSemaphores {

	public static void main(String[] args) {
		// creating buffer queue
		MyQueue myQueue = new MyQueue();

		ProducerClass producer = new ProducerClass(myQueue);
		ConsumerClass consumer = new ConsumerClass(myQueue);
		Thread producerThread = new Thread(producer);

		producerThread.start();

		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
	}

}

class MyQueue {
	// an item
	private int item;

	// semaphoreConsumer initialized with 0 permits
	// to ensure put() method executes first
	private Semaphore semaphoreConsumer = new Semaphore(0);
	private Semaphore semaphoreProducer = new Semaphore(1);

	// to get an item from buffer
	public void get() {
		try {
			// Before consumer can consume an item,
			// it must acquire a permit from semaphoreConsumer
			semaphoreConsumer.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		// consumer consuming an item
		System.out.println("Consumer consumed item : " + item);

		// After consumer consumes the item,
		// it releases semaphoreProducer to notify producer
		semaphoreProducer.release();
	}

	// To put an item in buffer
	public void put(int item) {
		try {
			// Before producer can produce an item,
			// it must acquire a permit from semaphoreProducer
			semaphoreProducer.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		// producer producing an item
		this.item = item;
		System.out.println("Producer produced item : " + item);

		// After producer produces the item,
		// it releases semaphoreConsumer to notify consumer
		semaphoreConsumer.release();
	}
}

class ConsumerClass implements Runnable {
	private MyQueue myQueue;

	public ConsumerClass(MyQueue myQueue) {
		this.myQueue = myQueue;
	}

	public void run() {
		while (true) {
			// consumer get items
			myQueue.get();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ProducerClass implements Runnable {
	private MyQueue myQueue;

	public ProducerClass(MyQueue myQueue) {
		this.myQueue = myQueue;
	}

	public void run() {
		while (true) {
			Random random = new Random();
			int data = random.nextInt(100);
			// producer put items
			myQueue.put(data);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}