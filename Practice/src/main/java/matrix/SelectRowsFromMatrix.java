package matrix;

import java.util.Arrays;

public class SelectRowsFromMatrix {
	
	/*public static void selectRows(int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0; i < cols; i ++){
			int[] arr = new int[4];
			for(int j = 0; j < rows; j ++){
				int temp = matrix[j][i];
				arr[j] = temp;
			}
		}
		
	}*/
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
				{ 1, 2, 3 }, 
				{ 4, 0, 5 }, 
				{ 0, 7, 9 },
				{ 8, 9, 0 }
				};
		
		for (int i = 0; i < matrix[0].length; i++) {
			int[] temp = new int[matrix.length];
			for (int j = 0; j < matrix.length; j++) {
				//System.out.print(matrix[i][j] + "\t");
				temp[j] = matrix[j][i];
				
			}
			System.out.print(Arrays.toString(temp));
			System.out.println();
		}
		//System.out.println(Arrays.toString(matrix[1]));
	}

}
