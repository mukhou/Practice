package matrix;


public class FindMatrixTranspose {

	public static int[][] findTranspose(int[][] matrix){
		int rows = matrix.length;//2
		int cols = matrix[0].length;//3
		int[][] transpose = new int[cols][rows];
		for(int i = 0; i < cols; i ++){
			for(int j = 0; j < rows; j ++){
				transpose[i][j] = matrix[j][i];
			}
		}
		return transpose;
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6 },
				{ 7, 8, 9},
				{ 10, 11, 12}
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
