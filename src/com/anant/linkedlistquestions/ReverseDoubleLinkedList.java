package com.anant.linkedlistquestions;

public class ReverseDoubleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();

		n.data = 1;
		n1.data = 2;
		n2.data = 3;
		n3.data = 4;

		n.next = n1;
		n1.previous = n;

		n1.next = n2;
		n2.previous = n1;

		n2.next = n3;
		n3.previous = n2;
		
		System.out.println(reverseDoubleLinkedList(n).data);

	}

	public static Node reverseDoubleLinkedList(Node n) {
		Node pointerToHead = n;

		if (n == null || (n != null && n.next == null)) {
			return n;
		}

		// Switch the first and second
		Node firstNode = n;
		Node secondNode = n.next;
		Node thirdNode = n.next.next;

		secondNode.next = firstNode;
		secondNode.previous = null;
		pointerToHead = secondNode;

		firstNode.next = thirdNode;
		firstNode.previous = secondNode;

		if (thirdNode != null) {
			thirdNode.previous = firstNode;
		}



		while (firstNode.next != null) {

			Node tmpNode1 = pointerToHead;
			Node tmpNode = firstNode.next.next;

			pointerToHead = firstNode.next;
			pointerToHead.next = tmpNode1;
			pointerToHead.previous = null;

			tmpNode1.previous = pointerToHead;

			firstNode.next = tmpNode;

		}

		return pointerToHead;
	}

}
