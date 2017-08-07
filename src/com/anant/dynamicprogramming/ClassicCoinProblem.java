package com.anant.dynamicprogramming;

public class ClassicCoinProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coinChange(new int[] { 3,7,405,436 }, 8839));

	}
	class Memo{
		int sum;
		
		int index;
		
		int depth;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + depth;
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (depth != other.depth)
				return false;
			if (index != other.index)
				return false;
			if (sum != other.sum)
				return false;
			return true;
		}

		private ClassicCoinProblem getOuterType() {
			return ClassicCoinProblem.this;
		}
		
		
		
	}

	public static int coinChange(int[] coins, int amount) {
		int result= minNumberOfCoins(coins, amount, 0, 0);
		
		return result;
	}

	public static int minNumberOfCoins(int[] c, int sum, int index, int depth) {

		int result = Integer.MAX_VALUE;
		if (sum < 0) {
			return -1;
		}
		if (sum == 0) {
			return depth;
		}
		if (index >= c.length) {
			return -1;
		}

		int n1 = minNumberOfCoins(c, sum, index + 1, depth);

		if (n1 == -1)
			n1 = Integer.MAX_VALUE;
		int n2 = minNumberOfCoins(c, sum - c[index], index + 1, depth + 1);

		int n3 = minNumberOfCoins(c, sum - c[index], index, depth + 1);

		if (n3 == -1)
			n3 = Integer.MAX_VALUE;

		if (n2 == -1)
			n2 = Integer.MAX_VALUE;

		result = Math.min(n1, n2);
		result = Math.min(result, n3);

		if (result == Integer.MAX_VALUE)
			result = -1;

		return result;
	}

}
