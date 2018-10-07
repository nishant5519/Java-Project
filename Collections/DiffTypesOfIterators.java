package com.Collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class DiffTypesOfIterators {

	public static void main(String[] args) {
		// Create a vector and print its conents
		Vector v = new Vector();		
		for (int i = 0; i < 10; i++)
			v.addElement(i);
		System.out.println(v);

		// At beginning e(cursor) will point to
		// index just before the first element in v
		Enumeration e = v.elements();

		// Checking the next element availability
		while (e.hasMoreElements()) {
			// moving cursor to next element
			int i = (Integer) e.nextElement();
			System.out.print(i + " ");
		}
		ArrayList al = new ArrayList();
		 
		
        for (int i = 0; i < 10; i++)
            al.add(i);
        System.out.println(al);
        Iterator it=al.iterator();
        System.out.println(it.getClass().getName());
        ListIterator lit=al.listIterator();
        System.out.println(lit.getClass().getName());
        
       
        
        while(it.hasNext()){
        	int i=(Integer)it.next();
        	System.out.print(i + " ");
        	 
            // Removing odd elements
            if (i % 2 == 0)
            	i++;
               it.remove(); 
        }
        System.out.println(); 
        System.out.println(al);
	}

}
