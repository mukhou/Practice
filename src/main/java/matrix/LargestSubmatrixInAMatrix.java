package matrix;

public class LargestSubmatrixInAMatrix {

	public static int findLargestSubMatrix(int[][] a, int range){
		int rows = a.length;
		int cols = a[0].length;
		int currentSum = 0, maxSum = 0;
		for(int i = 0; i < rows - 1; i ++){
			for(int j = 0; j <cols - 1; j ++){
					currentSum = a[i][j] + a[i][j + 1] + a[i + 1][j] + a [i + 1][j + 1];
					if(currentSum > maxSum){
						maxSum = currentSum;
					}
			}
		}
		return maxSum;
	}
	public static void main(String[] args) {		
		int a[][]= {
				{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}                
                };
		System.out.println(findLargestSubMatrix(a, 2));
		
		
				

	}

}
