package com.anant.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class BubbleSort {



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
