package ObjectOrientedPrinciples;

public class InitializationBlocktest {

	public static void main(String[] args) {
		Child child = new Child();
	}

}

class Parent{
	
	static {
		System.out.println("Parent Static block");
	}
	{
		System.out.println("Parent Initialization block");
	}
	public Parent() {
		System.out.println("Parent Constructor");
	}
	
}

class Child extends Parent{
	
	static {
		System.out.println("Child Static block");
	}
	{
		System.out.println("Child Initialization block");
	}
	public Child() {
		System.out.println("Child Constructor");
	}
	
}
