package com.anant.linkedlist;

public class FindMidPoint {

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
		//n2.next = n3;
		//n3.next = n4;
		 //n4.next = n5;

		System.out.println(findMidpoint(n1).data);

		// 1,2,3,4,5
		   

	}

	private static Node findMidpoint(Node h) {

		Node pt1 = h;
		Node pt2 = h;

		while (pt2 != null && pt2.next != null) {
			pt1 = pt1.next;

			pt2 = pt2.next.next;
		}

		return pt1;
	}

}
