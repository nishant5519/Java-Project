package com.companies.onlinetest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.serialization.Employee;

public class WhatPix {

	public static void main(String[] args) {

		int x;
		x = -1;
		{
			int y = 4;
			System.out.println(x + " " + y);
		}
		// System.out.println(x + " " + y); Y is not visible for this line

		/*****************/
		WhatPix xy = new WhatPix();
		xy.abc();

		/*****************/
		Employee emp1 = new Employee(), emp2 = new Employee();
		emp1.x++;
		emp2.y++;
		// emp1.z++; This is not visible

		/*****************/
		xy.start();
		
		/*****************/
		Set<String> h=new HashSet<>();
		h.add("One");
		h.add("Two");
		h.add("Three");
		h.add("Four");
		h.add("One");
		h.add("Four");
		List<String> l=new ArrayList<>();
		l.add("One");
		l.add("Two");
		l.add("Three");
	//	l.add("Four");
	//	l.add("Five");
		h.retainAll(l);
	//	System.out.println("Set:" + h);
	//	System.out.println("List:" + l);
		System.out.println("Size" + l.size()+ h.size());
	}

	void abc() {
		long[] a1 = { 3, 4, 5 };
		long[] a2 = fix(a1);
		System.out.print("Barclays: " + a1[0] + a1[1] + a1[2] + "");
		System.out.println(a2[0] + a2[1] + a2[2]);
	}

	long[] fix(long[] a3) {
		a3[1] = 7;
		return a3;
	}

	void start() {
		boolean b1 = false;
		boolean b2 = fix(b1);
		System.out.println(b1 + " " + b2);
	}

	boolean fix(boolean b1) {
		b1 = true;
		return b1;
	}
}
