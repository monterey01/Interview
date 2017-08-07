package com.anant.string;

public class findSubStringOccurence {

	// Solution to
	// https://codefights.com/interview-practice/task/C8Jdyk3ybixqQdAvM/comments
	public static void main(String args[]) {

		String s = "abcd";

		String x = "aef";

		System.out.println(findFirstSubstringOccurrence(s, x));
	}

	static int findFirstSubstringOccurrence(String s, String x) {
		char[] m = s.toCharArray();
		char[] m2 = x.toCharArray();

		for (int i = 0; i < m.length && m2.length + i <= m.length; i++) {
			if (m[i] == m2[0]) {
				if ((m[i + m2.length - 1] == m2[m2.length - 1]) && hasoccurence(m, m2, i)) {

					return i;

				}
			}
		}
		return -1;
	}

	static private boolean hasoccurence(char[] m, char[] m2, int pm) {

		for (int i = 0; i < m2.length; i++) {
			if (m2[i] != m[pm + i]) {
				return false;
			}
		}

		return true;

	}

}
