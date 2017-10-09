package com.anant.linkedlist;

public class MiddleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		n.next = n1;
		n1.next = n2;
		n2.next = n3;

		n.data = 5;
		n1.data = 6;
		n2.data = 7;
		n3.data = 8;

		Node slowPointer = n;
		Node fastPointer = n;

		while (fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}

		System.out.println(slowPointer.data);

	}

}
