package com.anant.bstquestions.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFSDFS {

	static List<Node> nodes = new ArrayList<Node>();

	public static class Node {
		int value;
		boolean visited;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String args[]) {

		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		int adjacency_matrix[][] = 
			  { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};

		dfs(adjacency_matrix, node40);

		for (Node node : nodes) {
			node.visited = false;
		}

		bfs(adjacency_matrix, node40);

	}

	public static List<Node> getNeighbors(int[][] adjacency_matrix, Node n) {
		int nodeIndex = -1;

		List<Node> neighbours = new ArrayList<Node>();
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).equals(n)) {
				nodeIndex = i;
				break;
			}
		}

		if (nodeIndex != -1) {
			for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
				if (adjacency_matrix[nodeIndex][j] == 1) {
					neighbours.add(nodes.get(j));
				}
			}

		}
		return neighbours;
	}

	public static void bfs(int[][] adjacency_matrix, Node n) {
		System.out.println();
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		n.visited = true;

		while (!q.isEmpty()) {
			Node e = q.remove();
			System.out.print(e.value + " ");
			List<Node> neighbours = getNeighbors(adjacency_matrix, e);
			for (int i = 0; i < neighbours.size(); i++) {
				Node tn = neighbours.get(i);
				if (tn != null && !tn.visited) {
					q.add(tn);
					tn.visited = true;
				}

			}
		}
	}

	public static void dfs(int[][] adjacency_matrix, Node n) {
		System.out.println();
		Stack<Node> s = new Stack<Node>();
		s.add(n);
		n.visited = true;

		while (!s.isEmpty()) {
			Node e = s.pop();
			System.out.print(e.value + " ");
			List<Node> neighbours = getNeighbors(adjacency_matrix, e);
			for (int i = 0; i < neighbours.size(); i++) {
				Node tn = neighbours.get(i);
				if (tn != null && !tn.visited) {
					s.add(tn);
					tn.visited = true;
				}

			}
		}
	}
}
