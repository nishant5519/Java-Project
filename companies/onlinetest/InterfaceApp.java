package companies.onlinetest;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class InterfaceApp implements X, Y {
	public static void main(String[] args) {
		InterfaceApp i = new InterfaceApp();
		i.print();

		// next question
		Map<String, String> hashmap = new ConcurrentHashMap<String, String>();
		hashmap.put("1", "One");
		hashmap.put("2", "Two");
		for (Entry<String, String> entry : hashmap.entrySet()) {
			hashmap.put("3", "Three");
			System.out.println(entry.getValue() + " ");

		}

	}

	@Override
	public void print() {
		System.out.println("Called..");
	}

}

interface X {
	public void print();
}

interface Y {
	public void print();
}