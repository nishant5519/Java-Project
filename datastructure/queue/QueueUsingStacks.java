package com.datastructure.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

//This means the newest element must be pushed to the bottom of the stack
public class QueueUsingStacks {
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> temp = new Stack<Integer>();

	// Function to enqueue an item to the queue.Push - O(n) per operation
	void enQueue(int x) {
		if (s.size() == 0)
			s.push(x);
		else {
			while (!s.isEmpty())
				temp.push(s.pop());
			s.push(x);
			while (!temp.isEmpty())
				s.push(temp.pop());
		}
	}

	/* Function to dequeue an item from queue .Pop -O(1) per operation */
	int deQueue() {
		if (s.size() == 0)
			throw new NoSuchElementException("Underflow Exception");
		return s.pop();
	}

	/* Function to check the front element of the queue */
	public int peek() {
		if (s.size() == 0)
			throw new NoSuchElementException("Underflow Exception");
		return s.peek();
	}

	/* Function to check if queue is empty */
	public boolean isEmpty() {
		return s.size() == 0;
	}

	/* Function to get the size of the queue */
	public int getSize() {
		return s.size();
	}

	/* Function to display the status of the queue */
	public void display() {
		System.out.print("\nQueue = ");
		int l = getSize();
		if (l == 0)
			System.out.print("Empty\n");
		else {
			/* Iterator wont return for stack in order */
			for (int i = l - 1; i >= 0; i--)
				System.out.print(s.get(i) + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		QueueUsingStacks q = new QueueUsingStacks();
		q.enQueue(1);
		q.enQueue(4);
		q.enQueue(2);

		System.out.print(q.deQueue() + " ");
		System.out.print(q.deQueue() + " ");
		System.out.println(q.deQueue() + " ");
	}
}
