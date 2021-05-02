package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
	public static void main(String[] args) {
		new AtomThread("A");
		new AtomThread("B");
	//	new AtomThread("C");
	}
}

class SharedResources1 {
	static AtomicInteger ai = new AtomicInteger(0);
}

// A thread of execution that increments count.
class AtomThread1 implements Runnable {
	String name;

	AtomThread1(String n) {
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Starting " + name);
		for (int i = 1; i <= 3; i++)
			System.out.println(name + " got: " + SharedResources1.ai.getAndSet(i));
	}

}
