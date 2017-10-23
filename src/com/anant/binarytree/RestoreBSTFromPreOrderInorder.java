package com.anant.binarytree;

public class RestoreBSTFromPreOrderInorder {
	static int counter = 0;

	public static void main(String[] args) {

		Node n = buildBSTFromPreOrderInorder(new int[] { 10, 7, 9 }, new int[] { 9, 7, 10 }, 0, 0, 2);
		printPreOrder(n);
		System.out.println();
		printInOrder(n);

	}

	public static Node buildBSTFromPreOrderInorder(int preorder[], int inOrder[], int index, int start, int end) {

		Node n = new Node();

		if (start > end)
			return null;

		n.setData(preorder[index]);

		if (start == end)
			return n;

		++counter;
		int inOrderIndex = findInorderIndex(inOrder, start, end, preorder[index]);

		n.setLeft(buildBSTFromPreOrderInorder(preorder, inOrder, index + 1, start, inOrderIndex - 1));
		n.setRight(buildBSTFromPreOrderInorder(preorder, inOrder, index + inOrderIndex - start + 1, 1 + inOrderIndex,
				end));

		return n;
	}

	public static int findInorderIndex(int inOrder[], int start, int end, int value) {
		int i;
		for (i = start; i <= end; i++) {
			++counter;
			if (inOrder[i] == value)
				return i;
		}
		return i;
	}

	public static void printPreOrder(Node n) {

		if (n != null) {
			System.out.print(n.getData() + " ");
			printPreOrder(n.getLeft());
			printPreOrder(n.getRight());
		}

	}

	public static void printInOrder(Node n) {

		if (n != null) {
			printInOrder(n.getLeft());
			System.out.print(n.getData() + " ");
			printInOrder(n.getRight());
		}

	}

}
