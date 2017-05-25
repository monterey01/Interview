package com.anant.bstquestions;

public class IsBST {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n, n1, n2, n3, n4, n5, n6, n7, n8;

		n = new Node();
		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n4 = new Node();
		n5 = new Node();
		n6 = new Node();
		n7 = new Node();
		n8 = new Node();

		n.setData(10);
		n1.setData(5);
		n2.setData(11);
		n3.setData(19);

		n.setLeft(n1);

		n.setRight(n2);
		n1.setRight(n3);

		System.out.print(isValidBST(n, Integer.MAX_VALUE, Integer.MIN_VALUE));

	}

	/**
	 * 10 5 15 3 7 9
	 * 
	 */

	public static boolean isValidBST(Node n, int max, int min) {


		if (n == null)
			return true;

		if (n.getData() <= min || n.getData() >= max)
			return false;
		return isValidBST(n.getLeft(), Math.max(n.getData(), max), min)
				&& isValidBST(n.getRight(), max, Math.max(min, n.getData()));

	}

}
