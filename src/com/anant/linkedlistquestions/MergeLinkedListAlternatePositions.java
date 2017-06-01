package com.anant.linkedlistquestions;

//Solution to http://www.crazyforcode.com/merge-linked-list-linked-list-alternate-positions/
public class MergeLinkedListAlternatePositions {

	public static void main(String args[]) {

		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();

		Node n6 = new Node();
		Node n7 = new Node();
		Node n8 = new Node();
		Node n9 = new Node();

		n1.data = 1;
		n2.data = 2;
		n3.data = 3;
	

		n1.next = n2;
		n2.next = n3;


		n6.data = 4;
		n7.data = 5;
		n8.data = 6;
		n9.data = 7;

		n6.next = n7;
		n7.next = n8;
		n8.next = n9;

		System.out.println(mergeLinkedListAlternatingPosition(n1,n6));
	}

	public static Node mergeLinkedListAlternatingPosition(Node a, Node b) {
		Node tmpA = a;//1
		Node tmpB = b;//6

		while (tmpA != null && tmpB != null) {
			//5
			Node tmpA1 = tmpA.next;
			//10
			Node tmpB1=tmpB.next;
			
			//6
			tmpA.next=tmpB;
			
			tmpB.next=tmpA1;
			
			tmpA=tmpA1;
			
			//10
			tmpB=tmpB1;
			
		}
		
		System.out.println(a);

		System.out.println(tmpB);
		return a;
	}
	
}
