package com.anant.binarytree;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

//Based on https://www.youtube.com/watch?v=ZM-sV9zQPEs&index=1&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
public class HeightOfBinaryTree {

		
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
		n1.setData(15);
		n.setLeft(n1);

		n2.setData(3);
		n1.setLeft(n2);

		n3.setData(6);
		n1.setRight(n3);

		n4.setData(5);
		n2.setLeft(n4);

		n5.setData(30);
		n.setRight(n5);

		n6.setData(2);
		n5.setRight(n6);

		n7.setData(9);
		n6.setLeft(n7);

		n8.setData(8);
		n6.setRight(n8);

		System.out.println(hOfBST(n,0));
	    
	}
	
	public static int hOfBST(Node n,int h){
		
		if (n==null) return h;
		int lh=0;
		int rh=0;
		
		if (n.getLeft()!=null){
			lh=hOfBST(n.getLeft(),0);
		}
		
		if (n.getRight()!=null){
			rh=hOfBST(n.getRight(),0);
		}
		
		h=Math.max(lh, rh) +1;
		
		
		return h;
	}


}
