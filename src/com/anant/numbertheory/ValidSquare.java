package com.anant.numbertheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ValidSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(processIsValidSquare());

	}

	public static boolean processIsValidSquare() {
		List<List<int[]>> result = new ArrayList<List<int[]>>();
		List<int[]> input = new ArrayList<int[]>();

		input.add(new int[] { 1, 3 });
		input.add(new int[] { 2, 4 });
		input.add(new int[] { 5, 7 });
		input.add(new int[] { 6, 8 });

		System.out.println(Integer.compare(5, 0));

		Collections.sort(input, new Comparator<int[]>() {
			public int compare(int[] obj1, int[] obj2) {
				return Integer.compare(obj1[0], obj2[0]);

			}
		});

		System.out.println(input);

		for (int[] value : input) {
			System.out.println(value[0] + "," + value[1]);

		}

		// 0,5 5,5 0,0 5,0
		// isValidSquare(input.get(0),input.get(1),input.get(2),input.get(3));

		permuation(input, 0, result);

		System.out.println(result.size());

		for (List<int[]> value : result) {

			if (isValidSquare(value.get(0), value.get(1), value.get(2), value.get(3))) {
				return true;
			}

		}

		return false;
	}

	private static void permuation(List<int[]> input, int si, List<List<int[]>> result) {

		if (si >= input.size()) {
			List<int[]> tmpResult = new ArrayList<int[]>(input);
			result.add(tmpResult);
		}

		for (int i = si; i < input.size(); i++) {
			swap(input, i, si);
			permuation(input, si + 1, result);
			swap(input, i, si);
		}

	}

	private static void swap(List<int[]> input, int i, int j) {

		int[] tmp = input.get(i);
		input.set(i, input.get(j));
		input.set(j, tmp);

	}

	private static int getDistance(int[] p1, int p2[]) {

		return (int) (Math.pow(p1[0] - p2[0], 2)) + (int) (Math.pow(p1[1] - p2[1], 2));

	}

	private static boolean isValidSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		if (getDistance(p1, p2) > 0 && getDistance(p1, p2) == getDistance(p3, p4)
				&& getDistance(p1, p3) == getDistance(p2, p4) && getDistance(p1, p3) == getDistance(p1, p2)
				&& getDistance(p1, p2) * 2 == getDistance(p1, p4) && getDistance(p1, p2) * 2 == getDistance(p2, p3)) {
			return true;
		}

		return false;
	}

}
