package LinkedList;

public class RemoveDuplicatesFromSortedLinkedList {

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

		deleteDuplicatesfromsortedlist(llist.head);

		System.out.println("Linked list after removing duplicates :");
		printList(llist.head);
	}

	// While traversing, compare each node with its next node. If data of next
	// node is same as
	// current node then delete the next node
	static void deleteDuplicatesfromsortedlist(Node head) {
		/* Another reference to head */
		Node current = head;

		/* Pointer to store the next pointer of a node to be deleted */
		Node next_next;

		/* do nothing if the list is empty */
		if (head == null)
			return;

		/* Traverse list till the last node */
		while (current.next != null) {

			/* Compare current node with the next node */
			if (current.data == current.next.data) {
				next_next = current.next.next;
				current.next = null;
				current.next = next_next;
			} else
				// advance if no deletion
				current = current.next;
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
