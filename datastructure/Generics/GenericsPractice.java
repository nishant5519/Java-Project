package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsPractice {

	public static void main(String[] args) {
		List<Animal_wild> list = new ArrayList<Animal_wild>();
		list.add(new Animal_wild());
		list.add(new Dog_wild());
		list.add(new Cow_wild());
		Animal_wild animal1 = new Animal_wild();
		animal1.eat();
		Animal_wild animal2 = new Dog_wild();
		animal2.eat();
		List<Dog_wild> dogs = new ArrayList<Dog_wild>();
		dogs.add(new Dog_wild());
		dogs.add(new Dog_wild());
		List<Cow_wild> cows = new ArrayList<Cow_wild>();
		cows.add(new Cow_wild());
		cows.add(new Cow_wild());
		Animal_Doctor doctor = new Animal_Doctor();
		doctor.checkAnimals(list);
		doctor.checkAnimals(dogs);
		doctor.checkAnimals(cows);
		
		List<Object> list1=new ArrayList<Object>();
		list1.add(1);
		list1.add("a");
		list1.add("B");
		for (Object object : list1) {
			System.out.println(object);
			
		}
		
		List list2=new ArrayList();
		list1.add(1);
		list1.add("a");
		list1.add("B");
		for (Object object : list1) {
			System.out.println(object);
			
		}

	}

}

class Animal_wild {
	public void eat() {
		System.out.println("Simply Eat");
	}

	public void checkup() {
		System.out.println("Simple checking the animal");
	}
}

class Dog_wild extends Animal_wild {
	public void eat() {
		System.out.println("Kills small animals like rats,cats etc");
	}

	public void checkup() {
		System.out.println("checking the Dog");
	}
}

class Cow_wild extends Animal_wild {
	public void eat() {
		System.out.println("Eats grass");
	}

	public void checkup() {
		System.out.println("checking the Cow");
	}
}

class Animal_Doctor {
	public void checkAnimals(List<? extends Animal_wild> animal) {
		for (Animal_wild a : animal)
			a.checkup();
	}
}
