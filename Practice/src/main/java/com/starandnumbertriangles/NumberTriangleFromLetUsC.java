package com.starandnumbertriangles;

public class NumberTriangleFromLetUsC {

	
	public static void main(String[] args) {
		
		int i, j, k, n;
		
		n = 4;
		
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
				for (k=i+1; k <= (i * 2) -1; k++) {
					System.out.print(j);
					System.out.print(" ");		
					
					
				}
				
				System.out.println("");
			}
			

		}

	}

}
