package com.anant.arrayquestions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

//Answer to https://codefights.com/arcade/intro/level-2/2mxbGwLzvkTCKAJMG/comments
public class AlmostIncreasingSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i[] = { 3, 4, 1, 2 };
		System.out.println(1/0 >2);

		// System.out.println(almostIncreasingSequence(i));
		System.out.println(commonCharacterCount("aabcc", "adcaa"));

	}

	static boolean almostIncreasingSequence(int[] sequence) {
		int prevValueToMaxValue = Integer.MIN_VALUE;
		int maxVlue = Integer.MIN_VALUE;

		int n = 0;
		for (int i = 0; i < sequence.length; i++) {

			if (sequence[i] <= prevValueToMaxValue || sequence[i] == maxVlue) {
				n++;
			}

			if (i - 1 > -1 && (sequence[i] <= sequence[i - 1])) {
				maxVlue = sequence[i - 1];
				if (i - 2 > -1)
					prevValueToMaxValue = sequence[i - 2];
				n++;
			}

		}

		if (n == 1 || n == 0) {
			return true;
		}
		HashMap<Character, Integer> mp = null;
		Iterator<Map.Entry<Character, Integer>> itr = mp.entrySet().iterator();

		return false;

	}

	static int commonCharacterCount(String s1, String s2) {

		Map<Character, Integer> mp = new TreeMap<Character, Integer>();
		Map<Character, Integer> mp1 = new TreeMap<Character, Integer>();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int ccc = 0;

		for (int i = 0; i < c1.length; i++) {
			if (mp.get(c1[i]) != null) {
				mp.put(c1[i], mp.get(c1[i]) + 1);
			} else {
				mp.put(c1[i], 1);
			}

		}

		for (int i = 0; i < c2.length; i++) {

			if (mp1.get(c2[i]) != null) {
				mp1.put(c2[i], mp1.get(c2[i]) + 1);
			} else {
				mp1.put(c2[i], 1);
			}

		}
		System.out.println(mp);

		System.out.println(mp1);
		Iterator<Map.Entry<Character, Integer>> itr = mp.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<Character, Integer> e = itr.next();
			if (mp1.get(e.getKey()) != null) {
				ccc = ccc + Math.min(e.getValue(), mp1.get(e.getKey()));
			}
		}

		return ccc;
	}

}
