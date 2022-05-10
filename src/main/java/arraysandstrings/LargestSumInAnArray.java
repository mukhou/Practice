/**
 * You are given an array of integers (both positive and negative). 
 * Find the largest sum. Return the sum.
 */

package arraysandstrings;

import java.util.Arrays;


public class LargestSumInAnArray {

	//this method doesn't work for all positive numbers
	// for all positive numbers, add up all the numbers to give the
	// final sum.
	public static void findLargestSum(int[] arr, int start, int end){
		Arrays.sort(arr);
		int sum = 0;
		int mid = (start + end) / 2;
		//System.out.println(arr[mid]);
		while(arr[mid] <= 0){
			mid = mid + 1;
		}
		//System.out.println(arr[mid]);
		for(int i = mid; i <= arr.length - 1; i++){
			sum = sum + arr[i];
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{2, 8, 3, 2, 4, 10};
		for(int i : arr){
			System.out.println(i);
		}
		findLargestSum(arr, 0, arr.length - 1);
		

	}

}
