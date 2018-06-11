package collectionsgenericsandstring;

public class FindMaxNumber {

	
	public static void main(String[] args) {
		int[] arr = new int[]{87, 5, 23, 109, 26};
		int result = CompareToMax(arr, 5);
		System.out.println("the max value is "+ result);
		
		

	}

	private static int CompareToMax(int[] arr, int n) {
		int maxValue;
		/*if(n <= 0)
			return -1;*/
		
		maxValue = arr[0];
		for(int x = 1; x < n; x++){
			if(maxValue < arr[x]){
				maxValue = arr[x];
			}
		}
		return maxValue;
	}

}
