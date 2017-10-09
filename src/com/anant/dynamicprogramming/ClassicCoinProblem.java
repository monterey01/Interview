package com.anant.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

		System.out.println(minNumberOfCoins(new int[] { 1, 2, 5 }, 10));
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

	public static List<Integer> getListMinNumberOfCoins(int[] c, int i, int sum, Map<Memo, List<Integer>> map) {

		if (sum < 0 || i >= c.length)
			return null;

		if (sum == 0) {
			return new ArrayList<Integer>();
		}

		Memo memo = new Memo(i, sum);

		if (map.containsKey(memo)) {
			return map.get(memo);
		}

		List<Integer> n2 = getListMinNumberOfCoins(c, i, sum - c[i], map);
		List<Integer> n1 = getListMinNumberOfCoins(c, i + 1, sum, map);

		if (n1 == null && n2 == null) {
			map.put(memo, null);
			return null;
		}

		if ((n1 == null && n2 != null)) {
			List<Integer> tmpList = new ArrayList<Integer>(n2);
			tmpList.add(0, c[i]);
			map.put(memo, tmpList);
			return tmpList;
		}
		if (n1 != null && n2 == null) {
			map.put(memo, n1);
			return n1;
		}

		if ((n2.size() < n1.size())) {
			List<Integer> tmpList = new ArrayList<Integer>(n2);
			tmpList.add(0, c[i]);
			map.put(memo, tmpList);
			return tmpList;
		}

		if ((n1.size() < n2.size()) || (n2.size() == n1.size())) {
			map.put(memo, n1);
			return n1;
		}

		map.put(memo, null);
		return null;

	}

}
