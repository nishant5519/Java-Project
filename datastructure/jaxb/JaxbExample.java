package com.jaxb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbExample {
	
	private static String fileName = "C:\\Backup NISHANT\\Neon Workspace\\Java_Project\\src\\com\\jaxb\\student.xml";

	public static void main(String[] args) throws JAXBException, IOException {

		jaxbXmlFileToObject();
		jaxbJavaToXML();
	}

	private static void jaxbXmlFileToObject() throws JAXBException {

		 //getting the xml file to read
	    File file = new File(fileName);
	    //creating the JAXB context
	    JAXBContext jContext = JAXBContext.newInstance(Student.class);
	    //creating the unmarshall object
	    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
	    //calling the unmarshall method
	    Student student=(Student) unmarshallerObj.unmarshal(file);
	    System.out.println(student.getName()+ " " +student.getId()+ " " +student.getSubject());
	}

	private static void jaxbJavaToXML() throws JAXBException, IOException {

		// creating the JAXB context
		JAXBContext jContext = JAXBContext.newInstance(Student.class);
		// creating the marshaller object
		Marshaller marshallObj = jContext.createMarshaller();
		// setting the property to show xml format output
		marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// setting the values in POJO class
		Student student = new Student("abhishek", 1163, "hadoop");
		// calling the marshall method
		FileOutputStream os = new FileOutputStream(fileName);
		marshallObj.marshal(student, os);
		os.close();
	}
}