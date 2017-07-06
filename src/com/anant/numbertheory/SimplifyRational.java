package com.anant.numbertheory;

public class SimplifyRational {

	// Solution to
	// https://codefights.com/interview-practice/task/Q9iGesadet3hNj2qo
	public static void main(String[] args) {
		
		
		
		System.out.println(5%2);
		// TODO Auto-generated method stub
		simplifyRational(-18, 24);

	}

	static int[] simplifyRational(int numerator, int denominator) {
		int[] result = new int[2];
		int multiplier = 1;

		if (numerator < 0 && denominator < 0) {
			numerator = numerator * -1;
			denominator = denominator * -1;

		} else if (numerator < 0) {
			numerator = numerator * -1;
			multiplier = -1;
		} else if (denominator < 0) {
			denominator = denominator * -1;
			multiplier = -1;
		}

		int sn = Math.min(numerator, denominator);

		for (int i1 = sn; i1 > 1; i1--) {

			if (((numerator % i1) == 0) && ((denominator % i1) == 0)) {
				numerator = numerator / i1;
				denominator = denominator / i1;

			}

		}

		if (numerator == 0)
			denominator = 1;

		result[0] = numerator * multiplier;
		result[1] = denominator;

		return result;
	}

}
