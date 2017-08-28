package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(maxSum(new int[] { 9, 4, 4, 9, 4, 9, 9, 9, 9 }, 0, 10, 0, new HashMap<Memo, Integer>()));

	}

	static class Memo {
		int index;
		int previousSum;

		public Memo(int index, int previousSum) {
			this.index = index;
			this.previousSum = previousSum;
		}

		@Override
		public boolean equals(Object obj) {
			Memo memo = (Memo) obj;

			if (memo.index == this.index && memo.previousSum == previousSum)
				return true;

			return false;

		}

		@Override
		public int hashCode() {
			int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + previousSum;

			return result;
		}

	}

	public static int maxSum(int[] elements, int index, int sum, int previousResult, Map<Memo, Integer> memoziation) {

		if (previousResult == sum) {
			return -1;
		}

		if (previousResult > sum) {
			return -2;
		}

		if (index >= elements.length && previousResult < sum) {
			return -2;
		}

		if (index >= elements.length && previousResult > sum) {
			return 0;
		}

		if (memoziation.containsKey(new Memo(index, previousResult)))

		{
			return memoziation.get(new Memo(index, previousResult));
		}

		int tmpResult2 = maxSum(elements, index, sum, previousResult + elements[index], memoziation);

		if (tmpResult2 == -1) {
			tmpResult2 = previousResult + elements[index];
		} else if (tmpResult2 == -2) {
			tmpResult2 = previousResult;
		}

		int tmpResult1 = maxSum(elements, index + 1, sum, previousResult, memoziation);

		int result = Math.max(tmpResult1, tmpResult2);

		memoziation.put(new Memo(index, previousResult), result);

		return result;
	}

}
