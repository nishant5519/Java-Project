package Generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestGenerics {

	public static void main(String[] args) {
		List<Animal> list = new ArrayList<Animal>();
		list.add(new Animal());
		list.add(new Dog());
		list.add(new Cow());
		Animal animal1 = new Animal();
		animal1.eat();
		Animal animal2 = new Dog();
		animal2.eat();
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		List<Cow> cows = new ArrayList<Cow>();
		cows.add(new Cow());
		cows.add(new Cow());
		Animal_Doctor doctor = new Animal_Doctor();
		doctor.checkAnimals(list);
		doctor.checkAnimals(dogs);
		doctor.checkAnimals(cows);

	}

}

class Animal {
	public void eat() {
		System.out.println("Simply Eat");
	}

	public void checkup() {
		System.out.println("Simple checking the animal");
	}
}

class Dog extends Animal {
	public void eat() {
		System.out.println("Kills small animals like rats,cats etc");
	}

	public void checkup() {
		System.out.println("checking the Dog");
	}
}

class Cow extends Animal {
	public void eat() {
		System.out.println("Eats grass");
	}

	public void checkup() {
		System.out.println("checking the Cow");
	}
}

class AnimalDoctor {
	public void checkAnimals(List<? extends Animal> animal) {
		for (Animal a : animal)
			a.checkup();
	}
}
