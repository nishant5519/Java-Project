package Collections;

import java.util.Arrays;

public class ArraysTest {
//https://stackoverflow.com/questions/27754883/why-java-method-arrays-copyof-behaviour-is-not-the-same-when-it-deals-with-an
	public static void main(String[] args) {
		int[] array1 = { 10, 2, 3 };
		int[] array2 = Arrays.copyOf(array1, array1.length);
		array1[1] = 22; // value of array2[1] is not set to 22
		array1[2] = 33; // value of array2[2] is not set to 33
		for (int i = 0; i < 3; i++) {
			System.out.print(array1[i] + " ");
			System.out.println(array2[i]);
		}
		
		System.out.println("Different behaviour of Arrays.copyof in case of primitive and Objects");

		Person[] AllPersons = new Person[3];

		for (int i = 0; i < 3; i++) {
			AllPersons[i] = new Person();
		}

		AllPersons[2].Name = "xyz";
		//do a shallow copy of objects if applied on an array of non-primitive object.Same thing happens for clone method as well
		Person[] OtherPersons = Arrays.copyOf(AllPersons, 3); //value of OtherPersons[2].Name is also se to "xyz"
		System.out.println("AllPersons[2].Name::" + AllPersons[2].Name + " And " + "OtherPersons[2].Name: " + OtherPersons[2].Name);
		
        AllPersons[2].Name = "pqr"; // value of OtherPersons[2].Name is also set to "pqr"
		OtherPersons[2].Name = "hij"; // value of AllPersons[2].Name is also set to "hij"
	}

}

class Person {
	String Name;
}
