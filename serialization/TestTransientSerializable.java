package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestTransientSerializable implements Serializable {

	// Normal variables
	int i = 10, j = 20;

	// Transient variables
	transient String k = "abc";

	// Use of transient has no impact here
	transient static int l = 40;//static variables are not serialized as they are associated with class not object. In serialization objects are serialized.
	transient final int m = 50;

	public static void main(String[] args) throws Exception {
		TestTransientSerializable input = new TestTransientSerializable();

		// serialization
		FileOutputStream fos;

		fos = new FileOutputStream("abc.txt");

		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(input);
		oos.close();
		// de-serialization
		FileInputStream fis = new FileInputStream("abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		TestTransientSerializable output = (TestTransientSerializable) ois.readObject();
		ois.close();
		System.out.println("i = " + output.i);
		System.out.println("j = " + output.j);
		System.out.println("k = " + output.k);
		System.out.println("l = " + output.l);
		System.out.println("m = " + output.m);
	}

}
