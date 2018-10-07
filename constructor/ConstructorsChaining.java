package com.constructor;

public class ConstructorsChaining {
	public static void main(String[] args) {
		Swift swift = new Swift("CDI");
		System.out.println("================");
		Maruti maruti = new Maruti("VDI");
	}

}


abstract class Vehicles {
	String type;
	Vehicles() {
		System.out.println("Inside abstract class vehicle constructor");
	}
	Vehicles(String type) {
		this.type=type;
		System.out.println("Inside abstract class vehicle arg-constructor");
	}
}

 class CarVehicle extends Vehicles {
	String name;
	int wheels;

	public CarVehicle(String s) {
		this(); // calls overloaded no-arg constructor
		this.name = s;
		System.out.println("Inside arg constructor of CarVehicle class");

	}
	CarVehicle(int w) {
		this(); // calls overloaded no-arg constructor
		this.wheels = w;
		System.out.println("Inside arg constructor of CarVehicle class with wheels");

	}

	CarVehicle() {
	//	this();
		System.out.println("Inside no-arg constructor of CarVehicle class ");
	}

}
class Maruti extends CarVehicle {
	Maruti(String n) {
		 super(); //no need to write it explicitly
	//or super(n);
		System.out.println("Inside arg constructor of Maruti class");
	}
	Maruti(){
		this(randomName()); //Only static methods and variables can be accessed as part of the call to super() or this()
	}
	
	static String randomName(){
		return "Baleno";
	}
}

class Swift extends Maruti {

	Swift(String n) {
		// super(); will not work
		super(n);
		System.out.println("Inside arg constructor of Swift class ");
	}

}
