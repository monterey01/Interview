package com.anant.linkedlistquestions;

public class MergeTwoSortedLinkedList {

	// Solution for
	// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists

	// 1356
	// 247

	public static void main(String[] args) {

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

		System.out.println(MergeLists(n1, n5));

	}
	


	public static Node MergeLists(Node headA, Node headB) {
		Node head = null;
		Node tail = null;

		while (headA != null || headB != null) {
			Node n = new Node();

			if (headA != null && headB != null) {

				if (headB.data > headA.data) {
					n.data = headA.data;
					if (headA.next != null)
						headA = headA.next;
					else {
						headA = null;
					}
				} else {
					n.data = headB.data;
					if (headB.next != null) {
						headB = headB.next;
					} else {
						headB = null;
					}
				}
			} else {
				if (headA != null) {
					n=headA;
					if (headA.next != null)
						{headA = headA.next;}
					else{
						headA=null;
					}
				}

				if (headB != null) {
					n=headB;
					if (headB.next != null){
						headB = headB.next;}
					else{
						headB=null;
					}
				}
			}

			if (head == null) {
				head = n;
				tail = head;
			} else {
				tail.next = n;
				tail = tail.next;
			}
		}

		return head;

	}

}
