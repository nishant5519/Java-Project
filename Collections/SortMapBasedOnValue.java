package com.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapBasedOnValue {
	// Map ---> List<Map> ---> Collections.sort() --> List<Map> (Sorted) --->
	// LinkedHashMap
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("java", 20);
		map.put("C++", 45);
		map.put("Java2Novice", 2);
		map.put("Unix", 67);
		map.put("MAC", 26);
		map.put("Why this kolavari", 93);

		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> listOfSet = new ArrayList<>(set);
		Collections.sort(listOfSet, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		for (Entry<String, Integer> entry : listOfSet) {
			System.out.println("Key :" + entry.getKey() + ",Value :" + entry.getValue());
		}
	}

}
