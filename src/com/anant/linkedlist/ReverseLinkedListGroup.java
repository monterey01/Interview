package com.anant.linkedlist;

//Solution for https://www.hackerrank.com/challenges/reverse-a-linked-list
public class ReverseLinkedListGroup {

	public static void main(String Args[]) {

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();

		n1.data = 1;
		n2.data = 2;
		n3.data = 3;
		n4.data = 4;
		n5.data = 5;

		n1.next = n2;
		n2.next = n3;

		// n4.next = n5;

		System.out.println(reverseNodesInKGroups(n1, 2));

	}

	static class Result {
		Node head;
		Node tail;

	}

	public static Node reverseNodesInKGroups(Node head, int k) {
		if (head == null || head.next == null)
			return head;
		Result result = null;
		Node next = head;
		head = null;

		while (next != null) {
			Node tmp = null;
			Node tail = null;
			for (int i = 0; i < k; i++) {
				if (i == 0)
					tmp = next;
				tail = next;

				next = next.next;
				if (next == null)
					break;
			}
			tail.next = null;

			Result t = reverse(tmp);
			System.out.println("hello1");

			if (result == null) {
				result = t;
			} else {
				result.tail.next = t.head;
				t.tail = t.tail;
			}
		}

		return result.head;
	}

	public static Result reverse(Node h) {
		Result r = new Result();
		Node next = h.next;
		h.next = null;

		if (next == null) {
			r.head = h;
			r.tail = h;
			return r;
		}
		r.tail = h;

		while (next != null) {
			Node tmp = next;
			next = next.next;
			tmp.next = null;
			tmp.next = h;
			h = tmp;
			r.head = h;
		}
		return r;
	}

}
