package com.anant.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PrintAllPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();

		n.setData(1);
		n1.setData(2);
		n2.setData(3);
		n3.setData(4);
		n4.setData(5);

		n.setLeft(n1);
		n.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);

		// 5,0,3,5,0,5
		
		

		printAllPaths(n, new ArrayList<Integer>());
	}

	public static void printAllPaths(Node n, List<Integer> previousValues) {

		if (n != null)
			previousValues.add(n.getData());

		if (n.getLeft() == null && n.getRight() == null) {
			for (int value : previousValues) {
				System.out.print(value + " ");
			}
			System.out.println();
		}

		if (n.getLeft() != null)
			printAllPaths(n.getLeft(), previousValues);
		if (n.getRight() != null)
			printAllPaths(n.getRight(), previousValues);
		previousValues.remove(previousValues.size() - 1);

	}
}
