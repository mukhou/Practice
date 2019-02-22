package matrix;


public class FindMatrixTranspose {

	public static int[][] findTranspose(int[][] matrix){
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] transpose = new int[cols][rows];
		for(int i = 0; i < cols; i ++){
			int[] arr = new int[rows];
			for(int j = 0; j < rows; j ++){
				arr[j] = matrix[j][i];
			}
			transpose[i] = arr;
			
		}
		return transpose;
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6 }
				};
		int[][] tr = findTranspose(matrix);
		for(int i = 0; i < tr.length; i ++){
			for(int j = 0; j < tr[0].length; j ++){
				System.out.print(tr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
