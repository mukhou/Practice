/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 *  its entire row and column is set to 0.
 *  ALGORITHM:
 *  1. Keep a second matrix to keeps track of the zero locations.
 *  2. Do a second round iteration of the matrix and check with the flagged
 *  matrix to set entire row or column to zero.
 */
package crackingcodeinterview;

public class SetRowColumnToZero {

	public static void setZeroes(int[][] matrix) {

		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0){
					row[i] = 1;
					col[j] = 1;
				}

			}
		}
		/*for(int k : row){
			System.out.print(k + "\t");
		}
		System.out.println();
		for(int l : col){
			System.out.print(l + "\t");
		}
		System.out.println();
		System.out.println("####################");
		*/

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(row[i] == 1 || col[j] == 1){
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix =  {
				{ 1, 2, 3 },
				{ 4, 0, 5 },
				{ 0, 7, 9 }
		};
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
