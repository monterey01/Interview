package com.anant.bstquestions;

import java.util.Stack;

//Based on https://www.youtube.com/watch?v=ZM-sV9zQPEs&index=1&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
public class KThSmallestElement {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n, n1, n2, n3, n4, n5, n6, n7, n8, n9;

		n = new Node();
		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n4 = new Node();
		n5 = new Node();
		n6 = new Node();
		n7 = new Node();
		n8 = new Node();
		n9 = new Node();

		n.setData(10);

		// Left First
		n1.setData(-5);
		n.setLeft(n1);

		n2.setData(-10);
		n1.setLeft(n2);

		n3.setData(0);
		n1.setRight(n3);

		n4.setData(5);
		n3.setRight(n4);

		n5.setData(30);
		n.setRight(n5);

		n6.setData(36);
		n5.setRight(n6);
		

		System.out.println(" ");
		Stack<Integer> s=printInOrder(n,null);
		
		int i=3;
		
		while (i>0){
			s.pop();
			i--;
		}
		
		System.out.println(s.pop());

	}
	public static Stack<Integer> printInOrder(Node n,Stack<Integer> s) {

		if (s==null){
			s= new Stack<Integer>();
		}
		if (n != null) {
			printInOrder(n.getLeft(),s);
		
			s.push(n.getData());
			printInOrder(n.getRight(),s);
		}

		return s;
	}


}
