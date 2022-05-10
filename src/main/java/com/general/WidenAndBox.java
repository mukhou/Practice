package com.general;

public class WidenAndBox {

	static void go (Long x){
		System.out.println("Lonf");
	}
	
	public static void main(String[] args) {
		byte b = 5;
		// Illegal: cannot widen and box
		//go(b);

	}

}
