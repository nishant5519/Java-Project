package com.companies.onlinetest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {
	public static void main(String[] args) {

		try {
			System.out.println("Serialization Start");
			FileOutputStream fos = new FileOutputStream(new File(
					"Serialize.ser"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new SerializableClass(12));
			oos.close();
			System.out.println("Serialization end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class NewClass {

}

class SerializableClass implements Serializable {
	private NewClass newClsObj;
	private int i;

	public SerializableClass(int i) {
		this.i = i;
	}

}
