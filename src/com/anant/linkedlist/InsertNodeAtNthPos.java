package com.anant.linkedlist;

public class InsertNodeAtNthPos {

	//Solution for https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
	
	public static Node InsertNth(Node head, int data, int position) {
		// This is a "method-only" submission.
		// You only need to complete this method.

		Node nd = new Node();
		Node prv = null;
		Node cur = head;

		if (head == null)
			return head;

		nd.data = data;

		for (int i = 0; i <= position; i++) {

			if (i == 0) {
				if (i == position) {
					nd.next = head;
					head = nd;
				}
			} else {
				if (cur != null)
					prv = cur;
				if (cur.next != null)
					cur = cur.next;

				if (i == position) {

					prv.next = nd;
					nd.next = cur;
				}

			}

		}
		return head;
	}

}
