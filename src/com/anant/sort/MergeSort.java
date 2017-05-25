package com.anant.sort;

//2,3,4,1,5
public class MergeSort {

	public static void main(String args[]) {
		int[] i = { 4, 3 };

		i = divideAndConquqer(i);
		for (int value : i) {
			System.out.println(value);
		}
	}

	private static int[] divideAndConquqer(int[] i) {

		if (i.length < 2) {
			return i;
		}

		if (i.length == 2) {
			if (i[0] > i[1]) {
				int j = i[0];
				i[0] = i[1];
				i[1] = j;
			}

		}

		if (i.length > 2) {

		}

		return i;
	}

	private static int[] copyArray(int[] i, int startIndex, int endIndex) {
		int[] k = new int[endIndex - startIndex + 1];

		for (int j = startIndex, l = 0; j <= endIndex; j++, l++) {
			k[l] = i[startIndex];
		}

		return k;
	}

	private static int[] sortArrays(int[] i1, int[] i2) {
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
