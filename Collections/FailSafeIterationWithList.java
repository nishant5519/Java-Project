package com.Collections;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterationWithList {

	public static void main(String[] args) {
		List<Integer> list=new CopyOnWriteArrayList<>(); //This list is failsafe list
		list.add(1);
		list.add(4);
		list.add(6);
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext())
		{
			Integer a=itr.next();
			list.remove(a);  //no exception
		}
		System.out.println(list);
	}

}
