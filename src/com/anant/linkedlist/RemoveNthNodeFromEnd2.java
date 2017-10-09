package com.anant.linkedlist;

public class RemoveNthNodeFromEnd2 {

	public static void main(String args[]) {

		Node n1 = new Node();
		Node n2 = new Node();

		n1.data = 1;
		n2.data = 2;
		n1.next = n2;

		System.out.println(removeNthFromEnd(n1, 1).data);

	}

	public static Node removeNthFromEnd(Node head, int n) {
		Node result = head;
		Node slowPointer = head;
		Node previousSlowPointer = null;
		Node fastPointer = head;

		for (int i = 0; i < n; i++) {
			fastPointer = fastPointer.next;
			if (fastPointer == null)
				break;
		}

		while (fastPointer != null) {
			previousSlowPointer = slowPointer;
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}

		if (previousSlowPointer == null) {
			result = slowPointer.next;
			slowPointer = null;
		} else {
			previousSlowPointer.next = slowPointer.next;
			slowPointer = null;
		}

		return result;

	}

}
