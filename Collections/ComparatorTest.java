package com.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//comparator provides  multiple sorting sequence
public class ComparatorTest {
	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 23));
		al.add(new Student(106, "Ajay", 27));
		al.add(new Student(105, "Jai", 21));
		al.add(new Student(119, "Ram", 22));

		System.out.println("Sorting by Name...");

		Collections.sort(al, new NameComparator());
		for (Student st : al) {
			System.out.println(st.roll + " " + st.name + " " + st.age);
		}

		System.out.println("sorting by age...");

		Collections.sort(al, new AgeComparator());
		for (Student st : al) {
			System.out.println(st.roll + " " + st.name + " " + st.age);
		}
		
		//Classic way of writing Comparator	
		Comparator<Student> classicComparator=new Comparator<Student>(){
			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
			
		};
		
		System.out.println("=================================");
		System.out.println("Using lambda expression of Java 8 in Comparator");
		
		//Java 8 way of writing comparator
		Comparator<Student> newComp=(Student o1,Student o2)->  o1.name.compareTo(o2.name);
		//Valid statement below
//		Comparator<Student> newComp=(o1,o2)->  o1.name.compareTo(o2.name);
		//arrangement in decending order of age
		Comparator<Student> ageComp = (Student o1, Student o2) -> (o1.age < o2.age) ? 1 : (o1.age > o2.age) ? -1 : 0;
		System.out.println("Sorted using lambda expression");
		//In Java 8, the List interface is supports the sort method directly, no need to use Collections.sort anymore.
//		al.sort(newComp);
		//reverse sorting below
//		al.sort(newComp.reversed());
		al.sort(ageComp);
		//java 8 only, lambda also, to print the List
		al.forEach((student)->System.out.println(student));
	}

}

class Student {
	int roll;
	String name;
	int age;

	public Student(int roll, String name, int age) {
		super();
		this.roll = roll;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", age=" + age + "]";
	}
	

}

class AgeComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if (s1.age == s2.age)
			return 0;
		else if (s1.age > s2.age)
			return 1;
		else
			return -11;
	}

}

class NameComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}

}

class NameAgeComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		if (s1.name == s2.name && s1.age == s2.age)
			return 0;
		return 1;
	}
}
