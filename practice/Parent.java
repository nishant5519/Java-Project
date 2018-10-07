package com.practice;

class X {
	static int a = 1234;
	static {
		a = a-- - --a;
		System.out.println("a: " + a);

	}
	{
		a = a++ + ++a;
		System.out.println("b :" + a);
	}

}

class Y extends X {
	static {
		a = --a - a++;
		System.out.println("c : " + a);
	}
	{
		a = ++a + a--;
		System.out.println("d : " + a);
	}
}

public class Parent {
	public static void main(String[] args) {
		Y y = new Y();
		System.out.println(Y.a);

	}

}
