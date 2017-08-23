package com.anant.linkedlist;

public class FindKthNodeFromEnd {

	public static void main(String args[]) {

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
		n3.next = n4;
		n4.next = n5;

		System.out.println(findKthNodeFromLast(n1, 1).data);

	}

	private static Node findKthNodeFromLast(Node h, int n) {

		Node pt1 = h;
		Node pt2 = h;

		for (int i = 1; i <= n; i++) {
			if (pt2 != null && pt2.next == null)
				return h;
			pt2 = pt2 == null ? h : pt2.next;

		}

		while (pt2.next != null) {
			pt1 = pt1 == null ? h : pt1.next;

			pt2 = pt2.next;
		}

		return pt1;
	}

}
