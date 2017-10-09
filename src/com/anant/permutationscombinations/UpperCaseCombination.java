package com.anant.permutationscombinations;

public class UpperCaseCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printUpperCaseCombination("a1bc".toCharArray(), 0, false);
	}

	// ab
	public static void printUpperCaseCombination(char[] input, int index, boolean upperCase) {
		if (index >= input.length) {
			if (upperCase) {

				for (char c : input) {
					System.out.print(c);
				}
				System.out.println();

			}
			return;
		}

		char tmpChar = input[index];
		printUpperCaseCombination(input, index + 1, upperCase);

		if (!Character.isDigit(tmpChar)) {
			upperCase = true;
			input[index] = Character.toUpperCase(tmpChar);
			printUpperCaseCombination(input, index + 1, upperCase);
		}

		input[index] = tmpChar;
	}

}
