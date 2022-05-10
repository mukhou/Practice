
/**
 * Given an array with positive, negative and zeros, arrange the given array such that
 *  negatives are on left, zeros in the middle and positives on the right.
 */
package arraysandstrings;

import java.util.Arrays;

public class ArrangeArrays {

	public static void arrangeArrays(int[] arr){
		
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{2, -1, 0, -4, 3, 0};
		Arrays.sort(arr);
		for(int a : arr){
			System.out.println(a);
		}

	}

}
