package com.ObjectOrientedPrinciples;

class Parent {
	public static void print() {
		System.out.println("I am Parent");
	}

	public void printWithOutStatic() {
		System.out.println("I am Parent");
	}

	// private methods are not overridden
	private void m1() {
		System.out.println("From parent m1()");
	}

	protected void m2() {
		System.out.println("From parent m2()");
	}
}

class Child extends Parent {
	public static void print() {
		System.out.println("I am Child");
	}

	public void printWithOutStatic() {
		System.out.println("I am Child");
	}

	// new m1() method unique to Child class
	private void m1() {
		System.out.println("From child m1()");
	}

	// overriding method with more accessibility
	@Override
	public void m2() {
		System.out.println("From child m2()");
	}
}

public class OverridingExamples {

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.print();
		parent.printWithOutStatic();

		Parent parentChild = new Child();
		parentChild.print();
		parentChild.printWithOutStatic();

		Child child = new Child();
		child.print();
		child.printWithOutStatic();
		
		parent.m2();
		parentChild.m2();
		
	}

}
