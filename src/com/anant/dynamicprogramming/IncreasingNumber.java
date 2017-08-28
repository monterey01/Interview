package com.anant.dynamicprogramming;

public class IncreasingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="465";
		
		int[] inputArray=new int[input.length()];
		int index=0;
		
		for(char c:input.toCharArray()) {
			inputArray[index]=Character.getNumericValue(c);
			++index;
		}
		
		int[] resultArray=increasingNumber(inputArray);
		StringBuilder resultBuilder=new StringBuilder();
		
		for(int i=0;i<resultArray.length;i++) {
			resultBuilder.append(resultArray[i]);
		}
		
		System.out.println(Integer.valueOf(resultBuilder.toString()));
	}

	
	public static int[] increasingNumber(int[] a) {
		boolean hasIndexBeenReplaced=false;
		
		for( int i=0;i<a.length;i++) {
			
			if(hasIndexBeenReplaced) {
				a[i]=9;
			}
			else {
				if(i+1<a.length) {
					if(a[i]>a[i+1]) {
					a[i]-=1;
					a[i+1]=9;
					hasIndexBeenReplaced=true;
					}
				}
			}
		}
		
		
		return a;
	}
	
}
