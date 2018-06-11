/**
 * This class finds the sum of
 * first and last digits of a four digit number
 */

package com.cts.test;

public class SumOfFirstLastDigit {

	public static int findSum(Integer n) {
		String str = n.toString();
		int d, sum = 0;
		int l = str.length() - 1;
		// System.out.println(l);
		d = n % 10;
		sum += d;
		d = (int) (n / Math.pow(10, l));
		sum += d;

		return sum;

	}

	public static void main(String[] args) {

		int n, first_digit, last_digit, sum = 0;
		n = 4213;

		/*
		 * first_digit = n%10; sum = sum +first_digit; last_digit = (n/1000)%10;
		 * 
		 * sum = sum +last_digit;
		 */

		// System.out.println("The sum is "+sum);
		System.out.println(findSum(n));

	}

}
