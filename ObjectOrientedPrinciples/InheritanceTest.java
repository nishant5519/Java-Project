package ObjectOrientedPrinciples;

public class InheritanceTest {

	public static void main(String[] args) {
		System.out.println();
		Vehicle v = new Vehicle(),c=new Vehicle();
		System.out.println("Class name for v is:" + v.getClass());
		//Bike b = (Bike)v;
		Bike bike=new Bike();
		Car car=new Car();
		Vehicle vBike=new Bike();
		System.out.println("Class name for vBike is:" + vBike.getClass());
		Vehicle vCar=new Car();
		vCar.display();
		System.out.println("value of i:" + vCar.i);
		vCar.getSound("1");
		
		/*---------------------------------------------*/
		String s2=new String("abc");
		String s1="abc";		
		String s3="abc";
		String s4=new String("abc").intern();
		String s5=new String("abc");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s4);
		System.out.println(s2==s3);
		System.out.println(s2==s4);
		System.out.println(s2==s5);
		
		
	}

}

class Vehicle {
	int i=10;
	
	public void getSound(Object I) {
		System.out.println("Inside vehicle:" + I);
	}
	public void display(){
		System.out.println("Inside Vehicle class");
	}
}

class Car extends Vehicle {
	int i=100;

	public void getSound(String O) {
		System.out.println(O);
	}
	public void display(){
		System.out.println("Inside Car class");
	}
}

class Bike extends Vehicle {
	int i=1000;
	public void getSound() {
		System.out.println("In Bike");
	}
	public void display(){
		System.out.println("Bike Vehicle class");
	}
}
