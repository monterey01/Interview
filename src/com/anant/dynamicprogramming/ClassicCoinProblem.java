package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ClassicCoinProblem {

	static class Memo {
		int index;
		int sum;

		public Memo(int index, int sum) {
			this.index = index;
			this.sum = sum;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + sum;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Memo other = (Memo) obj;
			if (index != other.index)
				return false;
			if (sum != other.sum)
				return false;
			return true;
		}

	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		System.out.println(minNumberOfCoins(new int[] { 3,5}, 13));
		System.out.println(System.currentTimeMillis() - startTime);

	}

	public static int minNumberOfCoins(int[] coins, int amount) {
		int result = minNumberOfCoins(coins, 0, amount, new HashMap<Memo, Integer>());

		return result;
	}

	public static int minNumberOfCoins(int[] c, int i, int sum, Map<Memo, Integer> map) {
		int result = Integer.MAX_VALUE;

		if (sum < 0)
			return Integer.MAX_VALUE;

		if (sum == 0) {
			return 0;
		}

		if (i >= c.length) {
			return Integer.MAX_VALUE;
		}

		if (map.get(new Memo(sum, c[i])) != null) {
			return map.get(new Memo(sum, c[i]));
		}

		int n2 = minNumberOfCoins(c, i, sum - c[i], map);
		int n1 = minNumberOfCoins(c, i + 1, sum, map);

		if (n2 < Integer.MAX_VALUE)
			++n2;

		result = Math.min(n2, n1);


		map.put(new Memo(sum, c[i]), result);

		return result;
	}

}
