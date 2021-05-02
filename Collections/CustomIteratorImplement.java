package Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomIteratorImplement {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(6);
		list.add(11);
		for (Integer i : list) {
			System.out.println(i);

		}

		Bag<Integer> bag = new Bag<Integer>();
		bag.add(4);
		bag.add(8);
		bag.add(16);
		System.out.println(bag);

		Iterator<Integer> itr = bag.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		itr.next();
		for (Integer a : bag)
			System.out.println(a);
		itr.remove();
		System.out.println(bag);
	}

}

class Bag<T> implements Iterable<T> {
	private ArrayList<T> data;

	public Bag() {
		data = new ArrayList<T>();
	}

	public void add(T e) {
		data.add(e);
	}

	public String toString() {
		return data.toString();
	}

	@Override
	public Iterator<T> iterator() {
	//	return data.iterator(); returns ArraYlist iterator
		return new BagIterator<T>();
	}

	public class BagIterator<T> implements Iterator<T> {

		private int index;

		public BagIterator() {
			index = 0;
		}

		@Override
		public boolean hasNext() {

			return index < data.size();
		}

		@Override
		public T next() {
			return (T) data.get(index++);
		}

		@Override
		public void remove() {
			data.remove(index);

		}

	}

}
