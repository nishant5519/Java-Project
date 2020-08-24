package com.Collections;

import java.util.ArrayList;
import java.util.List;

public class IterateListOfList {

	public static void main(String[] args) {

		List<Children> childList1 = new ArrayList<>();
		Children child1 = new Children();
		child1.setName("David");
		child1.setAge(21);

		Children child2 = new Children();
		child2.setName("Ryan");
		child2.setAge(22);

		childList1.add(child1);
		childList1.add(child2);

		List<Children> childList2 = new ArrayList<>();
		Children child3 = new Children();
		child3.setName("Mike");
		child3.setAge(27);

		Children child4 = new Children();
		child4.setName("Grey");
		child4.setAge(17);

		childList2.add(child3);
		childList2.add(child4);

		Father father1 = new Father();
		father1.setName("Michael");
		father1.setAge(57);
		father1.setChildrens(childList1);

		Father father2 = new Father();
		father2.setName("Shaun");
		father2.setAge(64);
		father2.setChildrens(childList2);

		List<Father> fatherList = new ArrayList<>();

		fatherList.add(father1);
		fatherList.add(father2);

		for (Father father : fatherList) {
			List<Children> list = father.getChildrens();
			for (Children children : list) {
				System.out.println(
						"Father's name is :" + father.getName() + " and " + "Child's name is :" + children.getName());
			}
		}
		long count = 0;
		for (Father father : fatherList) {
			List<Children> list = father.getChildrens();
			count = count + list.stream().filter(x -> x.getName().equals("Ryan")).count();
		}
		System.out.println(count);

	}

}

class Father {

	private String name;
	private int age;
	private List<Children> Childrens;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Children> getChildrens() {
		return Childrens;
	}

	public void setChildrens(List<Children> childrens) {
		Childrens = childrens;
	}

}

class Children {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}