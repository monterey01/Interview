package com.anant.arrayquestions;

public class FindDuplicates {
	
	//Solution to https://codefights.com/interview-practice/task/pMvymcahZ8dY4g75q

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,2};
		// 1,-3,2,1
		// 1,-3,

		System.out.println(firstDuplicate(a));

	}

	public static int firstDuplicate(int[] a) {

		
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] - 1;
		}

		for (int i = 0; i < a.length; i++) {
			int index = Math.abs(a[i]) == a.length ? 0 : a[i];

			if (a[Math.abs(index)] >= 0) {

				a[Math.abs(index)] = -a[Math.abs(index)];

				if (a[Math.abs(index)] == 0)
					a[Math.abs(index)] = -1 * a.length;

			} else {
				return (Math.abs(a[i]) + 1);
			}
		}

		return -1;

	}



}
