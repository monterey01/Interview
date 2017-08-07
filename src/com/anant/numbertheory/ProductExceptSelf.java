package com.anant.numbertheory;

//Solution to https://codefights.com/interview-practice/task/gxzW6jpXXkr3JNwXy
public class ProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(productExceptSelf(new int[] { 1, 2, 3, 4 }, 12));
	}

	static int productExceptSelf(int[] arr, int m) {

		int product = 1;
		int n = arr.length;
		int left[] = new int[n];
		int right[] = new int[n];

		int i, j;

		/* Left most element of left array is always 1 */
		left[0] = 1;

		/* Rightmost most element of right array is always 1 */
		right[n - 1] = 1;

		/* Construct the left array */
		for (i = 1; i < n; i++)
			left[i] = arr[i - 1] * left[i - 1] % m;

		/* Construct the right array */
		for (j = n - 2; j >= 0; j--)
			right[j] = arr[j + 1] * right[j + 1] % m;

		/*
		 * Construct the product array using left[] and right[]
		 */
		for (i = 0; i < n; i++)
			arr[i] = left[i] * right[i] % m;

		int sum = 0;

		for (int l = 0; l < arr.length; l++) {

			sum += arr[l];
		}

		return sum % m;
	}

}
