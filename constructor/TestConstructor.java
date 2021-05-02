package constructor;

public class TestConstructor {
	int i = 0;

	TestConstructor() {
		System.out.println("Inside constructor");
	}

	TestConstructor(int x) {
		super();
	//	this();
		this.i = x;
		System.out.println("Inside parametrized constructor");
	}

	public static void main(String[] args) {
		new TestConstructor(10);
	}

}
