package com.constructor;

import java.util.Date;

public class Simulator {

	public static void main(String[] args) {
		House house = new House(100, "Nirvana", "New Delhi");
		System.out.println(house);
	}

}

class Building {
	int height;
	String name;

	public Building() {
		// TODO Auto-generated constructor stub
	}

	public Building(int height, String name) {
		super();
		this.height = height;
		this.name = name;
	}

}

class House extends Building {
	String address;

	public House(String address) {
		super();
		this.address = address;
	}

	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	public House(int height, String name, String address) {
		super(height, name);
		this.height = height;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return height + name + address;
	}
}
