package com.cts.test;

public class SumOfNumber {

	public static void main(String[] args) {

		int n, d, sum = 0;
		n = 523;


		while(n > 0){
			d = n % 10;
			sum += d;
			// since d is of type int, so only the digit before decimal is kept
			// rest are discarded
			n /= 10;
		}
		
		System.out.println(sum);
		
		//	System.out.println("Sum = " + sum);
		int c = 129 / 100;
		System.out.println(c);

		
	}

}
