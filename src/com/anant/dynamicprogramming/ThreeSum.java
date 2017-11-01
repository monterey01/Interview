package com.anant.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	// Solution to https://leetcode.com/problems/3sum/description/

	public static void main(String args[]) {

		List<Integer> ls = new LinkedList<Integer>();
		threeSum(new int[] { 1, 2, 2, 5, 7, 8 });
		System.out.println(ls);

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int remaining = 0 - nums[i];
			int j = i + 1;
			int k = nums.length - 1;

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			while (j < k) {

				if (nums[j] + nums[k] == remaining) {
					resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));
					++j;
					--k;
					while (j < k && nums[j] == nums[j - 1])
						j++; // skip same result
					while (j < k && nums[k] == nums[k + 1])
						k--; // skip same result
				} else if (nums[j] + nums[k] > remaining) {
					--k;
				} else {
					++j;
				}
			}

		}

		return resultList;
	}

}
