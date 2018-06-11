package com.cts.test;

public class PrintNewNumber {

	public static void main(String[] args) {
		int res;
		
		int input = Integer.parseInt(args[0]);
		res = addOne(input);
		System.out.println(res);
	
	}
	
	
	
	private static int addOne(int num) {
		
		int ctr = 1, sum = 0;
		while(num>0){
			
			int temp = (((num % 10) + 1) % 10) * ctr;
			sum = sum + temp;
			num = num /10;
			ctr = ctr * 10;
		}
		
		return sum;
	
	}
	
		
	/*	private static int addOne(int num) {
			int n = num;
			int result = 0;
			while (n > 0) {			
				result = result + (((n % 10) + 1)%10);
				result = result * 10;
				n = n / 10;
			}
			n = result;
			result = 0;
			while (n > 0) {
				result = (result + n % 10) * 10;
				n = n / 10;			
			}
			return result/10;
		}*/
		
	
	
	
	

}
