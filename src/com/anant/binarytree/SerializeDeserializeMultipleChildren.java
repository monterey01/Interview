package com.anant.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeMultipleChildren {

	public static class Node {

		int data;
		List<Node> children;
		
		@Override
		public String toString() {
			return "Node [data=" + data + ", children=" + children + "]";
		}
		
		

	}

	public static void main(String args[]) {
		Node n = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();

		n.data = 1;
		n1.data = 2;
		n2.data = 3;
		n3.data = 4;
		n4.data = 4;

		List<Node> children = new ArrayList<Node>();
		children.add(n1);
		children.add(n2);
		children.add(n3);
		n.children = children;
		
		List<Node> children1 = new ArrayList<Node>();
		children1.add(n4);
		n1.children=children1;
		
		
		Queue<Integer> q=new LinkedList<Integer>();
		serialize( n,  q);
		System.out.println(q);;
		System.out.println(deserialize(q).toString());;
		
	}

	public static void serialize(Node n, Queue<Integer> q) {

		if (n == null)
			return;

		q.add(n.data);

		if (n.children != null) {
			q.add(Integer.MIN_VALUE);
			for (Node tmpNode : n.children) {
				serialize(tmpNode, q);
			}
			q.add(Integer.MIN_VALUE);
		} else {
			q.add(Integer.MAX_VALUE);

		}

	}

	public static Node deserialize(Queue<Integer> q) {

		Node n = new Node();

		n.data = q.poll();

		if (!q.isEmpty() && q.peek() == Integer.MAX_VALUE) {
			q.poll();
		} else if (!q.isEmpty() && q.peek() == Integer.MIN_VALUE) {

			q.poll();
			List<Node> tmpList = new ArrayList<Node>();

			while (!q.isEmpty() && q.peek() != Integer.MIN_VALUE) {
				tmpList.add(deserialize(q));
			}

			q.poll();
			n.children = tmpList;

		}

		return n;

	}

}
