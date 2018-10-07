package com.practice;

public class HashcodeExample {

	public static void main(String[] args) {
		Integer i = 256;
		System.out.println(hash(i));
		System.out.println((16 - 1) & hash(i));
	}

	static final int hash(Object k) {
		int h;
		return (k == null) ? 0 : (h = k.hashCode()) ^ (h >> 16);
	}

}
