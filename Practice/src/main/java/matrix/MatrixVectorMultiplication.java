package matrix;

public class MatrixVectorMultiplication {

	// matrix-vector multiplication (y = A * x)
    public static double[] multiply(double[][] A, double[] x) {
        int rows = A.length;
        int cols = A[0].length;
        if (x.length != cols) throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                y[i] += (A[i][j] * x[j]);
        return y;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
