package com.Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {

		Set<A> set = new HashSet<A>();
		for (int i = 0; i < 100; i++) {
			set.add(new A());
		}
		System.out.println("Size: " + set.size());
		System.out.println(set.contains(new A()));
		System.out.println(new A().equals(new A()));
		Set b=new TreeSet();
		b.add(null);
		b.add(null);
		System.out.println(b);

	}

}

class A {

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

}