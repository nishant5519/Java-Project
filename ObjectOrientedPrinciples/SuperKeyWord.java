package ObjectOrientedPrinciples;

/* Base class vehicle */
class BeastVehicle {
	int maxSpeed = 120;
	
	BeastVehicle(){
		System.out.println("BeastVehicle class constructor");
	}
	void message(){
		System.out.println("Inside BeastVehicle class");
	}
}

/* sub class Car extending vehicle */
class Motorcar extends BeastVehicle {
	int maxSpeed = 180;
	
	Motorcar(){
		super();
		System.out.println("Motorcar class constructor");
	}
	
	void message(){
		System.out.println("Inside Motorcar class");
	}

	void display() {
		/* print maxSpeed of base class (vehicle) */
		System.out.println("Maximum Speed: " + super.maxSpeed);
		message();
		super.message();
	}
}

/* Driver program to test */
class SuperKeyWord {
	public static void main(String[] args) {
		Motorcar small = new Motorcar();
		small.display();
	}
}