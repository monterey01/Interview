package com.anant.string;

import java.util.Scanner;

//Solution for https://www.hackerrank.com/challenges/funny-string
public class FunnyString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();

		while (sc.hasNext()) {
			System.out.println(isFunny(sc.next()));
		}

		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
	}

	private static String isFunny(String s) {

		// acxz

		// zxca

		// Original String
		StringBuilder sb1 = new StringBuilder(s);

		// Reverse String
		StringBuilder sb2 = new StringBuilder();

		char[] c = s.toCharArray();
		for (int i = c.length - 1; i > -1; i--) {
			sb2.append(c[i]);
		}

		for (int i = 0; i < sb1.length(); i++) {

			if (i + 1 < sb1.length()) {

				int diff1 = sb1.charAt(i) - sb1.charAt(i + 1);

				if (diff1 < 0)
					diff1 = diff1 * -1;

				int diff2 = sb2.charAt(i) - sb2.charAt(i + 1);

				if (diff2 < 0)
					diff2 = diff2 * -1;

				if (diff1 != diff2) {
					return "Not Funny";
				}
				
			}

		}
		return "Funny";
	}
}
