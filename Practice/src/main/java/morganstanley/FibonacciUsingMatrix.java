/**
 * This another O(n) which relies on the fact that if we n times multiply the matrix
 *  M = {{1,1},{1,0}} to itself, then we get the (n+1)th Fibonacci number
 *  as the element at row and column (0, 0) in the resultant matrix.
 *  Time Complexity: O(n), Extra Space: O(1)
 */
package morganstanley;

import matrix.MatrixMultiplicaton;

public class FibonacciUsingMatrix {

	public static int fibo(int n){
		int[][] fib_matrix = {{1, 1}, {1, 0}};
		if(n == 0) return n;
		int fib_final = power(fib_matrix, n - 1);
		return fib_final;
	}
	
	private static int power(int[][] fib_matrix, int n) {
		int i, fib_result = 0;
		int[][] fib_matrix1 = {{1, 1}, {1, 0}};
		// n - 1 times multiply the matrix to {{1,0},{0,1}}
		for(i = 2; i <= n ; i++){
			fib_result = multiply(fib_matrix, fib_matrix1);
		}
		return fib_result;
		 
		
	}

	private static int multiply(int[][] fib_matrix, int[][] fib_matrix1) {
		  // multiply both the matrices
		  int result[][] = MatrixMultiplicaton.multiply(fib_matrix, fib_matrix1);
		  
		  // every time set fib_matrix as the result of the product 
		  // of the two matrices
		  fib_matrix[0][0] = result[0][0];
		  fib_matrix[0][1] = result[0][1];
		  fib_matrix[1][0] = result[1][0];
		  fib_matrix[1][1] = result[1][1];
		  
		  return result[0][0];
		
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(fibo(n));

	}

}
