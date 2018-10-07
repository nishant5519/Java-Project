package com.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// one question start
		HashMapTest t = null;
		t.print("Hello World!!");
		// one question ends

		// next question start
		NewKeyClass nkc1 = new NewKeyClass("honeywell");
		NewKeyClass nkc2 = new NewKeyClass("phoenix");
		NewKeyClass nkc3 = new NewKeyClass("niagara");
		NewKeyClass nkc4 = new NewKeyClass("novar");
		NewKeyClass nkc5 = new NewKeyClass("alerton");
		Map<NewKeyClass,Object> newMap = new HashMap<NewKeyClass,Object>();
		Object valueObj = new Object();
		newMap.put(nkc1, valueObj);
		newMap.put(nkc2, valueObj);
		newMap.put(nkc3, valueObj);
		newMap.put(nkc4, valueObj);
		newMap.put(nkc5, valueObj);
		Iterator<NewKeyClass> itr = newMap.keySet().iterator();
		while (itr.hasNext())
			System.out.println(((NewKeyClass) itr.next()).toString());
		// next question ends

		// next question starts
		HashMapTest hwt = new HashMapTest();
//		hwt.getvalue();
		// next question ends
		
		
		Map<Integer,String> hm=new HashMap<>(16,2);
		hm.put(0, "a");
		hm.put(1, "A");
		hm.put(2, "B");
		hm.put(3, "C");
		hm.put(4, "D");
		hm.put(5, "F");
		hm.put(6, "G");
		hm.put(7, "H");
		hm.put(8, "I");
		hm.put(9, "J");
		hm.put(10, "K");
		hm.put(11, "L");
		hm.put(12, "M");
		hm.put(13, "N");
		hm.put(14, "O");
		hm.put(15, "P");
		hm.put(16, "Q");
		hm.put(17, "R");
		System.out.println(hm);

	}

	public static void print(String data) {
		System.out.println("Entered Data: " + data);
	}

	int getvalue() {
		return (true ? null : 0);
	}

}

class Test1 {
	public int value;

	public int hashCode() {
		return 42;
	}
}

class Test2 {
	public int value;

	public int hashCode() {
		return (int) value * 45;
	}

}

class NewKeyClass {
	private String keyName;

	public NewKeyClass(String keyName) {
		this.keyName = keyName;
	}

	public int hashCode() {
		if (keyName.indexOf("a") > -1)
			return 5;
		else
			return keyName.length();
	}

	public boolean equals(Object obj) {
		if (keyName.indexOf("a") > -1)
			return true;
		return false;
	}

	public String toString() {
		return keyName;
	}

}