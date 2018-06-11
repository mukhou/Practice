package com.starandnumbertriangles;

public class StarTriangle1 {

	public static void main(String args[]) {

		int i, j, n=3;
		
		// loop for the number of lines
		for (i = 0; i < n; i++) {
			// loop for number of spaces on each line
			//counting from j=1, one space less
			for (j = 1; j < n - i; j++) {
				System.out.print(" ");
			}
			if (i == 0) {
				System.out.println("*");
			} else {
				// loop for triangle
				for (j = 0; j < (i + 1); j++) {
					System.out.print("*");
					// without this space, it forms same triangle as RightAngledOppositeStar
					System.out.print(" ");
				}
				System.out.println("");
			}

		}

	}

}
