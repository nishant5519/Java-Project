package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SubclassSerializableNotSuperclass {

	public static void main(String[] args) {
		SubclassB b1 = new SubclassB(10, 20);

		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);

		// Serializing SubclassB's(subclass) object
		try {
			// Saving of object in a file
			FileOutputStream fos = new FileOutputStream("abc.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Method for serialization of SubclassB's class object
			oos.writeObject(b1);
//default value of i=0(since i is inherited from Parent class) and j=20 is saved in file
			// closing streams
			
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO SuperClassAuto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO SuperClassAuto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Object has been serialized");
		SubclassB b2 = null;
		// De-Serializing SubclassB's(subclass) object
		try {
			// Reading the object from a file
			FileInputStream fis = new FileInputStream("abc.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Method for de-serialization of SubclassB's class object
			b2 = (SubclassB) ois.readObject();

			// closing streams
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO SuperClassAuto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO SuperClassAuto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO SuperClassAuto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Object has been deserialized");

		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}

}

// superclass SuperClassA
// SuperClassA class doesn't implement Serializable
// interface.
class SuperClassA {
	int i;

	// parameterized constructor
	public SuperClassA(int i) {
		this.i = i;
	}

	// default constructor this constructor must be present otherwise we will get runtime exception
	public SuperClassA() {
		i = 50;
		System.out.println("SuperClassA's class constructor called");
	}

}

// subclass SubclassB
// implementing Serializable interface
class SubclassB extends SuperClassA implements Serializable {
	int j;

	// parameterized constructor
	public SubclassB(int i, int j) {
		super(i);
		this.j = j;
	}
}
