package com.anant.numbertheory;

public class IsPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPrime(37));

	}

	private static boolean isPrime(int n) {

		if (n % 2 == 0)
			return false;

		for (int i = 3; i < n; i = i + 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}
