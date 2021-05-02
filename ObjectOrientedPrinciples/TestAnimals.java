package ObjectOrientedPrinciples;

public class TestAnimals {

	public static void main(String[] args) {
		Horse h=new Horse();
		h.eat();
	}

}

class Animals{
	public void eat(){
		System.out.println("Generic eating");
	}
}

class Horse extends Animals{
	public void eat(){
		System.out.println("Horse eating");
	}
}
