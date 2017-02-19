package com.anant.bstquestions;

import com.anant.bstquestions.Node;

//Based on https://www.youtube.com/watch?v=ZM-sV9zQPEs&index=1&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
public class Search {

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

		System.out.println(searchBST(n,5));


	}

	public static Node searchBST(Node n,int key) {
		
		
		if (n==null) return null;
		
		if (n.getData()==key) return n;
		
		if(key<n.getData()){
			return searchBST(n.getLeft(),key);
		}
		else{
			return searchBST(n.getRight(),key);
		}
		
		
		

	}


}
