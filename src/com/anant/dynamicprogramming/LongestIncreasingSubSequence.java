package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubSequence {
	static int counter = 0;

	public static void main(String args[]) {
		int result = getLongestIncreasingSubarray(new int[] { 1, 7, 2, 3, 4, 8,}, 0, -1, new HashMap<Integer, Integer>());

		if (result > 0)
			++result;
		System.out.println(result);
		System.out.println(counter);

	}

	public static int getLongestIncreasingSubarray(int[] input, int index, int previousIndex,
			Map<Integer, Integer> memoziation) {

		int result = 0;

		if (index >= input.length)
			return 0;

		if (memoziation.containsKey(index)) {
			return memoziation.get(index);
		}
		++counter;

		int result1 = 0;
		int result2 = 0;

		if (previousIndex == -1 || input[index] - input[previousIndex] == 1) {

			result2 = getLongestIncreasingSubarray(input, index + 1, index, memoziation);
			if (result2 > 0)
				++result2;
			if (previousIndex != -1 && result2 == 0 && input[index] - input[previousIndex] == 1)
				++result2;

		}

		result1 = getLongestIncreasingSubarray(input, index + 1, index, memoziation);

		result = Math.max(result1, result2);

		memoziation.put(index, result);
		return result;
	}

}
