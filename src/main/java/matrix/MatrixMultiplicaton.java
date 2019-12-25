package matrix;

public class MatrixMultiplicaton {

	public static int[][] multiply(int[][] a, int[][] b) {

		int aRows = a.length, aColumns = a[0].length;
		int bRows = b.length, bColumns = b[0].length;

		if (aColumns != bRows) {
			throw new IllegalArgumentException("A:Rows: " + aColumns
					+ " did not match B:Columns " + bRows + ".");
		}

		int[][] resultant = new int[aRows][bColumns];

		for (int i = 0; i < aRows; i++) { // aRow
			for (int j = 0; j < bColumns; j++) { // bColumn
				// determines how many additions for the first cell of resultant
				// will go on till all the columns of A are counted
				// or all the rows of B are counted
				for (int k = 0; k < aColumns; k++) { // aColumn
					resultant[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return resultant;
	}

	public static void main(String[] args) {
		int[][] a = new int[2][3];
		int[][] b = new int[3][2];

		// a values
		a[0][0] = 1;
		a[0][1] = 0;
		a[0][2] = -2;
		a[1][0] = 0;
		a[1][1] = 3;
		a[1][2] = -1;

		// b values
		b[0][0] = 1;
		b[0][1] = 3;
		b[1][0] = -2;
		b[1][1] = -1;
		b[2][0] = 4;
		b[2][1] = 4;

		int[][] res = multiply(a, b);

	}

}
