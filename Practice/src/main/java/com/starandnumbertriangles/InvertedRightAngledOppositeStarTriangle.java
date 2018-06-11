package com.starandnumbertriangles;

public class InvertedRightAngledOppositeStarTriangle {

	
	public static void main(String[] args) {
		
		int i, j, n;
		n = 5;
		
		// start i from n, for inverted triangle
		for(i = n; i >= 1; i--){
			// start j from 1
			// for spaces
			for(j = 1; j<= n-i; j++){
				System.out.print(" ");
			}			
			// now it is same as InvertedRightAngledStarTriangle
			for(j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		

	}

}
