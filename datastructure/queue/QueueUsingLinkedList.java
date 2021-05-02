package queue;

public class QueueUsingLinkedList {

	public static void main(String[] args) {
		// Time complexity of both operations enqueue() and dequeue() is O(1) as
		// we only change few pointers in both operations. There is no loop in
		// any of the operations.

		LinkedQueue q = new LinkedQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		System.out.println("Dequeued item is " + q.dequeue().data);

	}

}

class Node {
	int data;
	Node next;

	public Node(int d) {
		this.data = d;
		this.next = null;
	}
}

class LinkedQueue {
	Node front, rear;

	public LinkedQueue() {
		this.front = this.rear = null;
	}

	void enqueue(int key) {
		Node node = new Node(key);
		if (this.rear == null) {
			this.rear = this.front = node;
		} else {
			this.rear.next = node;
			this.rear = node;
		}
	}

	Node dequeue() {
		if (this.front == null)
			return null;

		Node temp = this.front;
		this.front = this.front.next;
		if (this.front == null)
			this.rear = null;

		return temp;
	}
}
