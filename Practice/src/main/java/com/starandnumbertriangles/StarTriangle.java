package com.starandnumbertriangles;

public class StarTriangle {

	public static void main(String args[]) {
		
		int i, j, n = 3;
		
		
		// loop for the number of lines
		for (i = 1; i <= n; i++) {
			// loop for number of spaces on each line
			//counting from j=1, one space less
			for (j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			if (i == 1) {
				System.out.println("*");
			} else {
				// loop for triangle
				for (j = 1; j < (i * 2) ; j++) {
					System.out.print("*");
				}
				System.out.println("");
			}

		}
	}

}
