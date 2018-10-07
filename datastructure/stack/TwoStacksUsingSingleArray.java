package com.datastructure.stack;

public class TwoStacksUsingSingleArray {

	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.println("Popped element from" + " stack1 is " + ts.pop1());
		ts.push2(40);
		ts.pop2();
		System.out.println("Popped element from" + " stack2 is " + ts.pop2());
	}

}

class TwoStacks {
	int size;
	int top1, top2;
	int[] arr;

	public TwoStacks(int size) {
		super();
		this.size = size;
		this.top1 = -1;
		this.top2 = size;
		arr = new int[size];
	}

	void push1(int a) {
		if (top1 < top2 - 1)
			arr[++top1] = a;
		else
			System.out.println("Stack Overflow");
	}

	void push2(int b) {
		if (top1 < top2 - 1)
			arr[--top2] = b;
		else
			System.out.println("Stack Overflow");
	}

	int pop1() {
		if (top1 > -1)
			return arr[top1--];
		else
			System.out.println("Stack Underflow");
		return 0;
	}

	int pop2() {
		if (top2 < size)
			return arr[top2++];
		else
			System.out.println("Stack Underflow");
		return 0;
	}

}