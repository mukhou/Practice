package com.starandnumbertriangles;

public class RightAngleOppositeNumber {

	public static void main(String args[]) {

		int i, j, n = 5;
		System.out.println("Please enter a number  ");
		//n = Integer.parseInt(args[0]);
		
		// loop for the number of lines
		for (i = 1; i <= n; i++) {
			// loop for number of spaces on each line
			for (j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			if (i == 1) {
				System.out.println(i);
			} else {
				// loop for triangle
				for (j=i; j>=1; j--) {
					System.out.print(j);
				}
				System.out.println("");
			}

		}

	}

}
