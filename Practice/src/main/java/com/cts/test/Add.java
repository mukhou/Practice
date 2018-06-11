package com.cts.test;

public class Add {
	
	int x;
	int y;
	
	static int add(int a, int b){
		
		return a+b;
	}
	
	
	public static void main(String args[]){
		
		int r = add(3,5);
		System.out.println(r);
	}

}
