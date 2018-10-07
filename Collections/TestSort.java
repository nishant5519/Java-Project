package com.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestSort {

	public static void main(String[] args) {
		ArrayList<Students> ar = new ArrayList<Students>();
		ar.add(new Students(111, "bbbb", "london"));
		ar.add(new Students(131, "aaaa", "nyc"));
		ar.add(new Students(121, "cccc", "jaipur"));

		System.out.println("Unsorted");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new Sortbyroll());

		System.out.println("\nSorted by rollno");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
	}

}

class Sortbyroll implements Comparator<Students> {
	// Used for sorting in ascending order of
	// roll number
	public int compare(Students a, Students b) {
		return a.rollno - b.rollno;
	}
}

class Students {
	int rollno;
	String name, address;

	// Constructor
	public Students(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	// Used to print student details in main()
	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}
