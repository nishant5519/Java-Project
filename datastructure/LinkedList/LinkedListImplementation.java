package LinkedList;

public class LinkedListImplementation {

	public static void main(String[] args) {
		LinkedList linkedlist = new LinkedList();
		linkedlist.insertFirst(40);
		linkedlist.insertFirst(10);
		/*
		 * linkedlist.insertFirst(3); linkedlist.insertFirst(2);
		 * linkedlist.insertFirst(1); linkedlist.insertFirst(9);
		 * linkedlist.insertFirst(8); linkedlist.insertFirst(10);
		 * linkedlist.insertFirst(11); linkedlist.insertFirst(30);
		 */
		System.out.println("LinkedlIst 1st::");
		linkedlist.displayList();
		LinkedList linkedlist2 = new LinkedList();
		linkedlist2.insertFirst(30);
		linkedlist2.insertFirst(20);
		/*
		 * linkedlist2.insertFirst(12); linkedlist2.insertFirst(7);
		 */
		System.out.println("LinkedlIst 2nd::");
		linkedlist2.displayList();

		linkedlist.mergeTwoLists(linkedlist.head, linkedlist2.head);
		System.out.println("Merged list");

		// linkedlist.swapNodes(2, 10);
		linkedlist.displayList();
		System.out.println("Middle Element is :" + linkedlist.findMiddleElement().data);
		// System.out.println("Nth Element is :" +
		// linkedlist.printNthFromLast(11).data);
		// System.out.println(linkedlist.reverse());
		linkedlist.reverseRecursive();
		linkedlist.displayList();
		// System.out.println("Element found is " +
		// linkedlist.findRecursive(linkedlist.head,8).data);

	}

}

class Node {
	public int data;
	public Node next;

	public Node(int d) {
		this.data = d;
	}

}

class LinkedList {
	Node head;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void insertFirst(int i) {
		Node newnode = new Node(i);
		newnode.next = head;
		head = newnode;
	}

	public Node deleteFirst() {
		Node temp = head;
		head = head.next;
		return temp;
	}

	public void displayList() {
		Node temp = head;
		System.out.println("Linked List::First --->Last::");
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
			System.out.print(" ");
		}
		System.out.println();
	}

	public Node deleteKey(int key) {
		Node current = head;
		Node previous = head;
		while (current.data != key) {
			if (current.next == null) // did not find it
				return null;
			else {
				previous = current; // go to next link
				current = current.next;
			}
		}
		if (current == head)// If head node itself holds the key to be deleted
			head = head.next;
		else
			previous.next = current.next;
		return current;
	}

	public Node find(int key) {
		Node current = head;
		while (current.data != key)
			current = current.next;
		return current;
	}

	public Node findRecursive(Node current, int key) {

		if (current == null)
			return null;
		if (current.data == key)
			return current;
		/*
		 * else { current = current.next; return findRecursive(current, key); }
		 */
		return findRecursive(current.next, key);
	}

	// swap nodes not data
	public void swapNodes(int d1, int d2) {
		Node current1 = head;
		Node previous1 = null;
		Node current2 = head;
		Node previous2 = null;
		while (current1.data != d1) {
			previous1 = current1;
			current1 = current1.next;
		}
		while (current2.data != d2) {
			previous2 = current2;
			current2 = current2.next;
		}
		if (previous1 != null)
			previous1.next = current2;
		else
			head = current2;
		if (previous2 != null)
			previous2.next = current1;
		else
			head = current1;
		Node temp = current1.next;
		current1.next = current2.next;
		current2.next = temp;

	}

	public Node findMiddleElement() {
		Node slowpointer = head;
		Node fastpointer = head;
		while (fastpointer != null && fastpointer.next != null) {
			fastpointer = fastpointer.next.next;
			slowpointer = slowpointer.next;

		}

		return slowpointer;
	}

	public Node printNthFromLast(int n) {
		Node firstreference = head;
		Node secondreference = head;
		for (int i = 1; i < n; i++)
			secondreference = secondreference.next;
		while (secondreference.next != null) {
			firstreference = firstreference.next;
			secondreference = secondreference.next;
		}
		return firstreference;
	}

	public Node reverse() {
		Node before = null;
		Node current = head;
		Node after = null;
		while (current != null) {
			after = current.next;
			current.next = before;
			before = current;
			current = after;
		}
		head = before;
		return head;
	}

	public void reverseRecursive() {
		Node current = head;
		reverseUtil(current);
	}

	public void reverseUtil(Node current) {

		if (current.next == null) {
			head = current;
			return;
		}
		reverseUtil(current.next);
		Node p = current.next;
		p.next = current;
		current.next = null;
	}

	public Node reverseList(Node current) {

		if (current == null || current.next == null)
			return current;

		else {

			Node nextNode = current.next;
			current.next = null;
			Node reverseListHead = reverseList(nextNode);
			nextNode.next = current;
			return reverseListHead;

		}

	}

	public void printreverseList(Node current) {

		if (current == null)
			return;

		printreverseList(current.next);
		System.out.print(current.data + " ");
	}

	public boolean detectLoop() {
		Node slowrefer = head;
		Node fastrefer = head;
		while (slowrefer != null && fastrefer != null && fastrefer.next != null) {
			slowrefer = slowrefer.next;
			fastrefer = fastrefer.next.next;
			if (slowrefer == fastrefer)
				return true;
		}
		return false;
	}

	public Node mergeTwoLists(Node l1, Node l2) {
		Node firstNode = new Node(0);
		Node p = firstNode;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.data < l2.data) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
				// p.next=null;
			} else if (l1 == null) {
				p.next = l2;
				break;
			} else if (l2 == null) {
				p.next = l1;
				break;
			}
		}

		return firstNode.next;
	}
}