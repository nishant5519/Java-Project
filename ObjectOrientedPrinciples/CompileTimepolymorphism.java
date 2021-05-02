package ObjectOrientedPrinciples;

public class CompileTimepolymorphism {
	void sum(int a, int b) {
		System.out.println(a + b);
	}

	void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public static void main(String args[]) {
		CompileTimepolymorphism obj = new CompileTimepolymorphism();
		obj.sum(10, 10, 10); // 30
		obj.sum(20, 20); // 40
	}

}
