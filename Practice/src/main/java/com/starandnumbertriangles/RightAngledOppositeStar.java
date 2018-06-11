package com.starandnumbertriangles;

public class RightAngledOppositeStar {

	public static void main(String args[]) {

		int i, j, n=5;
		
		// loop for the number of lines
		for (i = 1; i <= n; i++) {
			// loop for number of spaces on each line
			// n = 3
			// i = 1, then 3 -1 = 2 spaces, i = 2, 3 -2 = 1 space, i = 3, 0 space...			
			for (j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			if (i == 1) {
				System.out.println("*");
			// now the program is just the same as a normal
				// right angle star triangle
				// i = 1, then 1*, i = 2, then 2*....
			} else {
				// loop for triangle
				for (j = 1; j <= i ; j++) {
					System.out.print("*");					
				}
				System.out.println("");
			}
			

		}

	}

}
