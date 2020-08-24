package com.cloning;

import java.util.ArrayList;

//https://www.journaldev.com/60/java-clone-object-cloning-java
public class CloningWithSecondaryObjects {
	private final ArrayList<String> list = new ArrayList<String>();

	public CloningWithSecondaryObjects() {
		list.add("A");
		list.add("B");
		list.add("C");
	}

	public ArrayList<String> getClonedList() {
		return (ArrayList<String>) list.clone();

	}

	public ArrayList<String> getList() {
		return list;

	}

	public static void main(String[] args) {
		CloningWithSecondaryObjects testCloningObj = new CloningWithSecondaryObjects();
		System.out.println(testCloningObj.getList());
		System.out.println(testCloningObj.getClonedList());
		testCloningObj.getList().add("D");
		System.out.println(testCloningObj.getList());
		System.out.println(testCloningObj.getClonedList());
		
		System.out.println("=====================");
		System.out.println(testCloningObj.getList().size());
		System.out.println(testCloningObj.getList());
		System.out.println(testCloningObj.getClonedList().size());
		System.out.println(testCloningObj.getClonedList());
		System.out.println(testCloningObj.getClonedList()==testCloningObj.getList());
		System.out.println(testCloningObj.getClonedList()!=testCloningObj.getList());
		System.out.println(testCloningObj.getClonedList().equals(testCloningObj.getList()));
		System.out.println(testCloningObj.getClonedList().hashCode());
		System.out.println(testCloningObj.getList().hashCode());
		
	}

}
