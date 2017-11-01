package com.anant.bstquestions.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Solution to https://leetcode.com/problems/graph-valid-tree/description/
public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = new int[][] { {0, 1}, {0,2}};
		System.out.println(validTree(3, edges));
	}

	public static boolean validTree(int n, int[][] edges) {

		List<List<Integer>> ls = new LinkedList<List<Integer>>();


		for (int i = 0; i < n; i++) {
			ls.add(new LinkedList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {

			ls.get(edges[i][0]).add(edges[i][1]);
			ls.get(edges[i][1]).add(edges[i][0]);
		}
		
		boolean[] visited = new boolean[n];
		if (!hasCycle(ls, visited, 0))
			return false;

		for (boolean value : visited) {
			if (!value)
				return false;
		}

		return true;
	}

	public static boolean hasCycle(List<List<Integer>> ls, boolean[] visited, int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		visited[i]=true;
		int[] parents=new int[ls.size()];
		Arrays.fill(parents, Integer.MIN_VALUE);
		
		
		while (!q.isEmpty()) {
			int parent = q.remove();
			
			for (int value : ls.get(parent)) {
				if(parents[value]!=Integer.MIN_VALUE)return true;
				parents[value]=parent;
				
				if(visited[value]) continue;
				visited[value] = true;
				q.add(value);
				
			}

		}
		return false;

	}

}
