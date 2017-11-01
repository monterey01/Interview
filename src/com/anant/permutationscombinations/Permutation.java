package com.anant.permutationscombinations;

public class Permutation {

	public static void permute(char[] c, int si) {

		if (si + 1 == c.length) {

			System.out.println(String.valueOf(c));
		}

		for (int i = si; i < c.length; i++) {

			swap(c, si, i);
			permute(c, si + 1);
			swap(c, si, i);
		}
		
	}

	private static char[] swap(char[] s, int i, int j) {

		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;

		return s;

	}

	// ABCD

	public static void main(String[] args) {

		System.out.println(System.currentTimeMillis());
		permute("ABCD".toCharArray(), 0);
		System.out.println(System.currentTimeMillis());

	}

}
