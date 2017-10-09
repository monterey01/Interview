package com.anant.bstquestions.graphs;

public class KnightMovesOnTelephonePad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[][] = new int[4][3];
		input[3][0] = -1;
		input[3][2] = -1;
		System.out.println(numberOfways(input, 1, 0));

	}

	// X X X
	// X X X
	// X X X
	// Y X Y

	public static int numberOfways(int[][] input, int startRow, int startCol) {

		System.out.println(startRow + "," + startCol);

		input[startRow][startCol] = -1;

		// Go 8 ways

		int result = 0;
		
		if (isValidPath(input, startRow + 1, startCol) && isValidPath(input, startRow + 2, startCol)) {
			if (isValidPath(input, startRow + 2, startCol - 1)) {
	
				result += isVisited(input, startRow + 2, startCol - 1) ? 0
						: numberOfways(input, startRow + 2, startCol - 1)+1;
			}
			if (isValidPath(input, startRow + 2, startCol + 1)) {
	
				result += isVisited(input, startRow + 2, startCol + 1) ? 0
						: numberOfways(input, startRow + 2, startCol + 1)+1;
			}
		}
		
		if (isValidPath(input, startRow, startCol + 1) && isValidPath(input, startRow, startCol + 2)) {
			if (isValidPath(input, startRow - 1, startCol + 2)) {
	
				result += isVisited(input, startRow - 1, startCol + 2) ? 0
						: numberOfways(input, startRow - 1, startCol + 2)+1;
			}
			if (isValidPath(input, startRow + 1, startCol + 2)) {
	
				result += isVisited(input, startRow + 1, startCol + 2) ? 0
						: numberOfways(input, startRow + 1, startCol + 2)+1;
			}
		}
		
		if (isValidPath(input, startRow, startCol - 1) && isValidPath(input, startRow, startCol - 2)) {
			if (isValidPath(input, startRow - 1, startCol - 2)) {
	
				result += isVisited(input, startRow - 1, startCol - 2) ? 0
						: numberOfways(input, startRow - 1, startCol - 2)+1;
			}
			if (isValidPath(input, startRow + 1, startCol - 2)) {
	
				result += isVisited(input, startRow + 1, startCol - 2) ? 0
						: numberOfways(input, startRow + 1, startCol - 2)+1;
			}
		}

		// top

		if (isValidPath(input, startRow - 1, startCol) && isValidPath(input, startRow - 2, startCol)) {
			if (isValidPath(input, startRow - 2, startCol - 1)) {
			
				result += isVisited(input, startRow - 2, startCol - 1) ? 0
						: numberOfways(input, startRow - 2, startCol - 1)+1;
			}
			if (isValidPath(input, startRow - 2, startCol + 1)) {
	
				result += isVisited(input, startRow - 2, startCol + 1) ? 0
						: numberOfways(input, startRow - 2, startCol + 1)+1;
			}
		}

		return result;
	}

	private static boolean isValidPath(int[][] input, int row, int col) {

		if (!(row == 3 && (col == 0 || col == 2))) {
			if (!(row < 0) && !(row >= input.length) && !(col < 0) && !(col > 2)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isVisited(int[][] input, int row, int col) {

		if (input[row][col] == -1)
			return true;

		return false;
	}
}
