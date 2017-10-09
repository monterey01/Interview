package com.anant.string;

public class RepeatString {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		char c = 'x';
		int n = 201;
		int d = 0;



		while (s.length() != n) {
			++d;
			if (s.length() >= 1 && s.length() * 2 <= n) {
				
				s.append(s);
			}

			else {
				s.append(c);
			}
		}
		System.out.println(d);

		
	}

}