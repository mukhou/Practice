package com.cts.test;

public class PrintNumber {

	private static int printNumber(int num) {

		int ctr = 1, sum = 0;

		while (num != 0) {

			int temp = (num % 10) * ctr;
			sum = sum + temp;
			ctr = ctr * 10;
			num = num / 10;
		}
		
		

		return sum;

	}
	
	

	public static void main(String[] args) {

		int n, result;

		n = 5;
		result = printNumber(n);
		System.out.println("The number is " + result);
		

	}

}
