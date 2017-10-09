package com.anant.binarytree;

public class MaximumSumNodeNoTwoAdjacent {

	// Solution to
	// http://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
	public static void main(String[] args) {
		Node n = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();

		n.setData(1);
		n1.setData(2);
		n2.setData(1);
		n3.setData(12);
		n4.setData(4);
		n5.setData(5);

		n.setLeft(n1);
		n1.setLeft(n2);

		n.setRight(n3);
		n3.setRight(n5);
		n3.setLeft(n4);

		System.out.println(maximumSumOfNodes(n));
	}

	public static int maximumSumOfNodes(Node n) {
		int result = 0;

		if (n.getLeft() == null && (n.getRight() == null)) {
			result = n.getData();
		}

		else {
			int resultLeft = n.getLeft() == null ? 0 : maximumSumOfNodes(n.getLeft());
			int resultRight = n.getRight() == null ? 0 : maximumSumOfNodes(n.getRight());
			result = Math.max(n.getData(), resultLeft + resultRight);

		}

		return result;
	}

}
