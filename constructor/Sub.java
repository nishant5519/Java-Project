package constructor;

public class Sub extends Super {
	//If Superclass does not have a no-arg constructor ,then in your subclass you cannot use default constructor supplied by compiler.
	
	public Sub(String a) {
		super(a);
		System.out.println("Inside sub arg constructor");
		i = 2;
	}

	public static void main(String[] args) {
		Super sub = new Sub("Hello");
		System.out.println(sub.i);
	}

}

class Super {
	public int i = 0;

	public Super(String text) {
		this();// calls overloaded no-arg constructor
		i = 1;		
		System.out.println("Inside Super arg constructor");
	}
	public Super() {
	//	this("a"); recursive call to constructor not allowed
		System.out.println("Inside Super no-arg constructor");
	}
}
