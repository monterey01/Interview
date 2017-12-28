package com.anant.binarysort;

public class SearchRotatedArray {

	public static void main(String args[]) {
		System.out.println(search(new int[] { 6,7,8,1,2,3,4,5}, 5));
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int pp = findPivotPoint(nums, 0, nums.length - 1, target);
		System.out.println(pp);
		if (pp == -1) {
			System.out.print("me here");
			return binarySearch(nums, 0, nums.length - 1, target);
		} else {

			if (target == nums[pp])
				return pp;

			if (target >= nums[0]) {
				System.out.print("i am here");
				return binarySearch(nums, 0, pp, target);
			} else {
				System.out.print("i am here2->" + pp);
				int result = binarySearch(nums, pp + 1, nums.length - 1, target);
				return result;
			}

		}

	}

	public static int findPivotPoint(int[] nums, int s, int e, int target) {

		if (s > e)
			return -1;

		int mid = (s + e) / 2;

		if (mid + 1 < nums.length && nums[mid] > nums[mid + 1])
			return mid;
		if (nums[mid] < nums[s])
			return findPivotPoint(nums, s, mid - 1, target);
		if (nums[mid] > nums[e])
			return findPivotPoint(nums, mid + 1, e, target);

	return -1;
	}

	public static int binarySearch(int[] nums, int s, int e, int target) {
		System.out.println("s-> " + s + " e->" + e);
		if (s > e)
			return -1;

		int mid = (s + e) / 2;
		// 2 4 5 6 7 0 1
		// 7,1,2,3,4,5,6

		// 1,2,3,4,5,6,7
		if (nums[mid] == target)
			return mid;
		if (target < nums[mid])
			return binarySearch(nums, s, mid - 1, target);
		if (target > nums[mid])
			return binarySearch(nums, mid + 1, e, target);

		return -1;
	}
}
