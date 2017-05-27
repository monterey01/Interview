package com.anant.dynamicprogramming;

public class MaximumPathSum {
	
	//Solution to http://www.mathblog.dk/project-euler-18/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] i = new int[4][4];
		i[0][0] = 3;
		i[0][1] = 0;
		i[0][2] = 0;
		i[0][3] = 0;

		i[1][0] = 7;
		i[1][1] = 4;
		i[1][2] = 0;
		i[1][3] = 0;

		i[2][0] = 2;
		i[2][1] = 4;
		i[2][2] = 6;
		i[2][3] = 0;

		i[3][0] = 20;
		i[3][1] = 5;
		i[3][2] = 9;
		i[3][3] = 3;

		System.out.println(bruteForceMaxSumPath(i, 0, 0, 0));

	}

	public static int bruteForceMaxSumPath(int[][] i, int r, int pc, int ps) {

		int result = 0;

		if (r > i.length - 1) {
			return ps;
		} else {

			int startIndex = 0;
			int endIndex = 0;

			if (r != 0) {
				startIndex = pc;
				endIndex = pc + 1;
			}

			for (int j = startIndex; j <= endIndex && endIndex < i[0].length && i[r][j] > 0; j++) {
				int sum = 0;
				sum = bruteForceMaxSumPath(i, r + 1, j, ps + i[r][j]);
				sum = Math.max(sum, result);
				result = sum;
			
			}
		}

		return result;
	}
}
