package com.companies.onlinetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IHSMarkit {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("A");
		list.add(3);
		list.add("hhfhf58599%#%#%");
		list.add(5, "k"); //Exception
		System.out.println(list);

		System.out.println("===============");

		Map<String, Integer> hm = new HashMap<String, Integer>();
		Integer i = 20;
		hm.put("i", i);
		i++;
		System.out.println(i);
		System.out.println(hm.get(i));
		System.out.println("===============");

		hm.put("A", 1);
		hm.put("B", 2);
		hm.put("3", 3);

		Iterator<Map.Entry<String, Integer>> itr = hm.entrySet().iterator();
		while (itr.hasNext()) {
			System.out.println(hm.get(itr.next()));
		//	hm.put("D", 4);
		}

		System.out.println("===============");
		
		Company c=new Ford();
		c.makeProfit();
		new Ford().makeProfit();
		
		
		System.out.println("===============");		
		for(;;){
			new Company();
		}
	}

}

class Company {
	private String s = "Birlasoft";

	public void makeProfit() {
		System.out.println("Name of company making profit is: " + s);
	}
}
class Ford extends Company {
		protected String s = "Ford";

		/*public void makeProfit() {
			System.out.println("Name of company making profit is: " + s);
		}*/
	}
