package com.constructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Question {
	public static void main(String[] args) {
		m1(new Extension());

		B b = new B();

		// 2nd question start
		List<String> list = new ArrayList<String>();
		list.add("Value1");
		Iterator<String> itr = list.iterator();
		list.remove(0);
		while (itr.hasNext())
			System.out.println(itr.next());
		// 2nd question end

		// 3rd question start
		List vitamins = new ArrayList();
		vitamins.add("A");
		vitamins.add("B12");
		vitamins.add("C");
		vitamins.set(1, "B");
		vitamins.add(1, "D");
		System.out.println("Vitamins " + vitamins);
		// 3rd question end

		// 4th Question
		Question q1 = new Question();
		try {
			q1.m1();
		} catch (RuntimeException e) {
			System.out.println("Runtime exception");
		} catch (Exception e) {
			System.out.println("Exception");
		}

	}

	public void m1() throws Exception {
		try {
			m2();
		} finally {
			m3();
		}
	}

	public void m2() throws RuntimeException {
		throw new RuntimeException();
	}

	public void m3() throws Exception {
		throw new Exception();
	}

	static void m1(Base b) {
		b.add(8);
		b.print();
	}

}

class Base {
	int i;

	Base() {
		add(1);
	}

	void add(int v) {
		i += v; // i=1
		System.out.println("Inside Base's add method");
	}

	void print() {
		System.out.println(i);
	}
}

class Extension extends Base {
	Extension() {
		add(2);
	}

	void add(int v) {
		i += v * 2; // i=4
		System.out.println("Inside Extension's add method");
	}
}

class A {
	public A() {

	}

	public A(int i) {
		this();
	}
}

class B extends A {
	public boolean B(String msg) {
		return false;
	}
}

class C extends B {
	private C() {
		super();
	}

	public C(String msg) {
		this();
	}

	public C(int i) {

	}
}

/*
 * class X{ public<T extends Number> void method(T arg){} public void
 * method(Number arg){
 * 
 * } Not compiles successfully* }
 */

class clothing {
	clothing(String s) {

	}
}

class Tshirt extends clothing {

	Tshirt(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

}