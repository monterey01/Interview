package com.anant.binarytree;

import java.util.LinkedList;
import java.util.List;

//Based on https://www.youtube.com/watch?v=Jg4E4KZstFE&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=7
public class RootToLeaf {

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

		 List<Node> l=rootToLeaf(n, -5, null);
		 System.out.print(l);

	}

	public static List<Node> rootToLeaf(Node n, int sum, List<Node> l) {
	
			
		if (n == null)
			return null;

		if (sum - n.getData() == 0) {
			l = new LinkedList<>();
			l.add(n);
			return l;
		} else {
		   List<Node> l1=rootToLeaf(n.getLeft(),sum-n.getData(),null);
		   if (l1!=null){
			   l1.add(n);
			   return l1;
		   }
		   List<Node> l2=rootToLeaf(n.getRight(),sum-n.getData(),null);
		   if (l2!=null){
			   l2.add(n);
			   return l2;
		   }
		}

		return l;

	}

}
