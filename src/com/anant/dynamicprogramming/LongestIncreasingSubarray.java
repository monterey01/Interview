package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubarray {
	static int counter = 0;

	public static void main(String args[]) {
		int result = getLongestIncreasingSubarray(new int[] { 1, 3, 2, 3, 4, 8, 7, 9 }, 0, -1, 0, new HashMap<Integer, Integer>());

		if (result > 0)
			++result;
		System.out.println(result);
		System.out.println(counter);

	}

	public static int getLongestIncreasingSubarray(int[] input, int index, int previousIndex, int previousResult,
			Map<Integer, Integer> memoziation) {

		int result = previousResult;

		if (index >= input.length)
			return previousResult;

		if (memoziation.containsKey(index)) {
			return memoziation.get(index);
		}
		++counter;

		int result1 = getLongestIncreasingSubarray(input, index + 1, index,
				(previousIndex != -1 && input[index] > input[previousIndex]) ? previousResult + 1 : 0, memoziation);

		
		result = Math.max(previousResult, result1);
		memoziation.put(index, result);
		return result;
	}

}
