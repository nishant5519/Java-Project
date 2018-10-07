package com.oracle;

import java.util.Iterator;

public class IteratorFlattener<E> implements Iterator<E> {
	
	public static void main(String[] args) {

	}
	
	public IteratorFlattener(Iterator<Iterator<E>> root) {
	      // this.root=root;
	    }

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
