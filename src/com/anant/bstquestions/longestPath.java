package com.anant.bstquestions;

import java.util.LinkedList;
import java.util.Queue;

public class longestPath {

	public static void main(String[] args) {
		String s = "dir\r    file.txt";
		String[] s1 = s.split("\r");
		Queue<String> q = new LinkedList<String>();

		for (String s2 : s1) {
			q.add(s2);
		}

		System.out.println(longestPath(q, -1, ""));

		// System.out.println(getLongestPath(s));

	}

	public static int longestPath(Queue<String> q, int level, String dp) {
		int result = 0;

		while (!q.isEmpty()) {
			String sTemp = q.peek();
			boolean isFile = sTemp.indexOf('.') > 0;
			int tempLevel = getLevel(sTemp.toCharArray());
			sTemp = sTemp.replace("\t", "");

			if (isFile) {
				if (level == tempLevel) {
					return 0;
				} else {
					result = Math.max((dp + sTemp).length(), result);
					q.remove();
				}

			} else {
				String dpPath = new String();
				if (level >= tempLevel) {
					return result;
				} else {
					dpPath = dp + sTemp + "\\";
					q.remove();
					result = Math.max(longestPath(q, tempLevel, dpPath), result);

				}

			}
		}

		return result;
	}

	private static int getLevel(char[] c) {
		int result = 0;
		for (char c1 : c) {
			if (c1 == '\t') {
				++result;
			} else {
				break;
			}
		}

		return result;
	}

}
