package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ClassicCoinProblem {

	static int counter = 0;
	static int sum;
	static int[] memo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minNumberOfCoins(new int[] { 1, 6, 4, 5, 9, 8 }, 20, 0, 0));
		System.out.println(counter);

	}

	public static int minNumberOfCoins(int[] c, int sum, int index, int depth) {

		int result = Integer.MAX_VALUE;
		if (sum < 0) {
			return 0;
		}
		if (sum == 0) {
			return depth;
		}
		if (index >= c.length) {
			return 0;
		}

		++counter;
		int n1 = minNumberOfCoins(c, sum, index + 1, depth);

		if (n1 == 0)
			n1 = Integer.MAX_VALUE;
		int n2 = minNumberOfCoins(c, sum - c[index], index + 1, depth + 1);

		if (n2 == 0)
			n2 = Integer.MAX_VALUE;
		int temp = Math.min(n1, n2);
		result = Math.min(result, temp);

		if (result == Integer.MAX_VALUE)
			result = 0;

		return result;
	}


}
