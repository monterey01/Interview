package com.anant.dynamicprogramming;

/* A Naive recursive implementation of LCS problem in java*/
public class LongestCommonSubString {

	static int lcs(char[] i1, char[] i2, int[][] m) {
		int result = 0;

		for (int i = 0; i < i1.length; i++) {

			for (int j = 0; j < i2.length; j++) {
				if (i1[i] == i2[j]) {
					m[i][j] = 1 + (i - 1 > -1 && j - 1 > -1 ? m[i - 1][j - 1] : 0);
					result = Math.max(m[i][j], result);
				} else {
					m[i][j] = 0;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {

		String s1 = "dabchhole";
		String s2 = "abceuuuuhole";
		
		

		System.out.println(
				"Length of LCS is" + " " + lcs(s1.toCharArray(), s2.toCharArray(), new int[s1.length()][s2.length()]));
	}

}
