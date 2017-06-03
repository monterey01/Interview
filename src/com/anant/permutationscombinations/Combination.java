package com.anant.permutationscombinations;

import java.util.*;

public class Combination {

	public void combinationEasy(char[] input) {
		List<Character> r = new ArrayList<>();
		combinationEasy(input, 0, r);
	}

	private void combinationEasy(char[] input, int pos, List<Character> r) {

		r.forEach(r1 -> System.out.print(r1 + " "));
		System.out.println();
		for (int i = pos; i < input.length; i++) {

			r.add(input[i]);
			combinationEasy(input, i + 1, r);
			r.remove(r.size() - 1);
		}
	}

	public static void main(String args[]) {
		Combination c = new Combination();
		// c.combination("abcd".toCharArray());
		c.combinationEasy("abcd".toCharArray());

	}

}
// 3,5,8,16
