/* 
User: Urmi
Date: 1/8/2020 
Time: 5:13 PM
*/

/**
 * Given an array of integers and a number k, find maximum sum of a subarray of size k.
 * IDEA:
 * sum of a subarray (or window) of size k can be obtained in O(1) time using sum of previous subarray (or window)
 * of size k. Except first subarray of size k, for other subarrays, we compute sum by
 * removing first element of last window and adding last element of current window.
 */
package arraysandstrings;

//https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
//Time Complexity : O(n)
public class LargestContinuousSubArrayOfSizeK {

    // Returns maximum sum in a subarray of size k.
    public static int maximumSubarraySum(int[] arr, int k){

        if(k > arr.length){
            System.out.println("invalid");
            return -1;
        }

        // Compute sum of first window of size k(index k - 1)
        int max_sum = 0;
        for(int i = 0; i < k; i++){
            max_sum += arr[i];
        }

        // Compute sums of remaining windows STARTING WITH K by adding the difference of
        // first element of previous window and last element of current window, in effect
        // removing first element of previous window and adding last element of current window
        int curr_sum = max_sum;
        for(int i = k; i < arr.length; i++){
            curr_sum += arr[i] - arr[i - k];
            max_sum = Math.max(curr_sum, max_sum);

        }
        return max_sum;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maximumSubarraySum(arr, k));
    }

}
