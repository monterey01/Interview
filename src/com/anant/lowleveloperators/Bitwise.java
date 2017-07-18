package com.anant.lowleveloperators;

public class Bitwise {

	// Reference to
	// http://fahdshariff.blogspot.com/2010/09/java-bit-twiddling.html
	public static void main(String args[]) {

		// System.out.println(additionBitwise(2, 4));

		int[] i = { 2, 8, 9, 8, 2, 9, 10 };

		int a = 1;

		// System.out.println(insertBits(15, 0, 0, 1));

		System.out.println(numberOf1Bits(648));

		// System.out.println(squareOfNumbersTothePowerofTwo(4));

	}

	static int numberOf1Bits(int n) {
		int res = 0;
		while (n != 0) {
			int maxInt=0;
			int tmp=n;
			boolean lessThanZero=false;
			
			while (lessThanZero==false){
				if(tmp>=n){
					tmp=tmp/2;
					++maxInt;
				}
				else{
					lessThanZero=true;
				}
			}
			
			for (int i = maxInt; i > -1; i--) {
				int j = n >> i & 1;
				if (j == 1)
					res++;
			}
		
			n = 0;
			res++;
		}
		return res;
	}

	static int insertBits(int n, int a, int b, int k) {

		// a = 1, b = 6 and k = 2,
		// 10

		for (int i = a, o = 0; i <= b; i++, o++) {
			int j = k >>> o & 1;
			if (j == 1) {
				n = n | 1 << i;
			} else if (j == 0) {
				n = n & ~(1 << i);
			}

		}

		return n;

	}


	public static int additionBitwise(int i, int j) {

		return i | j;
	}

	public static int nonDuplicateNumber(int a[]) {
		int result = 0;

		for (int j = 0; j < a.length; j++) {
			result = result ^ a[j];
		}

		return result;
	}

	public static int squareOfNumbersTothePowerofTwo(int i) {

		return 1 << i;
	}

	public static int insertbit(int n, int i, int bit) {

		return 1 << i;
	}
}
