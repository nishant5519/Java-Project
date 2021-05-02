package concurrency;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueCustomImplementation<T> {

	private List<T> queue = new LinkedList<T>();
	private int limit = 5;

	public BlockingQueueCustomImplementation(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(T element)
			throws InterruptedException {
		while (this.queue.size() == limit)
			wait();
		if (this.queue.size() == 0)
			notifyAll();
		this.queue.add(element);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0)
			wait();
		if (this.queue.size() == limit)
			notifyAll();
		return this.queue.remove(0);

	}
}
