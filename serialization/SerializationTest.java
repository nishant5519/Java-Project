package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

	public static void main(String[] args) {
		String fileName = "employee.ser";
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Pankaj");
		emp.setSalary(5000);

		// serialize to file
		try {
			SerializationTest.serialize(emp, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Employee empNew = null;
		try {
			empNew = (Employee) SerializationTest.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("emp Object::" + emp);
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

			// serialize the given object and save it to file
			public static void serialize(Object obj, String fileName)
					throws IOException {
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(obj);

				fos.close();
			}
}