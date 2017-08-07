package com.anant.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Solution for https://www.hackerrank.com/challenges/gem-stones
public class GemStones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nor = sc.nextInt();
		List<String> ls = new LinkedList<String>();

		while (sc.hasNext()) {
			ls.add(sc.next());
		}
		printCommonElement(ls);

		sc = null;
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
	}

	private static void printCommonElement(List<String> ls) {

		int count = 0;
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		boolean hasCommonElement = false;

		for (int i = 0; i < ls.size(); i++) {

			Set<Character> st = new HashSet<Character>();
			String s = ls.get(i);
			char c[] = s.toCharArray();

			// Add to Hashset
			for (int j = 0; j < c.length; j++) {
				st.add(c[j]);
			}

			// Add to HashMmap
			Iterator<Character> itr = st.iterator();
			while (itr.hasNext()) {

				char tc = itr.next();

				// Add the counts
				if (mp.get(tc) == null) {
					mp.put(tc, 1);
				} else {
					mp.put(tc, mp.get(tc) + 1);
				}
			}

		}

		Set<Map.Entry<Character, Integer>> s2 = mp.entrySet();
		Iterator<Map.Entry<Character, Integer>> itr = s2.iterator();

		while (itr.hasNext()) {
			Map.Entry<Character, Integer> me1 = itr.next();
			if (me1.getValue() == ls.size()) {
				count++;
			}
		}

		System.out.println(count);

	}

}