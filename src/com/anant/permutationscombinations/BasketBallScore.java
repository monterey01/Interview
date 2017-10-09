package com.anant.permutationscombinations;

public class BasketBallScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getCombinations(new int[] { 1, 1, 1, 1, 1 });
	}
	// 1,1,1,1
	// 0,2,1,1

	public static void getCombinations(int input[]) {

		printArray(input);

		for (int i = input.length - 1; i > -1; i--) {
			if ((i - 1 > -1 && input[i-1]!=3)) {
				int tmpValue = input[i];
				++input[i - 1];
				--input[i];

				if (tmpValue == 3 && i!=0) {

					input[i] = 1;
					for (int j = i + 1; j < input.length; j++) {
						if (input[j] == 0) {
							input[j] = 1;
							i = j;
							break;
						}
					}
				}

				if (input[i] > 0)
					++i;
				printArray(input);

			}
		}

	}

	public static void printArray(int[] i) {

		for (int value : i) {
			if (value != 0)
				System.out.print(value + " ");
		}
		System.out.println();

	}

}
