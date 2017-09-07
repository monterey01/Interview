package com.anant.dynamicprogramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithUniqueCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLongestSubStringWithUniqueChars("BCBBBBCICAAA".toCharArray()));
	}

	// AABBCBBBBBCA
	public static int getLongestSubStringWithUniqueChars(char input[]) {
		int currentLargestSubStringWithUniqueChars = 0;
		int previousLargestSubStringWithUniqueChars  = 0;
		int result = 0;
		int lastCharacterChangePosition = -1;

		Set<Character> uniqueCharacters = new HashSet<Character>();
		List<Character> list = new LinkedList<Character>();

		for (int i = input.length - 1; i >= 0; i--) {
			if (uniqueCharacters.size() == 0 || uniqueCharacters.contains(input[i])) {

				uniqueCharacters.add(input[i]);
				++currentLargestSubStringWithUniqueChars;
				list.add(input[i]);

			} else if (!uniqueCharacters.contains(input[i]) && uniqueCharacters.size() == 1) {

				uniqueCharacters.add(input[i]);
				list.add(input[i]);
				++currentLargestSubStringWithUniqueChars;
				lastCharacterChangePosition = i;

			} else if (!uniqueCharacters.contains(input[i]) && uniqueCharacters.size() == 2) {

				if (currentLargestSubStringWithUniqueChars > previousLargestSubStringWithUniqueChars) {
					result = currentLargestSubStringWithUniqueChars;
					previousLargestSubStringWithUniqueChars = currentLargestSubStringWithUniqueChars;
					currentLargestSubStringWithUniqueChars = 0;
				}

				uniqueCharacters.remove(list.get(0));
				list.remove(0);

				if (lastCharacterChangePosition != -1 && input[i + 1] == input[lastCharacterChangePosition]) {
					currentLargestSubStringWithUniqueChars = 2 + (Math.abs(i + 1 - lastCharacterChangePosition));

				} else {
					currentLargestSubStringWithUniqueChars = 2;

				}

				lastCharacterChangePosition = -1;
				uniqueCharacters.add(input[i]);
				list.add(input[i]);

			}

		}
		return Math.max(result, currentLargestSubStringWithUniqueChars);
	}
}
