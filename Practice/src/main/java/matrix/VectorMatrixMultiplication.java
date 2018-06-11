package matrix;

import java.util.Arrays;

public class VectorMatrixMultiplication {

	// vector-matrix multiplication (y = x^T A)
    public static double[] multiply(double[] x, double[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        if (x.length != rows) throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[cols];
        // reverse the loop of i and j
        // making i loop over cols and j loop  over rows
        for (int i = 0; i < cols; i++){
        	for(int j = 0; j < rows; j ++){
        		y[i] += (A[j][i] * x[j]);
        	}
        }
           
        return y;
    }
	
	public static void main(String[] args) {
		double[] vector = {1, 2, 3};
		double[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
		double[] result = multiply(vector, matrix);
		System.out.println(Arrays.toString(result));

	}

}
