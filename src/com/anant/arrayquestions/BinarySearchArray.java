package com.anant.arrayquestions;

public class BinarySearchArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchSortedArray(new int[] { 1, 2, 3, 4, 5, 6 }, 5));
	}

	// 1,2,3,4,5,6,7
	public static int searchSortedArray(int[] input, int value) {
		int result = -1;
		int midIndex = getmidIndex(0, input.length - 1);

		while (midIndex > -1) {
			if (input[midIndex] == value)
				return midIndex;
			if (midIndex - 1 >= 0 && input[midIndex - 1] == value)
				return midIndex - 1;
			if (midIndex + 1 < input.length && input[midIndex + 1] == value)
				return midIndex + 1;
			if (value > input[midIndex])
				midIndex = getmidIndex(midIndex + 1, input.length - 1);
			else {
				midIndex = getmidIndex(0, midIndex - 1);
			}

		}

		return result;
	}

	public static int getmidIndex(int start, int end) {

		if (start > end)
			return -1;
		return (start + end) / 2;

	}

}
