package com.anant.numbertheory;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	static int multiplyIndex = 0;

	public static void main(String[] args) {
		List<List<String>> tmpResult = new ArrayList<List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();
		getCombList(new StringBuilder("105"), 0, new ArrayList<String>(), tmpResult);
		for (List<String> element : tmpResult) {
			if (addsToTarget(element, 5)) {
				result.add(element);
			}
		}

		System.out.println(result);

	}

	public static boolean addsToTarget(List<String> input, int target) {

		List<String> input1 = new ArrayList<String>();
		char oldOperator = Character.MIN_VALUE;

		int multiplyValue = Integer.MAX_VALUE;

		// 5+3-2
		int value = 0;

		for (int index = 0; index < input.size(); index++) {

			int num = Integer.valueOf(input.get(index));
			char newOperator = (index + 1 == input.size()) ? Character.MIN_VALUE : input.get(index + 1).charAt(0);

			if (oldOperator == Character.MIN_VALUE && (newOperator == '+' || newOperator == '-'))
				value = num;
			if (oldOperator == Character.MIN_VALUE && newOperator == '*') {

				value += multiplySum(input, 0);
				index = multiplyIndex;
				oldOperator = (index == input.size()) ? Character.MIN_VALUE : input.get(index + 1).charAt(0);
				continue;
			}

			if (oldOperator == '+' && (newOperator == '+' || newOperator == '-' || newOperator == Character.MIN_VALUE))
				value += num;
			if (oldOperator == '-' && (newOperator == '+' || newOperator == '-' || newOperator == Character.MIN_VALUE))
				value -= num;

			if (oldOperator == '+' && (newOperator == '*')) {
				value += multiplySum(input, index);
				index = multiplyIndex;
				oldOperator = (index == input.size()) ? Character.MIN_VALUE : input.get(index + 1).charAt(0);
				continue;

			}

			if (oldOperator == '-' && (newOperator == '*')) {
				value -= multiplySum(input, index);
				index = multiplyIndex;
				oldOperator = (index == input.size()) ? Character.MIN_VALUE : input.get(index + 1).charAt(0);
				continue;

			}

			oldOperator = newOperator;
			index++;

		}

		return value == target;
	}

	public static int multiplySum(List<String> input, int index) {
		int val = Integer.valueOf(input.get(index));

		for (int i = index + 2; i < input.size(); i++) {
			val *= Integer.valueOf(input.get(i));

			char newOperator = (i + 1 >= input.size()) ? Character.MIN_VALUE : input.get(i + 1).charAt(0);
			if (newOperator != '*') {
				multiplyIndex = i + 1;
				break;
			}

			++i;

		}

		return val;
	}

	public static void getCombList(StringBuilder sb, int si, List<String> l, List<List<String>> result) {

		if (si >= sb.length()) {

			result.add(new ArrayList<String>(l));
		}

		for (int i = si; i < sb.length(); i++) {
			String s = sb.subSequence(si, i + 1).toString();

			if (i + 1 >= sb.length()) {

				l.add(s);
				getCombList(sb, i + 1, l, result);
				l.remove(l.size() - 1);
			} else {
				l.add(s);
				l.add("+");

				getCombList(sb, i + 1, l, result);

				l.remove(l.size() - 1);
				l.remove(l.size() - 1);

				l.add(s);
				l.add("*");

				getCombList(sb, i + 1, l, result);

				l.remove(l.size() - 1);
				l.remove(l.size() - 1);

				l.add(s);
				l.add("-");

				getCombList(sb, i + 1, l, result);

				l.remove(l.size() - 1);
				l.remove(l.size() - 1);

			}
		}

	}

}
