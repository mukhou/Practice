package com.starandnumbertriangles;

public class InvertedRightAngledStarTriangle {

	
	public static void main(String[] args) {
		
		int i, j, n;
		n = 5;
		
		// preferred approach
		// start i from n, for inverted triangle 
		for(i = n; i >= 1; i--){
			// start j from 1
			for(j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		/*for(i = 1; i <= n; i ++){
			for(j = n; j >= i; j --){
				System.out.print("*");
			}
			System.out.println(" ");
		}
		*/
		

	}

}
