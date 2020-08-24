package com.Collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumberOfDuplicateElementsInList {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		int count = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (hm.containsKey(list.get(i))) {
				hm.put(list.get(i), hm.get(list.get(i)) + 1);
				if (hm.get(list.get(i)) <= 2)
					count++;
			} else
				hm.put(list.get(i), 1);
		}

		System.out.println(count);
	}

}
