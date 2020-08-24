package com.immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableArrayList {

	public static void main(String[] args) {
		final List<String> modifiable = new ArrayList<>();
		modifiable.add("Java");
		modifiable.add("is");
		

		List<String> unmodifiable = Collections.unmodifiableList(modifiable);
		System.out.println("Before modification: " + unmodifiable);
		modifiable.add("the");
		modifiable.add("best");

		//Any changes in modifiable is reflected in unmodifiable list.
		System.out.println("After modification: " + unmodifiable);
		
		unmodifiable.add("Not possible");//Throws java.lang.UnsupportedOperationException
		System.out.println("Modifying unmodifiable list : " + unmodifiable);
	}

}
