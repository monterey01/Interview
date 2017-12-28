package com.anant.string;

class StringIterator {
	int index = 0;
	int charCounter = 0;
	int charCounterSize = 0;
	char[] ca;

	public StringIterator(String compressedString) {
		ca = compressedString.toCharArray();
	}

	public static void main(String[] args) {
		StringIterator si=new StringIterator("L10e2t1C1o1d1e11");
		while(si.hasNext()) {
			System.out.print(si.next());
		}
		

	}

	public char next() {
		if (index >= ca.length)
			return ' ';
		if (charCounter == 0) {
			int tmpIndex = index + 1;
			int m = 1;
			StringBuilder sb = new StringBuilder();
			while (tmpIndex < ca.length && Character.isDigit(ca[tmpIndex])) {
				++charCounterSize;
				sb.append(Character.getNumericValue(ca[tmpIndex]));
				++tmpIndex;
			}
			charCounter = Integer.parseInt(sb.toString());
		}

		char x = ca[index];
		--charCounter;
		if (charCounter == 0) {
			
			index += charCounterSize + 1;
			charCounterSize = 0;
		}
		System.out.print(x);
		return x;
	}

	public boolean hasNext() {
		return index < ca.length;
	}
}
