package com.companies.onlinetest;

public class Main {
	public static void main(String[] args) {
		Integer i1=new Integer(2000);
		Integer i2=new Integer(3000);
		Integer i3=new Integer(4000);
		Object a=i1;
		i1=i2;
		i2=i3;
		i3=null;
		
		
		BaseLine x = new BaseLine();
		BaseLine y = new Derived();
		Derived z = new Derived();
		DoPrint(x);
		DoPrint(y);
		DoPrint(z);

		Main m = new Main();
		Object obj = new Object();
		Object Str = new String("String");
		Object intt = new Integer(10);
		print(obj);
		print(Str);
		print(intt);
		System.out.println("Calculating null method");
		print(null); 
	}

	public static void DoPrint(BaseLine o) {
		o.Print();
	}

	public static void print(Object o) {
		System.out.println("Object " + o);
	}
	public static void print(Exception e) {
		System.out.println("Exception");
	}
	public static void print(ArithmeticException ae) {
		System.out.println("ArithmeticException");
	}

	/*public void print(String s) {
		System.out.println("String " + s);
	}

	public void print(Integer i) {
		System.out.println("Integer " + i);
	}
*/
}

class BaseLine {
	public void Print() {
		System.out.println("BaseLine");
	}

}

class Derived extends BaseLine {
	public void Print() {
		System.out.println("Derived");
	}

}
