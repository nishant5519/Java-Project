package com.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class studentinfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int rid;
	static String contact;
	transient int trans;
	String password;

	studentinfo(String n, int r, String c,int trans) {
		this.name = n;
		this.rid = r;
		this.contact = c;
		this.trans=trans;
	}
}

public class TeststudentinfoSerialization {
	public static void main(String[] args) {
		try {
			studentinfo si = new studentinfo("Abhi", 104, "110044",555);
			FileOutputStream fos = new FileOutputStream("student.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(si);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}