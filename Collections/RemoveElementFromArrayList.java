package com.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RemoveElementFromArrayList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(2);
		list.add(9);
		list.remove(2); // removes element at index 2
		list.remove(new Integer(2)); // removes element whose value is 2
		System.out.println(list);

		System.out.println("*****************Remove elements from ArrayList using remove******************");

		List<ArrayTest> al = new ArrayList<>();
		ArrayTest a1 = new ArrayTest(1);
		ArrayTest a2 = new ArrayTest(2);
		ArrayTest a3 = new ArrayTest(3);
		ArrayTest a4 = new ArrayTest(4);
		ArrayTest a5 = new ArrayTest(5);
		ArrayTest a6 = new ArrayTest(6);
		ArrayTest a7 = new ArrayTest(7);
		al.add(a1);
		al.add(a2);
		al.add(a3);
		al.add(a4);
		al.add(a5);
		al.add(a6);
		al.add(a7);
		
//	    al.remove(1);//removes by index
//		al.remove(new ArrayTest(2)); // this will not work unless you override
										// equals method
		System.out.println(al);

		System.out.println("*****************Remove elements from ArrayList using Iterator******************");
		
		Iterator<ArrayTest> itr=al.iterator();
		
	/*	this will nt work
	 * while(itr.hasNext()){
			ArrayTest at=itr.next();
			if(at.equals(new ArrayTest(5)))
				al.remove(at);
				
	this will also nt work
		for (ArrayTest arrayTest : al) {
			if(arrayTest.equals(new ArrayTest(3)))
				al.remove(new ArrayTest(3));
		}*/
		
		while(itr.hasNext()){
			ArrayTest at=itr.next();
			if(at.equals(new ArrayTest(5)))
				itr.remove();
		}
		System.out.println(al);
		
		
	/*	Collection<Integer> l = new ArrayList<>();

	    for (int i = 0; i < 10; ++i) {
	        l.add(4);
	        l.add(5);
	        l.add(6);
	    }

	    for (int i : l) {
	        if (i == 5) {
	            l.remove(i);
	        }
	    }

	    System.out.println(l);
*/
	}

}

class ArrayTest {
	int i;

	public ArrayTest(int j) {
		this.i = j;
	}

	@Override
	public String toString() {
		return "ArrayTest [i=" + i + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayTest other = (ArrayTest) obj;
		if (i != other.i)
			return false;
		return true;
	}

}
