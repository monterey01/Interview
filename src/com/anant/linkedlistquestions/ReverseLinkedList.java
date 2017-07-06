package com.anant.linkedlistquestions;

//Solution for https://www.hackerrank.com/challenges/reverse-a-linked-list
public class ReverseLinkedList {

	public static void main(String Args[]) {

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();

		n1.data = 1;
		n2.data = 3;
		n3.data = 5;
		n4.data = 6;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		System.out.println(reverse(n1).toString());

	}

	public static Node reverse(Node head) {
		// 2,3,4

		Node nextNode = head.next;

		head.next = null;

		while (nextNode != null) {
			Node tmp = nextNode;
			nextNode = nextNode.next;
			
			tmp.next = head;
			head=tmp;
			
		}

		return head;
	}

	
}
