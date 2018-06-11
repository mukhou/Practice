package com.cts.test;

public class InputArray {

	
	public static void main(String[] args) {
		
		int n, m;
		int [] arr = new int[4];
		n = Integer.parseInt(args[0]);
		
		for(int i=0; i<=3; i++){
			m = n % 10;
			n = n / 10;
			arr[i] = m;
			
		}
		
		for(int x : arr){
			System.out.println(x);
		}
		

	}

}
