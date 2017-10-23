package com.anant.binarytree;

public class IsBST {


	public static void main(String[] args) {

		

		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Node n, n1, n2, n3;

		n = new Node();
		n1 = new Node();
		n2 = new Node();
		n3 = new Node();

		n.setData(10);
		n1.setData(5);
		n2.setData(11);
		n3.setData(7);

		n.setLeft(n1);

		n.setRight(n2);
		n1.setRight(n3);

		System.out.print(isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	public static boolean isBST(Node n, Integer min, Integer max) {

		if (n == null)
			return true;

		if (n.getData() < min || n.getData() > max) {
			return false;
		}

		return (isBST(n.getRight(), n.getData(), max)
				&& isBST(n.getLeft(), min, n.getData()));

	}
	
	/**
	 *    8
	 *  6
	 *   10
	 */

}
