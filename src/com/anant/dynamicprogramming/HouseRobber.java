package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
	static int counter = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				findMaxRobbedMoney(new int[] { 1500, 15000, 1, 200, 400000 ,900000}, 0, new HashMap<Integer, Integer>()));
		System.out.println(counter);

	}

	public static int findMaxRobbedMoney(int[] input, int index, Map<Integer, Integer> memoization) {

		if (index >= input.length)
			return 0;

		if (memoization.get(index) != null) {
			return memoization.get(index);
		}

		++counter;
		int result = Math.max(input[index] + findMaxRobbedMoney(input, index + 2, memoization),
				findMaxRobbedMoney(input, index + 1, memoization));
		memoization.put(index, result);

		return result;

	}

}
