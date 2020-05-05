/**
 * You are given an array of integers (both positive and negative).
 * Find the continuous sequence with the largest sum. Return the sum.
 */

package dynamicprog;

import java.util.Arrays;

// also Contiguous Max SubArray Sum problem
//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class LargestContinuousSubArraySum {

    // keep track of the current sum
    //https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm_(Algorithm_3:_Dynamic_Programming)
    //FOLLOW THIS IF ASKED TO FIND JUST THE SUM
    public static int findContinuousSum(int[] arr) {

        int max_sum = arr[0], curr_max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //IMP: MAX of arr[i] and curr_max + arr[i]
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max_sum = Math.max(max_sum, curr_max);
        }
        return max_sum;
    }


    //EXACTLY SAME LOGIC AS ABOVE, EXCEPT USING A DP TABLE
    //NEED EXTRA SPACE, SO FOLLOW ABOVE
    public static int findContinuousSum1(int[] arr) {
        int max_sum = arr[0];
        int[] maxSumTable = new int[arr.length];
        maxSumTable[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxSumTable[i] = Math.max(arr[i], arr[i] + maxSumTable[i - 1]);
            max_sum = Math.max(max_sum, maxSumTable[i]);
        }
        System.out.println(Arrays.toString(maxSumTable));
        return max_sum;
    }


    //USE IT ONLY IF YOU NEED TO PRINT THE SUBARRAY AS WELL
    static void maxSubArraySum(int a[]) {
        int max_sum = Integer.MIN_VALUE;
        int maxSoFar = 0, start = 0, end = 0, s = 0;
        for (int i = 0; i < a.length; i++) {
            maxSoFar += a[i];
            if (max_sum < maxSoFar) {
                max_sum = maxSoFar;
                start = s;
                end = i;
            }

            if (maxSoFar < 0) {
                maxSoFar = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_sum);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-5, -4, 1, 0, 5, 10};
        int[] arr1 = {-5, -4, -2, 0};
        int[] arr2 = {3, 10, 3, 11, 4, 5, 6, 7, 8, 12};
        System.out.println(Arrays.toString(arr1));
        System.out.println(findContinuousSum(arr1));
        maxSubArraySum(arr2);
        System.out.println(findContinuousSum1(arr1));

    }

}
