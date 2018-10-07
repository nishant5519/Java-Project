package com.datastructure.LinkedList;

public class LinkListApp {

	public static void main(String[] args) {
		LinkList theList = new LinkList();
		theList.insertFirst(22, 2.99);
		/*theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);*/

		theList.displayList();
		Link f = theList.find(44);
		if (f != null)
			System.out.println("Found link with Key:" + f.iData);
		else
			System.out.println("Cannot find the link");

		Link d = theList.delete(22);
		Link d1 = theList.delete(100);
		if (d != null)
			System.out.println("Deleted Link with Key " + d.iData);
		else
			System.out.println("Cannot delete the link");
		while (!theList.isEmpty()) {
			Link aLink = theList.deleteFirst();
			System.out.println("Deleted ");
			aLink.displayLink();
			System.out.println(" ");
		}
		theList.displayList();
	}

}

class Link {
	public int iData;
	public double dData;
	public Link next; // Self-referential

	public Link(int id, double dd) {
		this.iData = id;
		this.dData = dd;
		// next is automatically set to null
	}

	public void displayLink() {
		System.out.println("{" + iData + "," + dData + "}");
	}

}

class LinkList {
	private Link first; // reference to first link on the list

	public LinkList() {
		this.first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;

	}

	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.println("List (first--->last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}

	public Link find(int key) {
		Link current = first;
		while (current.iData != key) {
			if (current.next == null)
				return null;
			else
				current = current.next;
		}
		return current;
	}

	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while (current.iData != key) {
			if (current.next == null) //did not find it
				return null; 
			else {
				previous = current;  //go to next link
				current = current.next;
			}
		}// While loop ends
		if (current == first)
			first = first.next;
		else
			previous.next = current.next;
		return current;
	}
}
