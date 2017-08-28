package com.anant.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

	public static void main(String args[]) {

		System.out.println(climbingStairs(20,  new HashMap<Integer, Integer>()));

	}

	static int climbingStairs(int n,  Map<Integer, Integer> memoziation) {

		int result = 0;

		if (memoziation.containsKey(n)) {
			return memoziation.get(n);
		}

		if (n == 2)
			return 2;
		if (n == 1)
			return 1;

		result += climbingStairs(n - 2, memoziation);
		result += (climbingStairs(n - 1, memoziation));

		memoziation.put(n, result);
		return result;
	}

}
