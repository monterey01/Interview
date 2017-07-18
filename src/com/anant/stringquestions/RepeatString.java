package com.anant.stringquestions;

public class RepeatString {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		char c = 'x';
		int n = 100000000;
		int d = 0;

		System.out.println(System.currentTimeMillis());

		while (s.length() != n) {
			++d;
			if (s.length() >= 1 && s.length() * 2 <= n) {
				s.append(s);
			}

			else {
				s.append(c);
			}
		}

		System.out.println(System.currentTimeMillis());

		System.out.println(s.length());
	}

}