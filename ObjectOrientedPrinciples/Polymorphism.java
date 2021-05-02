package ObjectOrientedPrinciples;

public class Polymorphism {
	public static void main(String[] args) {
		Shape s = new Shape();
		Rectangle r = new Rectangle();

		System.out.println(r);
		System.out.println(r.x + "\n");

		s = r;
		System.out.println(s);
		s.getArea();
		System.out.println(s.x);// There is no polymorphism for fields in Java.
		System.out.println(r.x);
		System.out.println(s.getX());
		System.out.println(((Rectangle) s).x);
		System.out.println(((Rectangle) r).x);
		System.out.println(((Shape) s).x);
		System.out.println(((Shape) r).x);
		System.out.println("Value of final variable:" + s.finalVar);
	}

}

class Shape {

	public int x = 0;
	final int finalVar = 10;

	public void getArea() {
		System.out.println("I don't know my area!");
	}

	public String toString() {
		return "I am a shape!";
	}

	public int getX() {
		return x;
	}
}

class Rectangle extends Shape {

	public int x = 1;

	public int getX() {
		return x;
	}

	public void getArea() {
		System.out.println("L*W");
	}

	public String toString() {
		return "I am a rectangle!";
	}
}