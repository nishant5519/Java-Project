package com.ObjectOrientedPrinciples;

public class FieldsAndInheritance {

	public static void main(String[] args) {
		Cars car = new Cars();

		car.updateLicensePlate("abc"); //update in Cars class
		car.setLicensePlate("123"); //sets in Vehicle class
		

		System.out.println("license plate: "
		        + car.getLicensePlate());
	}

}

class Vehicles {

    String licensePlate = null;

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

	public Vehicles() {
		super();
		System.out.println("Inside Parent class constructor");

	}
}

class Cars extends Vehicles {
	protected String licensePlate = null;

    public Cars() {
		super();
		System.out.println("Inside child class constructor");
	}

	
    @Override
    public void setLicensePlate(String license) {
        super.setLicensePlate(license);
    }

    @Override
    public String getLicensePlate() {
        return super.getLicensePlate();
    }

    public void updateLicensePlate(String license){
        this.licensePlate = license;
    }
}