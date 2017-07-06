package com.anant.lowleveloperators;

public class bitwise {

	public static void main(String args[]) {

		System.out.println(additionBitwise(2, 4));

		int[] i = { 2, 8, 9, 8, 2, 9, 10 };

		System.out.println(nonDuplicateNumber(i));
		System.out.println(square(2));

	}

	public static int additionBitwise(int i, int j) {

		return i | j;
	}

	public static int nonDuplicateNumber(int a[]) {
		int result = 0;

		for (int j = 0; j < a.length; j++) {
			result = result ^ a[j];
		}

		return result;
	}

	public static int square(int i) {

		return 1 << i;
	}

}
