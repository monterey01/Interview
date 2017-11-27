package com.anant.queuesstacks;

import java.util.LinkedList;
import java.util.Queue;

import com.anant.binarytree.Node;

public class MultiplicationOfSums {

	//Solution to http://www.geeksforgeeks.org/find-multiplication-of-sums-of-data-of-all-leaves-at-sane-levels/
	public static void main(String[] args) {
				Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.left = new Node(8);
		root.left.right = new Node(6);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);
		root.right.right = new Node(9);
		root.right.right.left = new Node(4);
		root.right.right.right = new Node(10);
		System.out.println("The final product value : " + sm(root));

	}

	public static int sm(Node n) {
		if (n == null)
			return 0;
		int m = 0;
		Queue<Integer> ls = new LinkedList<Integer>();
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();

		q1.add(n);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			int sum = 0;

			while (!q1.isEmpty()) {
				Node t = q1.remove();

				if (t.getLeft() == null && t.getRight() == null)
					sum += t.getData();
				if (t.getLeft() != null)
					q2.add(t.getLeft());
				if (t.getRight() != null)
					q2.add(t.getRight());
			}

			if (sum != 0)
				ls.add(sum);
			sum = 0;

			while (!q2.isEmpty()) {
				Node t = q2.remove();

				if (t.getLeft() == null && t.getRight() == null)
					sum += t.getData();
				if (t.getLeft() != null)
					q1.add(t.getLeft());
				if (t.getRight() != null)
					q1.add(t.getRight());
			}

			if (sum != 0)
				ls.add(sum);

		}

		if (ls.size() > 0)
			m = 1;
		while (!ls.isEmpty()) {
			m *= ls.remove();
		}

		return m;
	}
}
