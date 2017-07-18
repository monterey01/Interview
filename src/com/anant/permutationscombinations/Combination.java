package com.anant.permutationscombinations;

import java.util.*;

public class Combination {

	public void combinationEasy(char[] input) {
		List<Character> r = new ArrayList<>();
		r=combinationEasy(input, 0, r);
		r.forEach(r1 -> System.out.print(r1 + " "));
		System.out.println();
	}

	private List<Character> combinationEasy(char[] input, int pos, List<Character> r) {

		for (int i = pos; i < input.length; i++) {

			r.add(input[i]);
			r = combinationEasy(input, i + 1, r);

			r.forEach(r1 -> System.out.print(r1 + " "));
			System.out.println();

			r.remove(r.size() - 1);
		}

		return r;

	}

	public static void main(String args[]) {
		Combination c = new Combination();
		// c.combination("abcd".toCharArray());
		c.combinationEasy("123".toCharArray());

	}

}
// 3,5,8,16
