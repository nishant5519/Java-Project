package com.miscellaneous;

import java.lang.ref.SoftReference;

public class TypeOfReference {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); //Strong Reference:not eligible for gc
		sb=null; //eligible for gc
		
		
		/*In the below snippet, we have created two references to the StringBuilder object.
		The first line creates a strong reference sb1 and the second line creates a soft 
		reference sbRef. The third line should make the object eligible for collection 
		but the garbage collector will postpone collecting it because of sbRef.
		The story will only change when memory becomes tight and the JVM is on the brink 
		of throwing an OutOfMemory error. In other words, objects with only soft 
		references are collected as a last resort to recover memory.*/
		StringBuilder sb1 = new StringBuilder();
		SoftReference<StringBuilder> sbRef = new SoftReference<>(sb1);
		sb1 = null;
		
/*A WEAK reference can be created in a similar manner using WeakReference class. When sb 
is set to null and the StringBuilder object only has a weak reference, the JVM’s garbage 
collector will have absolutely no compromise and immediately collect the object at the 
very next cycle.

A PHANTOM reference is similar to a weak reference and an object with only phantom 
references will be collected without waiting. However, phantom references are enqueued 
as soon as their objects are collected. We can poll the reference queue to know exactly 
when the object was collected.*/
	}

}
