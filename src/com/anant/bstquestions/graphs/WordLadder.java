package com.anant.bstquestions.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordLadder {
	static int counter = 0;

	
	//Solution to WordLadder https://leetcode.com/problems/word-ladder/description/
	public static void main(String[] args) {
		/**
		 * beginWord = "hit" endWord = "cog" wordList = ["hot","cog"]
		 * 
		 **/

		String beginWord = "hit";
		String endWord = "cog";
		// wordList = ["hot","dot","dog","lot","log","cog"]

		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		boolean[] isVisited = new boolean[wordList.size()];

		System.out.println(ladderLength(beginWord, endWord, wordList, 0, isVisited, new ArrayList<String>(),
				new HashMap<Integer, Integer>()));
		System.out.println(counter);

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList, int number,
			boolean[] isVisited, List<String> ls, HashMap<Integer, Integer> map) {
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < wordList.size(); i++) {

			String tmp = wordList.get(i);
			++counter;

			if (!isVisited[i] && oneCharacterdiff(beginWord, tmp)) {

				if (map.containsKey(i)) {
					int result12 = map.get(i);
					if (result12 > 0 && result12 < Integer.MAX_VALUE)
						++result12;
					if (result12 == -1)
						result12 = 2;
					result = Math.min(result12, result);
					continue;
				}

				if (tmp.equals(endWord)) {
					System.out.println(number + "," + ls);
					return -1;
				}

				ls.add(tmp);
				isVisited[i] = true;
				int result1 = (ladderLength(tmp, endWord, wordList, number + 1, isVisited, ls, map));

				if (result1 > 0 && result1 < Integer.MAX_VALUE)
					++result1;
				if (result1 == -1)
					result1 = 2;

				result = Math.min(result1, result);
				ls.remove(ls.size() - 1);
				isVisited[i] = false;
				map.put(i, result);
				System.out.println(map);
			}

		}
		

		return result;
	}

	public static boolean oneCharacterdiff(String a, String b) {
		int diff = 0;
		char[] c = a.toCharArray();
		char[] c1 = b.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (c[i] != c1[i])
				++diff;
			if (diff > 1)
				return false;
		}

		return true;
	}
}