package com.anant.linkedlistquestions;

//Solution to http://www.crazyforcode.com/print-linked-list-elements-reverse-order/
public class PrintInReverseOrder {

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

		printReverseOrder(n1);

	}

	public static void printReverseOrder(Node n) {
		
		if(n.next!=null)printReverseOrder(n.next);
		System.out.println(n.data);

	}

}
