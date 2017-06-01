package com.anant.arrayquestions;

//Answer to http://algorithms.tutorialhorizon.com/print-all-diagonals-of-a-given-matrix/
public class PrintAllDiagonals {

	public static void main(String args[]) {
		int[][] i = new int[4][4];

		i[0][0] = 1;
		i[0][1] = 2;
		i[0][2] = 3;
		i[0][3] = 4;

		i[1][0] = 5;
		i[1][1] = 6;
		i[1][2] = 7;
		i[1][3] = 8;

		i[2][0] = 9;
		i[2][1] = 10;
		i[2][2] = 11;
		i[2][3] = 12;

		i[3][0] = 13;
		i[3][1] = 14;
		i[3][2] = 15;
		i[3][3] = 16;

		printDiagonals(i);

	}

	public static void printDiagonals(int[][] i) {

		
		//first half of diagnol
		for (int j = 0; j < i.length; j++) {
			int tempRow = j;
			for (int m = 0, k = 0; m < j + 1; m++) {
				System.out.print(i[tempRow][k]);
				System.out.print(" ");
				--tempRow;
				++k;
			}
			System.out.println();
		}

		
		
		if (i.length > 0) {

			int col=1;
			int row=i.length-1;	
			int noed=i.length-1; 
			
			for(int a=0;a<i.length-1;a++){
				int tmpRow=row;
				int tmpCol=col;
				
				for(int b=0;b<noed;b++){
					System.out.print(i[tmpRow][tmpCol]);
					System.out.print(" ");
					--tmpRow;
					++tmpCol;
				}
				++col;
				--noed;
				System.out.println();
			}
			
		
		
		}

	}
}
