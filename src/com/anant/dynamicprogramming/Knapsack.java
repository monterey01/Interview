package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nItems = 4;
		int knapsackSize = 10;
		int weights[] = new int[] { 5, 4, 6, 3 };
		int values[] = new int[] { 10, 40, 30, 50 };

		System.out.println(knapsack(nItems - 1, knapsackSize, weights, values));

	}

	static int matrix[][] = new int[100][100];

	static int knapsack(int index, int size, int weights[], int values[]) {
		int take, dontTake;
		
		if(index<0 || index >=weights.length) return 0;

		take = dontTake = 0;

		if (weights[index] <= size)
			take = values[index] + knapsack(index - 1, size - weights[index], weights, values);

		dontTake = knapsack(index - 1, size, weights, values);

		matrix[index][size] = Math.max(take, dontTake);

		return matrix[index][size];

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

		int tmpResult1 = maxSum(elements, index + 1, sum, previousResult, memoziation);

		if (tmpResult2 == -1) {
			tmpResult2 = previousResult + elements[index];
		} else if (tmpResult2 == -2) {
			tmpResult2 = previousResult;
		}

		int result = Math.max(tmpResult1, tmpResult2);

		memoziation.put(new Memo(index, previousResult), result);

		return result;
	}

}
