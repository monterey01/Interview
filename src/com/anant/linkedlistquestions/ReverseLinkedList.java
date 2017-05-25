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

		if (head != null && head.next != null) {

			// 2
			Node tmp1 = head;
			Node tmp2 = null;

			// 3
			head = tmp1.next;
			tmp1.next = null;

			tmp2 = head.next;

			head.next = tmp1;

			while (tmp2 != null) {

				tmp1 = head;
				head = tmp2;
				tmp2 = head.next;
				head.next = tmp1;

			}

		}

		return head;
	}

	
}
