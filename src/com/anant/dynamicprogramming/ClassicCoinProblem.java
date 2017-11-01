package com.anant.dynamicprogramming;

import java.util.Arrays;

public class ClassicCoinProblem {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		System.out.println(minNumberOfCoins(new int[] { 1,2 }, 5));

	}

	public static int minNumberOfCoins(int[] coins, int amount) {
		int[][] m = new int[5+1][5+1];
		for (int i = 0; i < m.length; i++) {
			Arrays.fill(m[i], -1);
		}

		int result = minNumberOfCoins(coins, 0, amount, m);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				
					System.out.print(m[i][j] +",");
			}
			System.out.println();
		}
		
		return result;
	}

	public static int minNumberOfCoins(int[] c, int i, int sum, int[][] m) {
		int result = Integer.MAX_VALUE;

		if (sum < 0)
			return Integer.MAX_VALUE;

		if (sum == 0) {
			return 0;
		}

		if (i >= c.length) {
			return Integer.MAX_VALUE;
		}

		if (m[i][sum] != -1) {
			return m[i][sum];
		}

		int n2 = minNumberOfCoins(c, i, sum - c[i], m);
		int n1 = minNumberOfCoins(c, i + 1, sum, m);

		if (n2 < Integer.MAX_VALUE)
			++n2;

		result = Math.min(n2, n1);

		m[i][sum] = result;

		return result;
	}

}
