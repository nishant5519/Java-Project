package com.Collections;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {

		// List<String> list = new ArrayList<>(); For ArrayList below code
		// throws exception
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		// get the iterator
		ListIterator<String> it = list.listIterator();//snapshot iterator will only print elements that are available in the list at the time of iterator creation

		
		while (it.hasNext()) {
			System.out.println("list is:" + list);
			String str = it.next();			
			System.out.println(str);
			if (str.equals("2"))
				list.remove("5");
	//		it.add("6");//this add will not work as this add() is of iterator
			if (str.equals("3"))
				list.add("3 found");
			// below code don't throw ConcurrentModificationException because it
			// doesn't change modCount variable of list
			if (str.equals("4"))
				list.set(1, "4");
		}
		
		Set<String> set = new CopyOnWriteArraySet<>();
		set.add("A");
		set.add(null);
		set.add(null);

/*		// This thread will iterate the list
		Thread thread1 = new Thread() {
			public void run() {
				try {
					Iterator<String> i = list.iterator();
					while (i.hasNext()) {
						System.out.println(i.next());
						// Using sleep to simulate concurrency
						Thread.sleep(1000);
					}
				} catch (ConcurrentModificationException e) {
					System.out.println("thread1 : Concurrent modification detected on this list");
					e.printStackTrace();
				} catch (InterruptedException e) {

				}
			}
		};
		thread1.start();

		// This thread will try to add to the collection,
		// while the collection is iterated by another thread.
		Thread thread2 = new Thread() {
			public void run() {
				try {
					// Using sleep to simulate concurrency
					Thread.sleep(2000);
					// adding new value to the shared list
					list.add("5");
					System.out.println("new value added to the list"); 
	                System.out.println("List " + list);
				} catch (ConcurrentModificationException e) {
					System.out.println("thread2 : Concurrent modification detected on the List");
				} catch (InterruptedException e) {
				}
			}
		};
		thread2.start();*/

	}

}
