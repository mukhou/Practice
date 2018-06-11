package arraysandstrings;

public class SortFirstAndSecondHalfSortedArray {

	public static int[] printSortedArray(int[] arr, int start, int end){
		int mid = (start + end) / 2;
		int i = 0, index = 0;
		int j = mid;
		//System.out.println(j);
		int[] c = new int[arr.length];
		while(i < mid && j < arr.length){
			c[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}
		if(i == mid){
			while(j < arr.length ){
				c[index++] = arr[j++];
			}
		}else{
			while(i < mid){
				c[index++] = arr[i++];
			}
		}
			
		return c;
	}
	
	public static void main(String[] args) {
		int[] arr = {11, 12, 13, 14, 1, 7, 18, 19, 20};
		int[] c = printSortedArray(arr, 0, arr.length - 1);
		for(int i : c){
			System.out.println(i);
		}
		

	}

}
