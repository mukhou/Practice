package sortandsearch;

import java.util.Arrays;

/**
 * Time complexity: O(n^2) for all cases
 */

//select smallest and bring it on top; repeat
public class SelectionSort {

	public static int[] selectionSort(int[] arr){
		
		// traverse till the second last element of the array
		for(int i = 0; i < arr.length - 1; i++){
			int smallest_index = i;
			// find the smallest element
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[smallest_index]){
					smallest_index = j;
				}
			}
			// exchange smallest element with i
			int temp = arr[smallest_index];
			arr[smallest_index] = arr[i];
			arr[i] = temp;			
		}
		return arr;
		
	}
	public static void main(String[] args) {
		int[] arr = {10,34,2,56,7,67,88,42, 3};
		int[] result = selectionSort(arr);		
		System.out.println(Arrays.toString(result));

	}

}
