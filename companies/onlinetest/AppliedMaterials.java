package com.companies.onlinetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppliedMaterials {

	public static void main(String[] args) {
		widenadnbox((long)10);
		List<String> list = new ArrayList<>();
		list.add("value");
		Iterator<String> itr = list.iterator();
		list.remove(0);
		
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	
	private static void widenadnbox(Long vlaue){
		System.out.println("abc");
	}

}

class Someclass{
	
	/*public<T extends Number> void method(T arg){
		
	}
	
	public void method(Number arg){}*/
}
