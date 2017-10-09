package com.anant.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
	// Solution to https://leetcode.com/problems/3sum/description/

	static int counter = 0;

	static class Memo {
		// numberOfElements + "," + index + "," + sum +

		int numberOfElements;
		int index;
		int sum;

		public Memo(int numberOfElements, int index, int sum) {

			this.numberOfElements = numberOfElements;
			this.index = index;
			this.sum = sum;

		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + numberOfElements;
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
			if (numberOfElements != other.numberOfElements)
				return false;
			if (sum != other.sum)
				return false;
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 7, 5, -8, -6, -13, 7, 10, 1, 1, -4, -14, 0, -1, -10, 1, -13, -4, 6, -11, 8, -6, 0, 0, -5, 0, 11,
				-9, 8, 2, -6, 4, -14, 6, 4, -5, 0, -12, 12, -13, 5, -6, 10, -10, 0, 7, -2, -5, -12, 12, -9, 12, -9, 6,
				-11, 1, 14, 8, -1, 7, -13, 8, -11, -11, 0, 0, -1, -15, 3, -11, 9, -7, -10, 4, -2, 5, -4, 12, 7, -8, 9,
				14, -11, 7, 5, -15, -15, -4, 0, 0, -11, 3, -15, -15, 7, 0, 0, 13, -7, -12, 9, 9, -3, 14, -1, 2, 5, 2,
				-9, -3, 1, 7, -12, -3, -1, 1, -2, 0, 12, 5, 7, 8, -7, 7, 8, 7, -15 };

		// int[] nums= {-1, 0, 1, 2, -1};

		// int[] nums = { -9, -1, 8, 10, 10 };

		List<List<Integer>> tmpResultList = new ArrayList<List<Integer>>();
		Set<String> uniqueResult = new HashSet<String>();
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		tmpResultList = numberOfCombinationsEqualToZero(nums, 0, 0, 0, new HashMap<Memo, List<List<Integer>>>());

		if (tmpResultList != null) {
			for (List<Integer> result : tmpResultList) {
				Collections.sort(result);
				StringBuilder sb = new StringBuilder();
				for (int value : result) {
					sb.append(value);
				}
				String tmpValue = sb.toString();
				if (!uniqueResult.contains(tmpValue)) {

					uniqueResult.add(tmpValue);
					resultList.add(result);
				}

			}
		}

		System.out.println(uniqueResult);

	}

	public static List<List<Integer>> numberOfCombinationsEqualToZero(int[] nums, int index, int sum,
			int numberOfElements, Map<Memo, List<List<Integer>>> memoization) {

		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		if (numberOfElements == 3 && sum == 0) {
			return new ArrayList<List<Integer>>();

		} else if (numberOfElements == 3 && sum != 0) {

			return null;
		}

		if (index >= nums.length) {

			return null;
		}

		// numberOfElements + "," + index + "," + sum +
		Memo memo = new Memo(numberOfElements, index, sum);

		if (memoization.containsKey(memo)) {
			return memoization.get(memo);
		}
		++counter;

		List<List<Integer>> resultList1 = numberOfCombinationsEqualToZero(nums, index + 1, sum - nums[index],
				numberOfElements + 1, memoization);

		if (resultList1 != null) {
			if (resultList1.isEmpty()) {
				List<Integer> result1 = new ArrayList<Integer>();
				result1.add(nums[index]);
				resultList.add(result1);
			} else {
				for (List<Integer> result : resultList1) {
					List<Integer> result2 = new ArrayList<Integer>(result);
					result2.add(nums[index]);
					resultList.add(result2);
				}
			}
		}

		List<List<Integer>> resultList2 = numberOfCombinationsEqualToZero(nums, index + 1, sum, numberOfElements,
				memoization);

		if (resultList2 != null) {
			for (List<Integer> result : resultList2) {
				List<Integer> result2 = new ArrayList<Integer>(result);
				resultList.add(result2);
			}
		}

		resultList = resultList.size() == 0 ? null : resultList;

		memoization.put(memo, resultList);

		return resultList;
	}

}
