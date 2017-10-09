package com.anant.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Based on https://www.youtube.com/watch?v=ZM-sV9zQPEs&index=1&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
public class Traversal {
	
	//1,2,3,4,5,6

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		Node n6 = new Node();
		Node n7 = new Node();
		Node n8 = new Node();
		Node n9 = new Node();
		Node n10 = new Node();
		Node n11 = new Node();

		n.setData(5);
		n1.setData(20);
		n2.setData(100);
		n3.setData(700);
		n4.setData(900);
		n5.setData(2000);

		n.setLeft(n1);
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setRight(n4);
		n4.setLeft(n5);

		System.out.println(" ");
		printPreOrder(n);

		System.out.println(" ");
		printInOrder(n);

		System.out.println(" ");
		// printPostOrder(n);

		System.out.println(" ");
		// printSpiralTree(n);

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

	public static void printPostOrder(Node n) {

		if (n != null) {
			printPostOrder(n.getLeft());
			printPostOrder(n.getRight());
			System.out.print(n.getData() + " ");

		}

	}

	public static void printBFS(Node root) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			System.out.println(tmp.getData());
			if (tmp.getLeft() != null)
				q.add(tmp.getLeft());
			if (tmp.getRight() != null)
				q.add(tmp.getRight());

		}
	}

	public static void printSpiralTree(Node n) {

		Stack<Node> s = new Stack<Node>();
		Stack<Node> s1 = new Stack<Node>();

		s.push(n);

		while (s.size() > 0 || s1.size() > 0) {

			while (s.size() > 0) {
				Node tmp = s.pop();
				System.out.print(tmp.getData());
				System.out.print(" ");

				if (tmp.getLeft() != null)
					s1.add(tmp.getLeft());
				if (tmp.getRight() != null)
					s1.add(tmp.getRight());

			}
			System.out.println(" ");

			while (s1.size() > 0) {

				Node tmp = s1.pop();
				System.out.print(tmp.getData());
				System.out.print(" ");

				if (tmp.getRight() != null)
					s.add(tmp.getRight());
				if (tmp.getLeft() != null)
					s.add(tmp.getLeft());

			}
			System.out.println(" ");

		}
	}

}
