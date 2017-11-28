package com.anant.implementds;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayInterface implements Iterable<Integer>{

	public static void main(String[] args) {

		int[][] a = new int[][] { {1,2,3 }, {}, {}, {} };
		ArrayInterface ar = new ArrayInterface(a);

		Iterator<Integer> itr = ar.iterator();

		while (itr.hasNext()) {
				
				int i = itr.next();
		
				System.out.println(i);
				itr.remove();
	
		}
		
	itr = ar.iterator();
	while (itr.hasNext()) {
		
		int i = itr.next();
		System.out.println(i);
	
}

		

		
	}

	private int[][] a;

	public ArrayInterface(int[][] in){
		this.a = in;
	}

	public Iterator<Integer> iterator() {
		ArrayIterator ai = new ArrayIterator(a);
		return ai;
	}

	private class ArrayIterator implements Iterator<Integer> {
		private int[][] a;

		int i = 0;
		int j = 0;
		int pi = 0;
		int pj = 0;
		boolean hasNext = false;
		boolean canremove = false;

		public ArrayIterator(int[][] a) {
			this.a = a;
		}
		
		public int[][] getArray() {
			return this.a;
		}

		public boolean hasNext() {
			boolean result = true;
			if (i >= a.length || j >= a[i].length) {
				result = false;
				while (i + 1 < a.length) {
					i = i + 1;
					j = 0;
					if (a[i].length > 0) {
						result = true;
						break;
					}
				}

			}
			hasNext = result;
			return result;
		}

		public Integer next() {
			if (!hasNext) {
				throw new NoSuchElementException();
			}
			canremove = true;
			pi = i;
			pj = j;
			++j;

			return a[pi][pj];
		}

		public void remove() {
			System.out.println("hello");
			if (!canremove) {
				throw new IllegalStateException();
			}
	
			int[] tmp = new int[a[pi].length - 1];

			int l = 0;
			for (int k = 0; k < a[pi].length; k++) {
				if (k != pj) {tmp[l] = a[pi][k];++l;}
				
			}
			
			a[pi] = tmp;
			--j;
			canremove = false;
		}

	}
}
