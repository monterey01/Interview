package com.anant.linkedlistquestions;

//Solution for https://www.hackerrank.com/challenges/reverse-a-linked-list
public class ReverseLinkedListGroup2 {

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
		n3.next = n4;
		//n4.next = n5;

		System.out.println(reverseNodesInKGroups(n1, 2));

	}

	static Node reverseNodesInKGroups(Node l, int k) {
		Node header = null;
		Node tmpheader = l;

		if (k == 1)
			return l;

		Node next = tmpheader.next;
		int i = 1;
		// 1,2,3,4,5
		// 2,1
		// 4,3
		// 3,4,5,6
		Node ptr1 = null;
		Node ptr2 = null;

		while (next != null) {

			++i;
			if (i % k == 0) {
				Node tmpNode = next.next;
				next.next = null;
				if (ptr1 == null) {
					ptr1 = tmpheader;
				} else {
					ptr2 = tmpheader;
				}

				Node tmpNode1 = reverse(tmpheader, k);
				if (header == null) {
					header = tmpNode1;
				} else {
					if (ptr1 != null && ptr2 != null) {
						ptr1.next = tmpNode1;
						ptr1 = ptr2;
						ptr2 = null;

					}
				}
				tmpheader = tmpNode;
				next = tmpNode!=null? tmpNode.next:null;
				++i;

			} else {
				next = next.next;
				
			}
			if (next == null) {
				if(!ptr1.equals(tmpheader))ptr1.next = tmpheader;
			}

		}

		return header;

	}

	public static Node reverse(Node head, int count) {
		// 2,3,4
		int i = 0;

		Node nextNode = head.next;

		head.next = null;

		while (nextNode != null && i < count - 1) {
			Node tmp = nextNode;
			nextNode = nextNode.next;

			tmp.next = head;
			head = tmp;

			++i;
		}

		return head;
	}

}
