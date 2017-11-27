package com.anant.binarytree;

public class SumTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		root.right.left = new Node(7);
		root.right.right = new Node(5);
		sumTree(root);
		System.out.println(root);
	}

	public static int sumTree(Node n) {

		if (n == null)
			return 0;
		if (n.left == null && n.right == null) {
			int v = n.data;
			n.data = 0;
			return v;
		}

		int l = sumTree(n.left);
		int r = sumTree(n.right);

		int v = n.data;
		n.data = l + r;

		return v + l + r;

	}
}
