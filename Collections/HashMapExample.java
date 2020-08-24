package com.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.serialization.Employee;

public class HashMapExample {
	public static void main(String[] args) {
		System.out.println(Employee.count);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		System.out.println(hm.put(null, -1));
		System.out.println(hm.put(null, 0)); // second null will replace first
												// null key value
		System.out.println(hm.put(1, 1));
		System.out.println(hm.put(2, 2));
		System.out.println(hm.put(3, 3));
		System.out.println(hm.put(4, 4));
		System.out.println(hm.put(5, 5));
		System.out.println(hm.put(6, 6));
		System.out.println(hm.put(7, 7));
		System.out.println(hm.put(8, 8));
		System.out.println(hm.put(9, 9));
		System.out.println(hm.put(10, 10));
		System.out.println(hm.put(11, 11));
		System.out.println(hm.put(12, 12));
		System.out.println(hm.put(13, 13));
		System.out.println(hm.put(14, 14));
		System.out.println(hm.put(15, 15));
		System.out.println(hm.put(16, 16));
		System.out.println(hm.put(17, 17));
		System.out.println(hm.put(18, 18));
		System.out.println(hm.put(19, 19));
		Set<Integer> set = hm.keySet();
		set.clear();
		System.out.println(hm);

		System.out.println("===============================================");

		TestMapAsKey obj1 = new TestMapAsKey("Subrata");
		TestMapAsKey obj2 = new TestMapAsKey("Subrata");
		Map<TestMapAsKey, String> map = new HashMap<TestMapAsKey, String>();
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		map.put(obj1, "ABC");
		map.put(obj2, "XYZ");
		obj1.setName("Sapient");
		obj2.setName("Modified");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(map.get(obj1));// ??
		System.out.println(map.get(obj2));// ??
	}

}

class TestMapAsKey {
	String name;

	public TestMapAsKey(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestMapAsKey other = (TestMapAsKey) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}