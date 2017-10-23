package com.anant.bstquestions.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {
	static int counter = 0;

	// Solution to WordLadder https://leetcode.com/problems/word-ladder/description/
	public static void main(String[] args) {
		/**
		 * beginWord = "hit" endWord = "cog" wordList = ["hot","cog"]
		 * "hot"
"dog"
["hot","cog","dog","tot","hog","hop","pot","dot"]
		 **/

		String beginWord = "hot";
		String endWord = "dog";
		// wordList = ["hot","dot","dog","lot","log","cog"]

		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("cog");
		wordList.add("dog");
		wordList.add("tot");
		wordList.add("hog");
		wordList.add("hop");
		wordList.add("pot");
		wordList.add("dot");
		

		System.out.println(ladderLength(beginWord, endWord, wordList));

	}

	static class Node {
		int level;
		String s;

		public Node(int level, String s) {
			this.level = level;
			this.s = s;
		}

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int result = 0;

		Queue<Node> q = new LinkedList<Node>();
		Set<String> isVisited = new HashSet<String>();

		q.add(new Node(1, beginWord));
		

		while (!q.isEmpty()) {
			Node tmp = q.remove();

			char[] ca = tmp.s.toCharArray();

			for (int i = 0; i < wordList.size(); i++) {
				if (!(isVisited.contains(wordList.get(i)))) {

					char[] ca1 = wordList.get(i).toCharArray();
					int diffChar = 0;

					for (int j = 0; j < tmp.s.length(); j++) {
						if (ca[j] != ca1[j]) {
							++diffChar;
						}
					}
					if (diffChar <= 1) {
						if (wordList.get(i).equals(endWord))
							return tmp.level + 1;
						q.add(new Node(tmp.level + 1, wordList.get(i)));
						isVisited.add(wordList.get(i));

					}

				}

			}

		}

		return result;

		// "hit" -> "hot" -> "dot" -> "dog" -> "cog"

	}

}