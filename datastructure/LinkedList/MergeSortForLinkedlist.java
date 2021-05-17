package LinkedList;

public class MergeSortForLinkedlist {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertFirst(3);
		//list.insertFirst(5);
		//head.insertFirst(2);
		//head.insertFirst(4);
		//head.insertFirst(1);
		Node head = list.head;
		while(list.head !=null) {
			System.out.print(list.head.data + " ");
			list.head=list.head.next;
		}
		Node result = MergeSortLinkedlist.mergeSort(head);

		System.out.println("");
		while(result !=null) {
			System.out.print(result.data + " ");
			result=result.next;
		}

	}

}

class MergeSortLinkedlist {
	// Function to sort the given linked list using Merge Sort.
	static Node mergeSort(Node head) {
		// add your code here

		if (head == null || head.next == null)
			return head;

		Node middleElement = findMiddleElement(head);

		Node nextToMiddle = middleElement.next;
		middleElement.next = null;

		Node left = mergeSort(head);
		Node right = mergeSort(nextToMiddle);

		Node sortedList = sortandmergeList(left, right);

		return sortedList;
	}

	static Node sortandmergeList(Node left, Node right) {
		Node result = null;

		if (left == null)
			return right;

		if (right == null)
			return left;

		if (left.data < right.data) {
			result = left;
			result.next = sortandmergeList(left.next, right);
		} else {
			result = right;
			result.next = sortandmergeList(left, right.next);
		}

		return result;
	}

	static Node findMiddleElement(Node node) {

		if (node == null)
			return node;
		Node slow = node;
		Node fast = node.next;

		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}

		return slow;
	}
}
