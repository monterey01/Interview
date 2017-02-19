package com.anant.linkedlistquestions;

public class MergeTwoSortedLinkedList {

	//Solution for https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
	static class Node {
		int data;
		Node next;
	}

	public static Node MergeLists(Node headA, Node headB) {
		Node head = null;
		Node tail = null;
	

		while (headA != null || headB != null) {
			boolean headAadded = false;
			boolean headBadded = false;
			Node tmp = null;
			Node tmp1 = null;

			if (headA != null)
				tmp = headA.next;
			if (headB != null)
				tmp1 = headB.next;

			if (headA != null && headB != null) {

				if (headA.data > headB.data) {

					headBadded = true;

				}
				{

					headAadded = true;
				}
			}

			if (headA == null && headB != null) {

				headBadded = true;
			}

			if (headA != null && headB == null) {

				headAadded = true;
			}

			if (headBadded) {
				if (head == null) {
					head = headB;
					tail = headB;

				} else {
					tail.next = headB;
					tail = headB;
				}
				headB = tmp1;
				tail.next=null;
			}

			if (headAadded) {
				if (head == null) {
					head = headA;
					tail = headA;

				} else {
					tail.next = headA;
					tail = headA;
				}
				headA = tmp;
				tail.next=null;
			}
		}
		return head;
	}

}
