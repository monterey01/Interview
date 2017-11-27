package com.anant.arrayquestions;

public class BinarySearchArray {
	static int[] a = new int[] { 1, 5, 6, 7, 8, 15, 20, 29, 30, 35 };

	public static void main(String args[]) {
		System.out.println(binarySearch(a, 0, a.length - 1, 35));
	}

	public static int binarySearch(int[] a, int s, int e, int i) {

		int mid = (s + e) / 2;
		if (a[mid] == i)
			return mid;
		if (i < a[mid])
			return binarySearch(a, s, mid - 1, i);
		if (i > a[mid])
			return binarySearch(a, mid + 1, e, i);

		return -1;
	}
}
