package goldmansachs;

import java.util.ArrayList;
import java.util.List;

public class LongestPathInMatrix {

	static int findMaxSequence(int matrix[][]) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = 0;
		for (int i = 1; i < rows; i++){
			for (int j = 1; j < cols; j++){
				if (matrix[i][j] == 1){
					matrix[i][j] = 1 + Math.max(matrix[i][j - 1], matrix[i - 1][j]);	
					// update max
					max = Math.max(max, matrix[i][j]);
				}
				//arr[i][j] = (arr[i][j] == 1? 1 + Math.max(arr[i][j - 1], arr[i - 1][j]) : 0);
			}
		}

		
		// find max num from the matrix
		
		
		displayLongestPath(matrix, max);

		return max;
	}

	
	private static void displayLongestPath(int[][] matrix, int max) {
		int rows = matrix.length;
        int cols = matrix[0].length;
        // initialize prevRow to the last row and
        // prevCol to the last column index
        int prevRow = rows;
        int prevCol = cols;
        List<String> pathList = new ArrayList<String>();
        for (int i = rows - 1; i >= 0; --i)
        {
            for (int j = cols - 1; j >= 0; --j)
            {
                if (matrix[i][j] == max && i <= prevRow && j <= prevCol)
                {
                	// add index to list
                    pathList.add(i +"" +j);
                    // decrease max
                    max--;
                    // set prevRow and prevCol as current i and j for next iteration 
                    prevRow = i;
                    prevCol = j;
                }

                if (max == 0)
                {
                    System.out.println("longest path");
                    System.out.println(pathList);

                    return;
                }
            }
        }
        System.out.println();
		
	}


	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 }, { 1, 1, 1, 1, 1 } };
		System.out.println(findMaxSequence(matrix));
	}

}
