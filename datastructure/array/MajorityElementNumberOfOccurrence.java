package com.datastructure.array;

import java.util.HashMap;

//Find number of occurrence of each element in an Array.Time complexity O(n),Auxiliary Space: O(n)
public class MajorityElementNumberOfOccurrence {

	public static void main(String[] args) {

		int[] a = { 21, 34, 05, 21, 21, 76, 45, 65, 65, 76, 76, 76, 76, 76, 76,
				76 };
		int x = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 1; i < a.length; i++) {
			if (hm.containsKey(a[i])) {
				x = (hm.get(a[i])) + 1;
				if (x > a.length / 2) {
					System.out.println("Majority Found: " + a[i]);
					return;
				} else
					hm.put(a[i], x);
			} else
				hm.put(a[i], 1);

		}

		System.out.println(hm);
	}

}
