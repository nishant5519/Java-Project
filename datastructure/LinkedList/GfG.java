package LinkedList;

///* Node is defined as*/
class NodeClass {
	int data;
	NodeClass next;

	NodeClass(int d) {
		data = d;
		next = null;
	}

	public void displayLink() {
		System.out.println("Data " + data);
	}
}

class LinkedListClass {
	NodeClass head;

	public LinkedListClass() {
		head = null;
	}

	public void insertFirst(int id) {
		NodeClass newNodeClass = new NodeClass(id);
		newNodeClass.next = head;
		head = newNodeClass;
	}

	public void insertLast(int id) {
		NodeClass newNodeClass = new NodeClass(id);
		NodeClass current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNodeClass;

	}

	public NodeClass find(int key) {
		NodeClass current = head;
		while (current.data != key) {
			current = current.next;
		}

		return current;
	}

	public void printList() {
		System.out.println("LinkedListClass (First---->Last)");
		NodeClass current = head;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}
}

public class GfG {
	// Print elements of a linked list on console
	// head pointer input could be NULL as well
	// for empty list
	void printList(NodeClass head) {
		// add code here.
	}

	public static void main(String[] args) {
		LinkedListClass theList = new LinkedListClass(); // make new list
		theList.insertFirst(22); // insert four items
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertFirst(88);
		theList.insertLast(100);
		theList.printList();
		NodeClass present = theList.find(66);
		System.out.println(present.data);

	}
}
