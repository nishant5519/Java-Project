package com.constructor;

public class ClassTest {

	static int x = 0;
	int y = ++x;
	static int z = x;

	public static void main(String[] args) {
		ClassTest1 a = new ClassTest1(1);
		ClassTest obj = new ClassTest();
		ClassTest obj1 = new ClassTest();
		ClassTest obj2 = new ClassTest();
		System.out.println(x);
		System.out.println(z);
		System.out.println(obj.y);
		System.out.println(obj1.y);
		System.out.println(obj2.y);
//		System.out.println(obj1.x);
	}

}

class ClassTest1 {

	ClassTest1() {
		class ClassTest2 {
			{
				System.out.println("Default Constructor");
			}
		}
	}

	ClassTest1(int i) {
		this();
		class ClassTest2 {
			{
				System.out.println("Not a default constructor one");
			}
		}
	}

	ClassTest1(int i, int b) {
		class ClassTest2 {
			{
				System.out.println("Not a default constructor two");
			}
		}
	}
}