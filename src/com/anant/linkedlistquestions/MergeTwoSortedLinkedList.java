package com.anant.linkedlistquestions;

public class MergeTwoSortedLinkedList {

	// Solution for
	// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists

	// 1356
	// 247

	public static void main(String[] args) {

		Integer n20 = new Integer(-333);

		Integer n21 = new Integer(-333);

		if (n20 == n21)
			System.out.println("this is same");

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();

		n1.data = 1;
		n2.data = 3;
		n3.data = 5;
		n4.data = 6;

		n5.data = 2;
		n6.data = 4;
		n7.data = 7;

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		n5.next = n6;
		n6.next = n7;

		System.out.println(mergeTwoLinkedLists(n1, n5));

	}

	static Node mergeTwoLinkedLists(Node l1, Node l2) {

		Node result = null;
		Node tail = null;

		while (!(l1 == null) || !(l2 == null)) {

			Node tmp = null;

			if (l1 != null && l2 != null) {

				if (l1.data < l2.data) {
					tmp = l1;
					l1 = l1.next;
				} else if (l2.data < l1.data) {
					tmp = l2;
					l2 = l2.next;
				} else if (l2.data == l1.data) {
					tmp = l1;
					l1 = l1.next;

				}

			} else if (l1 != null) {
				tmp = l1;
				l1 = l1.next;
			}

			else if (l2 != null) {
				tmp = l2;
				l2 = l2.next;
			}

			if (tmp == null) {

				if (l1 != null)
					System.out.println(l1.data);
				if (l2 != null)
					System.out.println(l2.data);
				System.out.println("tmp is null");
			}

			if (result == null) {
				result = tmp;
				tail = tmp;
				result.next = null;
			} else {
				if (tail != null && tmp != null) {
					tmp.next = null;
					tail.next = tmp;
					tail = tail.next;
				}
			}

		}

		return result;
	}

}
