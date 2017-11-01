package com.anant.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubSequence {
	static int counter = 0;

	public static void main(String args[]) {
		int[][] m=new int[8][8];

		for (int i = 0; i < m.length; i++) {
			Arrays.fill(m[i],Integer.MIN_VALUE);
		}
		

		int result = getLongestIncreasingSubSeq(new int[] { 10,9,2,5,3,7,101,18}, 0, -1, m);


		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
					System.out.print(m[i][j] +",");
			}
			System.out.println();
		}
		
		System.out.println(result);
		System.out.println(counter);

	}

	public static int getLongestIncreasingSubSeq(int[] input, int i, int j, int[][] m) {

		int result = 0;

		if (i == input.length)
			return 0;

		int result1 = 0;
		int result2 = 0;


		int jValue=(j==-1)?i:j;
		if(m[i][jValue]!=Integer.MIN_VALUE) {
			return m[i][jValue];
		}
		
		++counter;
		
		if (j==-1||input[i] > input[j])
			result2 = 1 + getLongestIncreasingSubSeq(input, i + 1, i, m);

		result1 = getLongestIncreasingSubSeq(input, i + 1, j, m);

		result = Math.max(result1, result2);

		m[i][jValue]=result;
		return result;
	}

}
