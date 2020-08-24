package com.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionDemo {
	public static void main(String[] args) {

		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
		
		myMap.put("1", "1");
	    Iterator<Entry<String, String>> i = myMap.entrySet().iterator();
	    myMap.remove(1);        // remove entry from map      
	    System.out.println(i.next()); //still shows entry 1=1
	    
	    
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "7");
		myMap.put("4", "4");
		myMap.put("5", "5");
		myMap.put("6", "6");
		myMap.put("7", "7");
		myMap.put("8", "8");
		myMap.put("9", "9");
		myMap.put("10", "10");
		myMap.put("11", "11");
		myMap.put("12", "12");
		myMap.put("13", "13");
		myMap.put("14", "14");
		myMap.put("15", "15");
		myMap.put("16", "16");
		myMap.put("17", "17");
		myMap.put("18", "18");
		myMap.put("19", "19");
		myMap.put("20", "20");
		//null insertion is not possible in ConcurrentHashMap as key or value.
		// myMap.put(null, null);
		System.out.println(myMap.put("3", "NewValue"));
		System.out.println("ConcurrentHashMap before modification: " + myMap);
		Iterator<String> it = myMap.keySet().iterator(); // Fail safe iterator.
		while (it.hasNext()) {
			String key = it.next();
			if (key.equals("3")) {
				myMap.put(key + "newKEY", "new in ConcurrentHM");// Adding NEW
																	// value in
																	// concurrenthashmap
				myMap.put("3", "Modifying existing Value for key 3");//Modifying existing value of Key
			}
		}
		System.out.println("ConcurrentHashMap after modification: " + myMap);

		// HashMap
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "1");
		hm.put(2, "2");
		hm.put(3, "3");
		hm.put(4, "4");
		hm.put(5, "5");
		hm.put(6, "6");
		System.out.println("HashMap before modification: " + hm);
		Iterator<Integer> it1 = hm.keySet().iterator();// Fail fast iterator

		while (it1.hasNext()) {
			Integer key = it1.next();
			if (key.equals(3))
				hm.put(key + 8, "New in HM");// throws exception
												// java.util.ConcurrentModificationException
			// break; If break statement is enabled, then Iterator will not
			// throw any exception since iteration is not completed.
			// hm.put(key, "New in HM"); //Trying to change existing key value
			// pair also will not throw any exception in normal HashMap.
		}
		System.out.println("HashMap after modification: " + hm);

	}

}
