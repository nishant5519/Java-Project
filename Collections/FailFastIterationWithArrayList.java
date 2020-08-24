package com.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastIterationWithArrayList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next()); 
//			list.remove(2); //java.util.ConcurrentModificationException
//			itr.remove();  //this does not give exception
		}
		System.out.println(list);

	}

}
