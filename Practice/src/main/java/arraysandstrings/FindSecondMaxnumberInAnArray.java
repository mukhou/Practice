package arraysandstrings;

public class FindSecondMaxnumberInAnArray {

	public static int findSecondMaxNum(int[] arr){
		int max = arr[0];
		int max2 = arr[1];
		
		if(max < max2){
			max2 = max;
			max = arr[1];
			
		}
		for(int i = 2; i < arr.length; i++){
			// first check for max2
			if(arr[i] > max2){
				max2 = arr[i];
			}
			// then check for max
			if(arr[i] > max){
				max2 = max;
				max = arr[i];
			}
		}
		
		return max2;
	}
	
	public static void main(String[] args) {
		int[] arr = {9,10,2,3,5, 6};
		System.out.println(findSecondMaxNum(arr));

	}

}
