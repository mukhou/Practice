
/**
 * Given an n-by-n matrix of 0's and 1's where all
 * 1's in each row come before all 0's, find the most efficient way
 * to return the row with the maximum number of 0's.
 */
package matrix;


public class RowWithMaxZeroes {

	public static void findMaxZeroesRow(int[][] a){
		int rows = a.length;
		int cols = a[0].length;
		
		int maxRow = -1;	
		int maxZeroCount = 0;
		int prevZeroCount = 0;
		
		
		for(int i = 0; i < rows; i ++){
			// initialize current zero count to zero every time
			int currentZeroCount = 0;
			for(int j = cols - 1 ; j >= 0; j--){
				if(a[i][j] == 0){
					currentZeroCount = currentZeroCount + 1;
				}
				
			}
			maxZeroCount = (prevZeroCount > currentZeroCount) ? prevZeroCount 
					: currentZeroCount;
			maxRow += (maxZeroCount == currentZeroCount) ? 1 : 0;
			prevZeroCount = maxZeroCount;
		}
		
		
		System.out.println(maxRow);
	}
	public static void main(String[] args) {
		int arr[][]= {
				{1,1,1,0},
                {1,1,0,0},
                {1,0,0,0},
                {1,1,0,0},
                };
		
	
		findMaxZeroesRow(arr);
                

	}

}
