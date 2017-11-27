package com.anant.string;

import java.util.HashSet;
import java.util.Set;

public class NormalizePath {

	public static void main(String[] args) {
		System.out.println("\\a\\b\\c\\..\\file.txt");
		rd("\\a\\b\\c\\..\\..\\.\\file.txt");
	}

	public static void rd(String in) {
		char[] ca = in.toCharArray();
		int e = -1;

		for (int i = 0; i < ca.length; i++) {
			if (i == e)
				break;
			if (ca[i] == '\\' && (i + 2) < ca.length && ca[i + 1] == '.' && ca[i + 2] == '.') {
				int j = fls(ca, i);
				for (int k = j; k <= i + 2; k++) {
					r(ca, j, e == -1 ? ca.length - 1 : --e);
				}
				i = --j;

			} else if (ca[i] == '\\' && (i + 1) < ca.length && ca[i + 1] == '.') {
				for (int k = i; k <= i + 1; k++) {
					r(ca, i, e == -1 ? ca.length - 1 : --e);
				}
				--i;
			}
		}

		System.out.println(ca);
	}

	public static int fls(char[] ca, int i) {
		while (i - 1 > -1) {
			i = i - 1;
			if (ca[i] == '\\')
				return i;
		}

		return -1;

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
