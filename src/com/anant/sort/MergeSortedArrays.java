package com.anant.sort;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] i1 = { 1, 5, 9, 10, 15, 20 };
		int[] i2 = { 2, 3, 4, 8, 13 };

		int[] result = mergeSortedArrays(i1, i2);

		for (int value : result) {
			System.out.println(value);
		}
	}

	private static int[] mergeSortedArrays(int[] i1, int[] i2) {
		int i3[] = new int[i1.length + i2.length];
		int i1index = 0;
		int i2index = 0;
		int i3index = 0;

		while (i1index < i1.length || i2index < i2.length) {

			if (i1index < i1.length && i2index < i2.length) {
				if (i1[i1index] > i2[i2index]) {
					i3[i3index] = i2[i2index];
					++i2index;
				} else {
					i3[i3index] = i1[i1index];
					++i1index;

				}

			}

			else if (i1index < i1.length) {
				i3[i3index] = i1[i1index];
				++i1index;

			}

			else if (i2index < i2.length) {
				i3[i3index] = i2[i2index];
				++i2index;

			}

			++i3index;

		}

		return i3;
	}
}
