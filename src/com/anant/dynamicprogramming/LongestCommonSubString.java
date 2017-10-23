package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/* A Naive recursive implementation of LCS problem in java*/
public class LongestCommonSubString {

	static class Memo {

		int xPosition;
		int yPosition;

		public Memo(int xPosition, int yPosition) {
			this.xPosition = xPosition;
			this.yPosition = yPosition;
		}

		public boolean equals(Object obj) {
			if (obj.getClass().equals(this.getClass())) {
				Memo tmpMemo = (Memo) obj;
				if (tmpMemo.xPosition == this.xPosition && tmpMemo.yPosition == this.yPosition)
					return true;

			}

			return false;

		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + xPosition;
			result = prime * result + yPosition;
			return result;
		}

	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcs(char[] X, char[] Y, int m, int n, Map<Memo, Integer> memoziation) {

		int result = 0;
		int result1 = 0;
		int result2 = 0;

		if (m >= X.length || n >= Y.length)
			return 0;

		Memo memo = new Memo(m, n);
		if (memoziation.containsKey(memo)) {
				return memoziation.get(memo);
		}

		if (X[m] == Y[n]) {
			result1 = 1;
		}

		if (m + 1 < X.length && n + 1 < Y.length) {
			if (result1 == 1 && X[m + 1] == Y[n + 1]) {
				result1 += lcs(X, Y, m + 1, n + 1, memoziation);
			} else {
				result2 = Math.max(lcs(X, Y, m, n + 1, memoziation), lcs(X, Y, m + 1, n, memoziation));
			}
		}

		result = Math.max(result1, result2);

		memoziation.put(memo, result);

		return result;
	}

	public static void main(String[] args) {

		String s1 = "abicde";
		String s2 = "cdeiab";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();

		System.out.println("Length of LCS is" + " " + lcs(X, Y, 0, 0, new HashMap<Memo, Integer>()));
	}

}
