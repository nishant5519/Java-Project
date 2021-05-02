package Exception;

import java.io.IOException;

class Parent {
	void msg() throws Exception {
		System.out.println("parent");
	}
}

class Test extends Parent {
	void msg() throws ArithmeticException {
		System.out.println("child");
	}

	public static void main(String args[]) {
		Parent p = new Test();
		try {
			p.msg();
		} catch (Exception e) {
		}
	}
}
