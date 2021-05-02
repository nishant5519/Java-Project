package serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternExample {
	public static void main(String[] args) {
		UserSettings settings = new UserSettings();
		settings.setDoNotStoreMe("Sensitive info");
		settings.setFieldOne(10000);
		settings.setFieldTwo("HowToDoInJava.com");
		settings.setFieldThree(false);

		// Before
		System.out.println(settings);
		storeUserSettings(settings);
		UserSettings loadedSettings = loadSettings();
		System.out.println(loadedSettings);
	}

	private static UserSettings loadSettings() {
		try {
			FileInputStream fis = new FileInputStream("object.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			UserSettings settings = (UserSettings) ois.readObject();
			ois.close();
			return settings;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void storeUserSettings(UserSettings settings) {
		try {
			FileOutputStream fos = new FileOutputStream("object.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(settings);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class UserSettings implements Externalizable {

	// This is required
	public UserSettings() {

	}

	private String doNotStoreMe;
	private Integer fieldOne;
	private String fieldTwo;
	private boolean fieldThree;

	public String getDoNotStoreMe() {
		return doNotStoreMe;
	}

	public void setDoNotStoreMe(String doNotStoreMe) {
		this.doNotStoreMe = doNotStoreMe;
	}

	public Integer getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(Integer fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	public boolean isFieldThree() {
		return fieldThree;
	}

	public void setFieldThree(boolean fieldThree) {
		this.fieldThree = fieldThree;
	}

	// writeExternal() method is used to provide the logic for serialization
	// i.e. writing
	// the fields of class into bytes. You are free to store only those fields
	// which you want back after reading the serialized object back. Ignore rest
	// of the field.
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(fieldOne);
		out.writeUTF(fieldTwo);
		out.writeBoolean(fieldThree);
	}

	// The readExternal() method must read the values in the same sequence and
	// with the same types as were written by writeExternal().
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		fieldOne = in.readInt();
		fieldTwo = in.readUTF();
		fieldThree = in.readBoolean();
	}

	@Override
	public String toString() {
		return "UserSettings [doNotStoreMe=" + doNotStoreMe + ", fieldOne="
				+ fieldOne + ", fieldTwo=" + fieldTwo + ", fieldThree="
				+ fieldThree + "]";
	}
}