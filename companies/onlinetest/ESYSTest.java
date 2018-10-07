package com.companies.onlinetest;

import java.util.TreeSet;

public class ESYSTest {
	static String s = "";

	public static void main(String[] args) {
		TreeSet<Integer> t = new TreeSet<Integer>();
		t.add(1);
		t.add(2);
		t.add(1);
		Integer i1 = 127;
		Integer i2 = 127;
		System.out.println(i1 == i2);
		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(i3==i4);

		System.out.println(t.size());
		System.out.println("1");

		try {
			s = s + "1";
			throw new Exception();
		} catch (Exception e) {
			s = s + "2";
		} finally {
			s = s + "3";
			doStuff();
			s = s + "4";
		}
		synchronized (args) {
			System.out.println("2");
			try {
				args.wait();
			} catch (InterruptedException e) {

			}
		}
		System.out.println("3");
	}

	static void doStuff() {
		int x = 0;
		int y = 7 / x;
	}

}
