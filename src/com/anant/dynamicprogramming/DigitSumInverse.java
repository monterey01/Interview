package com.anant.dynamicprogramming;

public class DigitSumInverse {

	// Solution to
	// https://codefights.com/tournaments/od2Ak2LGvpg7dw6Aj/D/solutions/ARa39z9MpE8veoh66

	public static void main(String args[]) {

		// System.out.println(digitSumInverse(5, 1));
		System.out.println(digitSumInverse(5, 2));

	}

	public static int digitSumInverse(int sum, int numberLength) {

		if (sum == 0 && numberLength == 0)
			return 1;
		if (numberLength == 0)
			return 0;

		int result = 0;

		for (int k = 0; k < 10; k++) {
			if (sum - k >= 0) {
				result+=digitSumInverse(sum - k,numberLength-1);
			
			}
		}

		return result;

	}

}

/*
 * 10^2 =100 5 14 23 32 41 50
 **/