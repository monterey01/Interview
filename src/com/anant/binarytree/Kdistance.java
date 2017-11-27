package com.anant.binarytree;

import java.util.LinkedList;
import java.util.List;

public class Kdistance {

	public static void main(String[] args) {
		//Solution to http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

		/* Let us construct the tree shown in above diagram */
		Node r = new Node(20);
		r.left = new Node(8);
		r.right = new Node(22);
		r.left.left = new Node(4);
		r.left.right = new Node(12);
		r.left.right.left = new Node(10);
		r.left.right.right = new Node(14);
		Node target = 	r.left.right.right;
		List<Integer> result = new LinkedList<Integer>();
		findNodes(r, -1, target, 3, result);
		System.out.println(result);

	}

	public static int findNodes(Node r, int c, Node k, int n, List<Integer> ls) {
		if (r == null)
			return -1;

		if (r == k) {
			c = n + 1;
		}

		if (c - 1 == 0) {
			ls.add(r.data);
			return -1;
		}

		int lr = findNodes(r.left, c - 1, k, n, ls);
		int rr = findNodes(r.right, c - 1, k, n, ls);

		if (r == k)
			return --c;

		if (lr == -1 && rr == -1) {
			return -1;
		}

		if (lr == -1 || rr == -1) {
			c = Math.max(lr, rr);
			if(c-1==0) {
				ls.add(r.data);
				return -1;
			}
			findNodes(lr != -1 ? r.right : r.left, c - 1, k, n, ls);
		}

		return c - 1;

	}

}
