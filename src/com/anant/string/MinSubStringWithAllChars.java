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

		System.out.println(minSubstringWithAllChars("adobecodebanc", "abc"));

	}

	// aibca ,abc
	static String minSubstringWithAllChars(String s, String t) {
		StringBuilder tmpResult = new StringBuilder();
		StringBuilder result = null;
		Set<Character> setT = getUniqCharacterHashSet(t);

		Set<Character> tmpSetT = new HashSet<Character>(setT);
		char[] ca = s.toCharArray();
		boolean start = false;
		Map<Character, Integer> uniqueCharacterPosition = new HashMap<Character, Integer>();

		for (int i = 0; i < ca.length; i++) {

			if (tmpSetT.contains(ca[i]) || start == true) {

				if (start == false && uniqueCharacterPosition.size() > 0
						|| uniqueCharacterPosition.containsKey(ca[i]) && tmpResult.charAt(0) == ca[i]) {

					i = uniqueCharacterPosition.get(ca[i]);
					tmpResult = new StringBuilder();
					uniqueCharacterPosition = new HashMap<Character, Integer>();
					tmpSetT = new HashSet<Character>(setT);
					start = false;
					continue;

				}

				start = true;
				tmpResult.append(ca[i]);

				if (setT.contains(ca[i]))
					uniqueCharacterPosition.put(ca[i], i);
				tmpSetT.remove(ca[i]);

				if (tmpSetT.isEmpty()) {
					start = false;
					tmpSetT = new HashSet<Character>(setT);
					result = result == null ? result = new StringBuilder(tmpResult)
							: tmpResult.length() < result.length() ? new StringBuilder(tmpResult) : result;

					tmpResult = new StringBuilder();
				}
			}

		}

		result = result == null ? new StringBuilder() : result;
		return result.toString();
	}

	static Set<Character> getUniqCharacterHashSet(String t) {
		Set<Character> charSet = new HashSet<Character>();

		for (char c : t.toCharArray()) {
			charSet.add(c);
		}

		return charSet;

	}

}
