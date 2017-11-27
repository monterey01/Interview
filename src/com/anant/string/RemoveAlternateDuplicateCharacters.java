package com.anant.string;

import java.util.HashSet;
import java.util.Set;

//Solution to Remove Alternate Duplicate characters from a char array you have to do it in Place.Like keeping only the odd occurences of each character.
public class RemoveAlternateDuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] result = remAltDrop("you got beautiful eyes");
		System.out.println(new String(result));
	}

	public static char[] remAltDrop(String in) {
		char[] ca = in.toCharArray();
		Set<Character> s = new HashSet<Character>();
		int j = -1;
		for (int i = 0; i < ca.length; i++) {
			if (j != -1 && j == i)
				break;
			if (s.contains(ca[i])) {
				if (j == -1) {
					j = ca.length - 1;

				} else {
					--j;
				}
				s.remove(ca[i]);

				mp(ca, i, j);
				--i;

			} else {
				s.add(ca[i]);
			}
		}

		return ca;
	}

	// you got beautiful eyes
	// you gtbeaiful es

	public static void mp(char[] ca, int in, int j) {

		for (int i = in; i < ca.length; i++) {
			if (j == i) {
				ca[i] = Character.MIN_VALUE;
				break;
			}
			if (i + 1 < ca.length)
				ca[i] = ca[i + 1];
		}

		System.out.println(new String(ca));
	}
}
