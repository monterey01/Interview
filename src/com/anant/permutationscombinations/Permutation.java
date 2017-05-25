package com.anant.permutationscombinations;

import java.util.LinkedList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {

		System.out.println(System.currentTimeMillis());
		permute("ABCD".toCharArray(), 0, "ABCD".length() - 1);
		System.out.println(System.currentTimeMillis());

	}

	/**
	 * permutation function
	 * 
	 * @param str
	 *            string to calculate permutation for
	 * @param l
	 *            starting index
	 * @param r
	 *            end index
	 */

	// bc
	// abc
	public static void permute(char c[], int i1, int i2) {
		if (i1 == i2) {
			System.out.println(String.valueOf(c));
		} else {

			for (int i = i1; i <= i2; i++) {
				c=swap(c, i, i1);
				permute(c, i1 + 1, i2);
				c = swap(c, i, i1);

			}
		}

	}

	public static char[] swap(char c[], int i1, int i2) {
		if (!(i1 == i2)) {
			char temp = c[i1];
			c[i1] = c[i2];
			c[i2] = temp;
		}
		return c;
	}
}
