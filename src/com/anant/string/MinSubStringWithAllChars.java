package com.anant.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinSubStringWithAllChars {
	// aiabc
	public static void main(String[] args) {
		// Solution to
		// https://codefights.com/interview-practice/task/rFeSD5rNy9RxfLcqg/description

		System.out.println(minSubstringWithAllChars("biibiiaiicgba", "abc"));

	}

	public static String minSubstringWithAllChars(String s, String t) {

		Map<Character, Integer> mp = new HashMap<Character, Integer>();

		int count = t.length();
		int b = 0;
		int si = -1;
		int ei = -1;

		for (char c : t.toCharArray()) {
			mp.putIfAbsent(c, 0);
			mp.put(c, mp.get(c) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (mp.containsKey(c)) {
				if (mp.get(c) > 0)
					--count;
				mp.put(c, mp.get(c) - 1);
				if (count == 0) {
					System.out.println("hello");
				}
			}

			// aaiaac
			while (count == 0) {
				if (si == -1 && ei == -1) {
					si = b;
					ei = i;
				} else if (ei - si > i - b) {
					si = b;
					ei = i;
				}

				char c1 = s.charAt(b);
				if (mp.containsKey(c1)) {
					mp.put(c1, mp.get(c1) + 1);
					if (mp.get(c1) > 0)
						++count;
				}

				++b;
			}

		}

		if (si == -1)
			return "";
		return s.substring(si, ei + 1);

	}

}
