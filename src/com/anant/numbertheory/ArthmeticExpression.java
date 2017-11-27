package com.anant.numbertheory;

public class ArthmeticExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pae(new int[] {1,2,3}, 0, Character.MIN_VALUE, 0, 0);
	}

	// 1*2

	// 2+4+6
	// 2*4*6
	// 2+4*6
	// 2*4+6

	public static void pae(int[] in, int i, char po, int a, int m) {

		if (i + 1 >= in.length) {
			if (po == '-')
				System.out.println(a + m - in[i]);
			if (po == '+')
				System.out.println(a + m + in[i]);
			if (po == '*')
				System.out.println(a + m * in[i]);
			if (po == Character.MIN_VALUE)
				System.out.println(a + m);
			return;
		}

		switch (po) {
		case Character.MIN_VALUE:
			pae(in, i + 1, '+', in[i], 0);
			pae(in, i + 1, '-', in[i], 0);
			pae(in, i + 1, '*', 0, in[i]);
			break;
		case '+':
			pae(in, i + 1, '+', a + in[i], 0);
			pae(in, i + 1, '-', a + in[i], 0);
			pae(in, i + 1, '*', a, in[i]);
			break;
		case '-':
			pae(in, i + 1, '+', a - in[i], 0);
			pae(in, i + 1, '-', a - in[i], 0);
			pae(in, i + 1, '*', a, -1 * in[i]);
			break;
		case '*':
			pae(in, i + 1, '+', a - in[i], 0);
			pae(in, i + 1, '-', a - in[i], 0);
			pae(in, i + 1, '*', a, m * in[i]);
			break;
		}

	}

}

// 2+5*7