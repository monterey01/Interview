package com.anant.sort;

public class BubbleSort {

	public static void main(String args[]) {

		int[] a = { 5,1,4,2,8,-9};
		
		for (int i = 0; i < a.length; i++) {
			
			// 3,2,5,7
			for (int j = 1; j < a.length; j++) {
				if (a[j - 1] > a[j]) {
					int k=a[j-1];
					a[j-1]=a[j];
					a[j]=k;
				}
			}

		}

		for (int value : a) {
			System.out.println(value);
		}

	}

}
