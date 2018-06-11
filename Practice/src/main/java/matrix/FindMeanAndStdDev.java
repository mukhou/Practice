package matrix;

import java.util.Arrays;

public class FindMeanAndStdDev {
	double size; 
	
	public FindMeanAndStdDev(double size){
		this.size = size;
	}
	
	public void iterateMatrix(double[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		//System.out.println(rows + " " + cols);
		
		for(int i = 0; i < rows; i ++){
			// send ach column
			/*getMeanForEachCol(matrix[i]);
			getVarianceForEachCol(matrix[i]);*/
			getSTDDEVForEachCol(matrix[i]);
			
		}
	}

	public double getMeanForEachCol(double[] col){
		double sum = 0.0;
        for(double a : col)
            sum += a;
        double res = (sum/size);
        System.out.println(res);
            return sum/size;
	}
	
	double getVarianceForEachCol(double[] col){
		double mean = getMeanForEachCol(col);
        double temp = 0;
        for(double a :col)
            temp += (mean-a)*(mean-a);
            return temp/size;
	}
	
	public void getSTDDEVForEachCol(double[] col){
		double stdDev = Math.sqrt(getVarianceForEachCol(col));
		System.out.println(stdDev);
		//return Math.sqrt(getVarianceForEachCol(col));
		
	}
	public static void main(String[] args) {
		double[][] arr = {{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
		//System.out.println(Arrays.toString(arr[0]));
		
		System.out.println(arr[1][0]);
		
		FindMeanAndStdDev f = new FindMeanAndStdDev(arr[0].length);
		//f.iterateMatrix(arr);

	}

}
