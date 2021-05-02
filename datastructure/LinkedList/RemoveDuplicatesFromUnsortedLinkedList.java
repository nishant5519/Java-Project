package LinkedList;

import java.util.HashSet;

//Time Complexity: O(n) on average (assuming that hash table access time is O(1) on average).
public class RemoveDuplicatesFromUnsortedLinkedList {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.insertFirst(10);
		llist.insertFirst(12);
		llist.insertFirst(11);
		llist.insertFirst(11);
		llist.insertFirst(12);
		llist.insertFirst(11);
		llist.insertFirst(10);

		System.out.println("Linked list before removing duplicates :");
		printList(llist.head);

		deleteDuplicates(llist.head);

		System.out.println("Linked list after removing duplicates :");
		printList(llist.head);

	}

	static void removeDuplicate(Node first) {
		HashSet<Integer> hs = new HashSet<Integer>();// Hashset used as temp
														// buffer
		Node current = first;
		Node prev = null;
		while (current != null) {
			if (hs.contains(current.data))
				prev.next = current.next;
			else {
				hs.add(current.data);
				prev = current; // move pointer one by one
			}
			current = current.next;
		}
	}

	// without using buffer
	//Time Complexity: O(n^2)
	static void deleteDuplicates(Node first) {
		if (first == null)
			return;
		Node previous = first;
		Node current = first.next;
		while (current != null) {
			Node runner = first;
			while (runner != current) {
				if (runner.data == current.data) {
					Node tmp = current.next;// remove current
					previous.next = tmp;
					current = tmp;// update current to next node
					break;
				}
				runner = runner.next;
			}
			if (runner == current) {
				previous = current;
				current = current.next;
			}

		}

	}

	static void printList(Node head) {
		Node temp = head;
		System.out.println("Linked List::First --->Last::");
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
			System.out.print(" ");
		}
		System.out.println();
	}

}
