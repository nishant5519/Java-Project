package stack;

import java.util.Iterator;

public class LinkedListStack {
	public static void main(String a[]) {
		Stack<Integer> s = new LinkedStack<Integer>();
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		System.out.println("Size of the stack: " + s.size());

		// iterate through stack
		System.out.println("Stack contains following items till this moment:");

		for (Integer i : s)
			System.out.println(i);

	}

}

// In order to make end user independent from implementation details of the
// stack implementation whether it is implemented using linked list or array,
// we define an interface Stack as follows. The following Stack interface can be
// assigned any object that implements this interface no matter the underlying
// implementation uses linked list or array based implementation of stack in
// Java.If you look at the below definition of Stack interface,
// you will see that the interface is passed a parameter Item enclosed in
// angular brackets. This feature facilitates the generic use of Stack data
// structure.
// It allows programmers to pass the object type the stack will store at run
// time. A special feature of Java called Generics brings us this capability.

interface Stack<Item> extends Iterable<Item> {
	Item pop();

	void push(Item item);

	boolean isEmpty();

	int size();
}

// LinkedList implementation of Stack. Hidden from the user.The below
// implementation of LinkedStack class takes a type parameter Item which would
// be replaced
// with concrete type by the client code when the LinkedStack object will be
// created as follows, for an example:
// Stack <Integer> s = new LinkedStack <Integer>();

class LinkedStack<Item> implements Stack<Item> {

	private Node head; // the first node
	private int size; // number of items

	private class Node {
		Item item;
		Node next;
	}

	// Zero argument constructor
	public LinkedStack() {
		head = null;
		size = 0;
	}

	@Override
	// Remove item from the beginning of the list.
	public Item pop() {
		Item item = head.item;
		head = head.next;
		size--;
		return item;
	}

	@Override
	// Add item to the beginning of the list.
	public void push(Item item) {
		Node oldHead = head;
		head = new Node();
		head.item = item;
		head.next = oldHead;
		size++;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	// Iterator for traversing stack items
	public Iterator<Item> iterator() {
		return new LinkedStackIterator();
	}

	// inner class to implement iterator interface.if you like to make the Stack
	// a usual collection where you can iterate through the stack items, you
	// should implement Iterable and Iterator interfaces as part of your
	// LinkedStack implementation.
	/*
	 * Java provides a special syntax of for loop (also called for-each loop) to
	 * process arrays and iterable collections. Any iterable collection has to
	 * implement an iterator() method that returns an Iterator object. And the
	 * class implements Iterator has to implement two methods: hasNext()
	 * (returns true if there are more items to process, false otherwise) and
	 * next() (returns an item from the collection). To make our Stack data
	 * structure iterable, we first extends the Stack<Item> interface by
	 * Iterable<Item>. Interface Iterable is already defined as part of
	 * java.lang.Iterable. As soon as we extend Stack<Item> interface by
	 * Iterable<Item> we have to add a new method iterator() to class
	 * LinkedStack that will return an object of type Iterator<Item> Generally,
	 * an iterator is an object of a class that implements hasNext(), and next()
	 * as they are declared in Iterator interface. The Iterator interface also
	 * declares a remove() method but we will not specify anything in its body.
	 * The interface Iterator<Item> we will implement by an inner class
	 * LinkedStackIterator to LinkedStack. To complete the code first modify the
	 * existing signature of interface Stack in Stack.java as follows, no change
	 * required in interface's body.
	 */
	private class LinkedStackIterator implements Iterator<Item> {
		private int i = size;
		private Node first = head; // the first node

		public boolean hasNext() {
			return (i > 0);
		}

		public Item next() {
			Item item = first.item;
			first = first.next;
			i--;
			return item;
		}

		public void remove() {
			// not needed
		}
	}

}
