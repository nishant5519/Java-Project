package com.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableTest {
	public static void main(String[] args) {

		ArrayList<String> alStr = new ArrayList<String>();
		alStr.add("cdefdsfbbdfk");
		alStr.add("efgsdf");
		alStr.add("abc");
		System.out
				.println("Original ordering of Strings inside List: " + alStr);
		Collections.sort(alStr);

		System.out.println("New order(after natural ordering by default comparable) of Strings stored in List: " + alStr);

		// sorting Strings using comparator

		Collections.sort(alStr, new StringLengthComparator());

		System.out.println("New order of Strings stored in List using comparator based on length of string: " + alStr);

		// sorting integers

		ArrayList<Integer> alIntgr = new ArrayList<Integer>();
		alIntgr.add(100);
		alIntgr.add(50);
		alIntgr.add(200);
		System.out.println("Original ordering of Integers inside List: "
				+ alIntgr);
		Collections.sort(alIntgr);

		
		System.out.println("New order of Integers stored in List: " + alIntgr);

		// sorting custom objects inside List.
		ArrayList<CoachingStudent> al = new ArrayList<CoachingStudent>();
		al.add(new CoachingStudent(101, "Vijay", 23));
		al.add(new CoachingStudent(106, "Ajay", 27));
		al.add(new CoachingStudent(105, "Jai", 21));
		
		Collections.sort(al);
		for (CoachingStudent st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
	}

}

class CoachingStudent implements Comparable<CoachingStudent> {
	int rollno;
	String name;
	int age;

	CoachingStudent(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

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

	public int compareTo(CoachingStudent st) {
/*
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
*/
		// return this.name.compareTo(st.name);
		 return this.name.compareTo(st.getName());
	}

}

// From cave of programming example
class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int l1 = o1.length();
		int l2 = o2.length();
		return l1 > l2 ? 1 : -1;
	}

}
