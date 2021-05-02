package companies.onlinetest;

import java.util.ArrayList;
import java.util.List;

public class Implementer implements Runnable {

	public static void main(String[] args) {
		new Extender(new Implementer()).start();
		new Extender().start();
		new Thread(new Implementer()).start();

		// next question
		callType(10);
		callType("Null");
		callType("abc");
		// callType(null);

		// next question
		List<Pet> p = new ArrayList<Pet>();
		List<Dog> d = new ArrayList<Dog>();
		List<Cat> c = new ArrayList<Cat>();
		examine(p);
		examine(d);
		examine(c);

	}

	@Override
	public void run() {
		System.out.println("Implementer");

	}

	private static void callType(Number num) {
		System.out.println("Number passed");
	}

	private static void callType(Object obj) {
		System.out.println("Object passed");
	}

	private static void callType(String s) {
		System.out.println("String passed");
	}

	private static void callType(Integer i) {
		System.out.println("Integer passed");
	}

	static void examine(List<? extends Pet> pets) {
		System.out.println("Your pets need urgent attaention");
	}

}

class Extender extends Thread {
	public Extender() {

	}

	public Extender(Runnable runnable) {
		super(runnable);
	}

	public void run() {
		System.out.println("Extender");

	}

}

interface Wagger {
}

class Pet implements Wagger {

}

class Dog extends Pet {
}

class Cat extends Pet {
}
