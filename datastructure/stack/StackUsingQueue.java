package com.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	public void push(int x) {
		q1.add(x);
		System.out.println(x + " pushed into the stack");
	}

	public int pop() {
		if (q1.size() == 1) {
			return q1.remove();
		} else {
			int l = q1.size();
			for (int i = 0; i < l - 1; i++) {
				q2.add(q1.remove());
			}
			int res = q1.remove();
			return res;
		}
	}

	public static void main(String args[]) {
		StackUsingQueue mc = new StackUsingQueue();
		mc.push(1);
		mc.push(2);
		mc.push(3);
		System.out.println("Element popped from the stack: " + mc.pop());
		mc.push(4);
		System.out.println("Element popped from the stack: " + mc.pop());
	}

}
