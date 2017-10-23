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

		System.out.println(validIPAddress("2001:05a3:85a3:8A2E:8A2E:3370:7334"));

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
	
	

	public  static String validIPAddress(String IP) {

		// Check if

		if (isIP4Address(IP))
			return "IPv4";
		if (isIP6Address(IP))
			return "IPv6";

		return "";

	}

	private static boolean isIP4Address(String IP) {
		String[] ip4ca = IP.split("\\.");

		if (ip4ca.length == 4) {
			for (int i = 0; i < ip4ca.length; i++) {
				boolean hasNonZero = false;

				char[] tmpca = ip4ca[i].toCharArray();
				if (tmpca.length == 0)
					return false;
				int j = 0;
				while (j < tmpca.length) {
					if (!(Character.isDigit(tmpca[j])))
						return false;
					if (tmpca[j] != '0')
						hasNonZero = true;
					if (tmpca[j] == '0' && !hasNonZero)
						return false;

					j++;
				}

				if (!(Integer.parseInt(ip4ca[i]) > -1 && Integer.parseInt(ip4ca[i]) < 256))
					return false;
				if (i == 3)
					return true;
			}
		}
		return false;

	}

	private static boolean isIP6Address(String IP) {
		String[] ip6ca = IP.split("\\:");

		if (ip6ca.length == 7) {

			for (int i = 0; i < ip6ca.length; i++) {
				boolean hasNonZero = false;
				char[] tmpca = ip6ca[i].toCharArray();

				if (tmpca.length == 0)
					return false;
				int j = 0;
				while (j < tmpca.length) {
					char c = tmpca[j];
					c = Character.toLowerCase(c);

					if (!(Character.isDigit(c) || c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e'))
						return false;
					if (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || (Character.isDigit(c) && c!='0'))
						hasNonZero = true;

					if (tmpca[j] == '0' && !hasNonZero)
						return false;
					++j;
				}

				if (i == 6)
					return true;
			}

		}
		return false;

	}

}
