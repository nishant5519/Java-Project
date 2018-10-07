package com.Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomIteratorApp {

	public static void main(String[] args) {
		ArrayList<String> animal=new ArrayList<String>();
		animal.add("a");
		animal.add("b");
		animal.add("c");
		for(String x:animal){
			System.out.println(x);
		}
		 Iterator animalitr=animal.iterator();
		
		ArrayList<String> animallist = new ArrayList<String>();
		animallist.add("Horse");
		animallist.add("Lion");
		animallist.add("Tiger");
		Iterator animallistitr=animallist.iterator();

		for (String animalObj : animallist) {
			System.out.println(animalObj);
		}
	}

}

class AnimalIterable implements Iterable<String> {

	private ArrayList<String> animal = new ArrayList<String>();

	public AnimalIterable(ArrayList animal) {
		this.animal = animal;
	}

	public ArrayList getAnimalIterable() {
		return animal;
	}

	@Override
	public Iterator<String> iterator() {
		return new AnimalIterableIterator(this);
	}

}

class AnimalIterableIterator<String> implements Iterator<Object> {

	private ArrayList<?> animal;
	private int position;

	public AnimalIterableIterator(AnimalIterable animalBase) {
		this.animal = animalBase.getAnimalIterable();
	}

	@Override
	public boolean hasNext() {
		if (position < animal.size())
			return true;
		else
			return false;
	}

	@Override
	public Object next() {
		Object aniObj = animal.get(position);
		position++;
		return aniObj;
	}

	@Override
	public void remove() {
		animal.remove(position);
	}
}