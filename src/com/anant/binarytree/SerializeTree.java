package com.anant.binarytree;

import java.util.ArrayList;
import java.util.List;

public class SerializeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();

		n.setData(20);
		n1.setData(8);
		n2.setData(10);
		n3.setData(5);

		n.setLeft(n1);
		n1.setLeft(n2);
		n2.setLeft(n3);
		
		List<Integer> result = serializeBinaryTree(n, new ArrayList<Integer>());
		System.out.println(result);
		Node nodeResult = new Node();
		deSerializeBinaryTree(result, 0, nodeResult);
		System.out.println(serializeBinaryTree(nodeResult, new ArrayList<Integer>()));
	}

	public static List<Integer> serializeBinaryTree(Node n, List<Integer> result) {
		if (n == null) {
			result.add(-1);

			return result;
		}

		result.add(n.getData());
		serializeBinaryTree(n.getLeft(), result);
		serializeBinaryTree(n.getRight(), result);

		return result;
	}

	public static int deSerializeBinaryTree(List<Integer> input, int index, Node n) {
		if (index >= input.size())
			return index;

		if (input.get(index) == -1) {
			return index;
		}

		n.setData(input.get(index));

		Node left = new Node();
		n.setLeft(left);
		left.setData(Integer.MIN_VALUE);

		index = deSerializeBinaryTree(input, ++index, n.getLeft());
		if (n.getLeft().getData() == Integer.MIN_VALUE)
			n.setLeft(null);

		Node right = new Node();
		right.setData(Integer.MIN_VALUE);
		n.setRight(right);

		index = deSerializeBinaryTree(input, ++index, n.getRight());
		if (n.getRight().getData() == Integer.MIN_VALUE)
			n.setRight(null);

		return index;
	}

}
