package com.Collections;

import java.util.ArrayList;
import java.util.Iterator;
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
		
		/*
		for(Integer num:list){
			list.add(10); //throws java.util.ConcurrentModificationException because for each uses iterator internally.
		}
		
		for(int i=0;i<5;i++)
			list.add(11);//does not throw exception.
*/		
		
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
			list.add(12);
		}
			
		System.out.println(list);
	}

}
