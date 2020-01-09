package byteBybyte;

public class HighestOccurringArrayElement {

	private static int maxRepeatedElement(int[] arr){
		return validate(arr, majorityElement(arr));
	}

	private static int majorityElement(int[] arr){
		int majority = 0, count = 0;
		for(int n : arr){
			if(count == 0){
				majority = n;
			}
			if(n == majority){
				count ++;
			}else {
				count --;
			}
		}
		System.out.println("*************" + majority);
		return majority;
	}

	private static int validate(int[] array, int element){
		int count = 0;
		for(int n : array){
			if(n == element){
				count ++;
			}
		}
		return count >= array.length /2 ? count : -1;
	}

	public static void main(String[] args) {
		//int[] arr = {7, 1, 7, 2, 3, 7, 2, 7, 2, 3, 7, 7, 2, 7, 7, 2, 6, 7, 7};
		int[] arr = {2, 1, 20, 2, 20, 2, 20, 2,2, 20};
		System.out.println(majorityElement(arr));
		

	}

}
