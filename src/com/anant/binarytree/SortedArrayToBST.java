package com.anant.binarytree;

public class SortedArrayToBST {

	static int i[] = {1,2,3,4,5,6};

	public static void main(String args[]) {

		Node n = returnBSTNode(i, 0, 5);
		System.out.println(n);

	}

	public static Node returnBSTNode(int[] i, int start, int end) {

		if (start > end)
			return null;

		int mid =(start + end)/2;
		Node root = new Node();
		root.setData(i[mid]);

		root.setLeft(returnBSTNode(i, start, mid - 1));
		root.setRight(returnBSTNode(i, mid + 1, end));

		return root;

	}

}
