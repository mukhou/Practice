package com.starandnumbertriangles;

public class RightAngledStarTriangle {

	
	public static void main(String[] args) {
		
		int i, j, n;
		n = 5;
		
		for(i = 1; i <= n; i++){
			// i = 1, then 1*, i = 2, then 2*.... 
			for(j = 1; j <= i; j++){				
				System.out.print("*");
				//System.out.print("");
			}
			System.out.println("");
		}
		

	}

}
