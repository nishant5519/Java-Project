package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestserialVersionUID {

	public static void main(String[] args) {

		/*WriteObject wo = new WriteObject();
		wo.writeObjectstream();*/
		ReadObject ro = new ReadObject();
		// Same serialVersionUID , there is no problem during the
		// deserialization process
		ro.readObjectstream();

		/*
		 * Different serialVersionUID In Address.java, change the
		 * serialVersionUID to 2L (it was 580408474919911762L), and compile it
		 * again. java.io.InvalidClassException: Address; local class
		 * incompatible: stream classdesc serialVersionUID = 1, local class
		 * serialVersionUID = 2 ... at ReadObject.main(ReadObject.java:14)
		 */

	}

}

class Address implements Serializable {

	public static final long serialVersionUID = 58040847491991174L;
	String street;
	String country;

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return this.street;
	}

	public String getCountry() {
		return this.country;
	}

	@Override
	public String toString() {
		return new StringBuffer(" Street : ").append(this.street)
				.append(" Country : ").append(this.country).toString();
	}
}

class WriteObject {

	public void writeObjectstream() {
		Address address = new Address();
		address.setStreet("wall street");
		address.setCountry("united states");

		try {

			FileOutputStream fout = new FileOutputStream(
					"C:\\Backup NISHANT\\abc.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(address);
			oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class ReadObject {

	public void readObjectstream() {

		Address address;

		try {

			FileInputStream fin = new FileInputStream(
					"C:\\Backup NISHANT\\abc.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			address = (Address) ois.readObject();
			ois.close();

			System.out.println(address);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}