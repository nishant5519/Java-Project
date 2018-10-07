package com.Collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);		
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		/*list.add(2);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(3,4);*/
		list.remove(5);
		list.remove(new Integer(5));
		System.out.println(list);
	}

}
