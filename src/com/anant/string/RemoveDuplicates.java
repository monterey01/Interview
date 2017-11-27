package com.anant.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println("helllo");
		rd("hello");
	}

	public static void rd(String in) {
		char[] ca = in.toCharArray();
		Set<Character> s = new HashSet<Character>();
		int j = -1;

		for (int i = 0; i < ca.length; i++) {
			if (j == i)
				break;
			if (!s.contains(ca[i])) {
				s.add(ca[i]);
			} else {
				r(ca, i, j == -1 ? ca.length - 1 : --j);
				--i;
			}
		}

		System.out.print(new String(ca));
	}

	public static void r(char[] ca, int p, int j) {
		for (int i = p; i < ca.length; i++) {
			if (j == i) {
				ca[i] = Character.MIN_VALUE;
				break;
			}

			if (i + 1 < ca.length)
				ca[i] = ca[i + 1];
		}
	}

}
