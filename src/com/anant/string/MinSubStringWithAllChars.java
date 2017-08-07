package com.anant.string;

import java.util.HashSet;
import java.util.Set;

public class MinSubStringWithAllChars {

	public static void main(String[] args) {
		// Solution to https://codefights.com/interview-practice/task/rFeSD5rNy9RxfLcqg/description
		System.out.println(minSubstringWithAllChars("axxbxca", "abc"));

	}

	static String minSubstringWithAllChars(String s, String t) {
		StringBuilder result = new StringBuilder();

		Set<Character> uniqCharacterHashSet = getUniqCharacterHashSet(t);
		char[] ca = s.toCharArray();

		for (int i = 0; i < ca.length; i++) {

			if (uniqCharacterHashSet.contains(ca[i])) {
				Set<Character> tmpUniqCharacterHashSet = getUniqCharacterHashSet(t);
				StringBuilder tmpResultBuilder = new StringBuilder();
				tmpResultBuilder.append(ca[i]);
				tmpUniqCharacterHashSet.remove(ca[i]);

				if (tmpUniqCharacterHashSet.size() == 0) {

					result=getMinimumResult(result,tmpResultBuilder);
					break;
				} else {

					for (int j = i + 1; j < ca.length; j++) {
						tmpResultBuilder.append(ca[j]);

						if (tmpUniqCharacterHashSet.contains(ca[j])) {
							tmpUniqCharacterHashSet.remove(ca[j]);
						}

						if (tmpUniqCharacterHashSet.size() == 0) {

							result=getMinimumResult(result,tmpResultBuilder);
							break;
						}

					}
				}
			}
		}

		return result.toString();

	}

	static StringBuilder getMinimumResult(StringBuilder result, StringBuilder tmpResult) {

		if (result.length() == 0) {
			result = tmpResult;
		} else {
			if (result.length() > tmpResult.length()) {
				result = tmpResult;
			}
		}

		return result;

	}

	static Set<Character> getUniqCharacterHashSet(String t) {
		Set<Character> charSet = new HashSet<Character>();

		for (char c : t.toCharArray()) {
			charSet.add(c);
		}

		return charSet;

	}

}
