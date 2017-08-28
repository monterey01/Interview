package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/* A Naive recursive implementation of LCS problem in java*/
public class LongestCommonSubsequence {

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

		if (m == 0 || n == 0)
			return 0;

		if (memoziation.containsKey(new Memo(m, n))) {
			return memoziation.get(new Memo(m, n));
		}

		if (X[m - 1] == Y[n - 1])
			result = 1 + lcs(X, Y, m - 1, n - 1, memoziation);
		else
			result = max(lcs(X, Y, m, n - 1, memoziation), lcs(X, Y, m - 1, n, memoziation));

		Memo memo = new Memo(m, n);
		memoziation.put(memo, result);

		return result;
	}

	/* Utility function to get max of 2 integers */
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
		double test=(double)5/(double)2;
		System.out.println(test);;

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n, new HashMap<Memo, Integer>()));
	}

}
