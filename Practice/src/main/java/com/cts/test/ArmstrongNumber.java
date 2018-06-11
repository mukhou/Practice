package com.cts.test;

public class ArmstrongNumber {
	
	public static void checkArmstrong(int n){
		Integer in = new Integer(n);
		String str = in.toString();
		int temp = n;
		int d = 1, c = 1, sum = 0;
		while(temp > 0){
			d = temp % 10;
			c = d * d * d;
			sum = sum + c;
			temp /= 10;
		}
		if(sum == n){
			System.out.println("ArmstrongNumber");
		}else{
			System.out.println("Not ArmstrongNumber");
		}
	}

	
	public static void main(String[] args) {
		
		
		checkArmstrong(371);
		

	}

}
