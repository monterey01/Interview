package com.anant.numbertheory;

import java.util.ArrayList;
import java.util.List;

public class ArthmeticExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processArthmeticExpression(new int[] { 2, 4, 6, 10 }, 0, Character.MIN_VALUE, 0, 0, new StringBuilder());
	}

	// 1*2

	// 2+4+6
	// 2*4*6
	// 2+4*6
	// 2*4+6

	public static void processArthmeticExpression(int[] input, int index, char expression, int additionalSum,
			int productDivision, StringBuilder sb) {

		if (index >= input.length) {
			System.out.print(sb + "->");
			System.out.print(additionalSum + productDivision);
			System.out.println();
			return;

		}

		else {

			if (!(index + 1 >= input.length && expression != '+')) {
				StringBuilder tmpsb1 = new StringBuilder(sb);
				tmpsb1.append(input[index] + "+");
				int tmpAdditionalSum1 = 0;
				int tmpProductDivision1 = 0;

				if (expression == '*') {
					tmpAdditionalSum1 = productDivision * input[index] + additionalSum;
					tmpProductDivision1 = 0;

				} else if (expression == '+') {
					tmpAdditionalSum1 = additionalSum + input[index] + productDivision;
					tmpProductDivision1 = 0;

				} else if (expression == '-') {
					tmpAdditionalSum1 = input[index] - additionalSum + productDivision;
					tmpProductDivision1 = 0;

				} else if (expression != '*' || expression != '+') {
					tmpAdditionalSum1 = input[index];
					tmpProductDivision1 = 0;
				}

				processArthmeticExpression(input, index + 1, '+', tmpAdditionalSum1, tmpProductDivision1, tmpsb1);
			}

			if (!(index + 1 >= input.length && expression != '*')) {
				StringBuilder tmpsb1 = new StringBuilder(sb);
				tmpsb1.append(input[index] + "*");

				int tmpAdditionalSum2 = 0;
				int tmpProductDivision2 = 0;

				if (expression == '*') {
					tmpProductDivision2 = productDivision * input[index];
					tmpAdditionalSum2 = additionalSum;

				} else if (expression == '+') {
					tmpAdditionalSum2 = additionalSum;
					tmpProductDivision2 = input[index];

				}

				else if (expression == '-') {
					tmpAdditionalSum2 = -1 * additionalSum;
					tmpProductDivision2 = input[index];
				}

				else if (expression != '*' || expression != '*') {
					tmpAdditionalSum2 = additionalSum;
					tmpProductDivision2 = input[index];
				}

				processArthmeticExpression(input, index + 1, '*', tmpAdditionalSum2, tmpProductDivision2, tmpsb1);
			}

		}
	}
}

// 2+5*7