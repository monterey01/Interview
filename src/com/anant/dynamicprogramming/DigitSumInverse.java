package com.anant.dynamicprogramming;

public class DigitSumInverse {

	
public static void main(String args[]){
	
	System.out.println(digitSumInverse(11,2));
	
}
	
public static int digitSumInverse(int sum, int numberLength) {
     
	int f[]=new int[sum+1];
	
    // first round of initiation 
    for (int k = 0; k <= 9; k++) {
        if (k <= sum) {
            f[k] = 1;
        }
    }
    
    int total = f[sum]; // not 0 or 1
    
    for (int i = 2; i <= numberLength; i++) {
        for (int j = sum; j >= 0; j--) {
            int fij = 0;
            for (int k = 0; k <= 9; k++) { // the last digit
                if (j > k) { // the last digit could not equal to the sum
                    fij += f[j-k]; 
                }
            }
            f[j] = fij;
        }
        total += f[sum];
    }
    return total;
}

}

/*
 * 10^2 =100 5 14 23 32 41 50
 **/