package com.anant.sort;

public class BubbleSort {

	public static void main(String args[]) {
		
		String s1="0";
		String s2="0";
		String s3="0";
		
		System.out.println(((Integer.valueOf(s2)+(Integer.valueOf(s1))==Integer.valueOf(s2))));

		int[] a = { 5, 1, 4, 2, 8, -9 };

		a = bubbleSort(a);

		for (int value : a) {
			System.out.println(value);
		}

	}

	static int[] bubbleSort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (j != 0) {
					if (a[j] < a[j - 1]) {
						int temp = a[j];
						a[j] = a[j - 1];
						a[j - 1] = temp;
					}

				}
			}
		}
		return a;
	}

}

// abcd

// a bcd
// a bdc
// a cbd
// a cbd

// a cbd
// a cdb

// a dcb
// a dbc
