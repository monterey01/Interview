package com.anant.binarytree;

//Solution to http://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
public class ExtractLeavesBinaryTree {
	static class ListNode {

		int value;
		ListNode previous;
		ListNode next;

		@Override
		public String toString() {
			return "ListNode [value=" + value + " previous"  + " next=" + next + "]";
		}

	}

	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode() {

		}

		public TreeNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
		}

	}

	public static class Result {
		ListNode head;
		ListNode tail;

		@Override
		public String toString() {
			return "Result [head=" + head + ", tail=" + tail + "]";
		}

	}

	public static void main(String[] args) {

		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);

		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.right.right = new TreeNode(6);
		tree.left.left.left = new TreeNode(7);
		tree.left.left.right = new TreeNode(8);
		tree.right.right.left = new TreeNode(9);
		tree.right.right.right = new TreeNode(10);
		Result result = new Result();
		traverse(tree, result);
		System.out.println(tree);
		System.out.println(result.head);

	}

	public static boolean traverse(TreeNode root, Result result) {
		boolean isLeafNode = false;

		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			isLeafNode = true;
			if (result.head == null) {
				ListNode h = new ListNode();
				h.value = root.value;
				result.head = h;
				result.tail = h;

			} else {
				ListNode tmp = new ListNode();
				tmp.value = root.value;
				result.tail.next = tmp;
				tmp.previous = result.tail;
				result.tail = result.tail.next;
			}

		}

		if (traverse(root.left, result))
			root.left = null;
		if (traverse(root.right, result))
			root.right = null;

		return isLeafNode;
	}

}
