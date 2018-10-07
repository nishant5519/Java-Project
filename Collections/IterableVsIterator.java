package com.Collections;

import java.util.Iterator;

public class IterableVsIterator {
	public static void main(String[] args) {
		String[] technologies = { "Java", "JEE", "XML" };
		MyIterable<String> entries = new MyIterable<String>(technologies);
		for (String tech : entries) {
			System.out.println(tech);
		}
	}
}

class MyIterable<T> implements Iterable<T> {

	public T[] a = null;

	public MyIterable(T[] array) {
		this.a = array;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int count = 0;

			public boolean hasNext() {
				return count < a.length;
			}

			public T next() {
				System.out.println("Invoking next()");
				return a[count++];
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
