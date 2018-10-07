package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SuperClassSerializable {

	public static void main(String[] args) {
		B b1 = new B(10, 20);

		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		/* Serializing B's(subclass) object */

		// Saving of object in a file
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream("abc.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(b1);
			// closing streams
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Method for serialization of B's class object

		System.out.println("Object has been serialized");
		B b2 = null;
		try {
			/* De-Serializing B's(subclass) object */

			// Reading the object from a file
			FileInputStream fis = new FileInputStream("abc.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Method for de-serialization of B's class object
			b2 = (B) ois.readObject();

			// closing streams
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}

}

// superclass A
// implementing Serializable interface
class A implements Serializable {
	int i;

	// parameterized constructor
	public A(int i) {
		this.i = i;
	}

}

// subclass B
// B class doesn't implement Serializable
// interface.
class B extends A {
	int j;

	// parameterized constructor
	public B(int i, int j) {
		super(i);
		this.j = j;
	}
}