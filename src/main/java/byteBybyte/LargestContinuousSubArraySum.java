/**
 * You are given an array of integers (both positive and negative). 
 * Find the continuous sequence with the largest sum. Return the sum.
 */

package byteBybyte;

// also Contiguous Max SubArray Sum problem
public class LargestContinuousSubArraySum {

	// keep track of the current sum
    //https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm_(Algorithm_3:_Dynamic_Programming)
	public static int findContinuousSum(int[] arr){

        int max_sum = arr[0], curr_max = arr[0];

        for (int i = 1; i < arr.length; i++)        {
            //IMP: MAX of arr[i] and curr_max + arr[i]
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max_sum = Math.max(max_sum, curr_max);
        }
        return max_sum;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{-2, 4, 2, 3, -12, 5, 9, -3, 4 };//new int[]{-4, -1, 2, 5, -9, 7, 10};
		System.out.println(findContinuousSum(arr));

	}

}
