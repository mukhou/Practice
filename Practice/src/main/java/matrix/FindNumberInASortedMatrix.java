
/**
 * Search a number in a large square but sorted matrix.
 * ALGORITHM:
 * 1.Start with the first row and the last column.
 * 2.If the cell value is less than the number, move to the next row.
 * 3.Keep incrementing the row till the number is found.
 */
package matrix;

public class FindNumberInASortedMatrix {

	public static void findNumber(int[][] a, int num){
		int rows = a.length;
		int cols = a[0].length;
		for(int i = 0; i < rows; i ++){
			for(int j = cols - 1; j >=0; j--){
				if(a[i][j] < num){
					break;
				}else{
					if(a[i][j] == num){
						System.out.println(i + " " + j);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		/*int[][] a = new int[3][3];
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 3;		
		a[1][0] = 4;
		a[1][1] = 5;
		a[1][2] = 6;		
		a[2][0] = 7;
		a[2][1] = 8;
		a[2][2] = 9;*/
		
		int a[][]= {
				{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}                
                };
		
		findNumber(a, 6);

	}

}
