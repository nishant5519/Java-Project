package ObjectOrientedPrinciples;

public class RunTimePolymorphism {
	public static void main(String[] args) {
		Animal a = new Animal(); // Animal reference and object
		Animal b = new Dog(); // Animal reference but Dog object
		a.move();// output: Animals can move
		System.out.println(a.animal);//2
		b.move();// output:Dogs can walk and run
		System.out.println(b.animal);//2 returns 2
	}

}

class Animal {
	int animal=2;
	public void move() {
		
		System.out.println("Animals can move");
	}
}

class Dog extends Animal {
	int animal=1;
	public void move() {
		
		System.out.println("Dogs can walk and run");
	}
}