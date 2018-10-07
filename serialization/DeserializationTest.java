package com.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationTest {

	public static void main(String[] args) {

		String fileName = "employee.ser";
		Employee empNew = null;

		try {
			empNew = (Employee) DeserializationTest.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("empNew Object::" + empNew);

	}
	
	// deserialize to Object from given file
				public static Object deserialize(String fileName) throws IOException,
						ClassNotFoundException {
					FileInputStream fis = new FileInputStream(fileName);
					ObjectInputStream ois = new ObjectInputStream(fis);
					Object obj = ois.readObject();
					ois.close();
					return obj;
				}

	
}