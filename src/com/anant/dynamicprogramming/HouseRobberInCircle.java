package com.anant.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobberInCircle {
	static int counter = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 1 };
		int start = 0;
		int end = 0;

		int result1 = 0;

		if (a.length > 1) {
			start = 0;
			end = a.length - 2;
		} else {
			start = 0;
			end = 0;
		}

		result1 = findMaxRobbedMoney(Arrays.copyOfRange(a, start, end + 1), 0, new HashMap<Integer, Integer>());

		int result2 = 0;

		if (a.length > 1) {
			start = 1;
			end = a.length;
			result2 = findMaxRobbedMoney(Arrays.copyOfRange(a, start, end), 0, new HashMap<Integer, Integer>());
		}

		System.out.println(Math.max(result1, result2));

	}

	public static int findMaxRobbedMoney(int[] input, int index, Map<Integer, Integer> memoization) {

		if (index >= input.length)
			return 0;

		if (memoization.containsKey(index)) {
			return memoization.get(index);
		}

		int result = Math.max(input[index] + findMaxRobbedMoney(input, index + 2, memoization),
				findMaxRobbedMoney(input, index + 1, memoization));
		memoization.put(index, result);

		System.out.println(result);
		;
		return result;

	}

}
