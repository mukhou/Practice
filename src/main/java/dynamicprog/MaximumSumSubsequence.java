/* 
User: Urmi
Date: 3/3/2020 
Time: 12:23 PM
*/

/**
 * Given an array of n positive and negative integers. Write a program to find the sum of maximum sum subsequence
 * of the given array such that the integers in the subsequence are in increasing order.
 */
package dynamicprog;

import java.util.Arrays;

public class MaximumSumSubsequence {

    private static int maxSumSubsequences(int [] arr){
        if (arr.length == 0) {
            return 0;
        }
        int[] maxSumTable = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            maxSumTable[i] = arr[i];
        }

        int maxSum = maxSumTable[0];
        System.out.println(Arrays.toString(maxSumTable));

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] >= arr[j]){
                    //sum is maximum of the current sub problem and (previous sub problem + current item value)
                    //SIMILAR TO LongestIncreasingSubsequenceInArray
                    maxSumTable[i] = Math.max(maxSumTable[i], arr[i] + maxSumTable[j]);
                }
            }
            maxSum = Math.max(maxSum, maxSumTable[i]);
        }
        System.out.println(Arrays.toString(maxSumTable));

        return maxSum;
    }

    public static void main(String[] args){
        //int[] arr = {2, 0, 1, 5};
        int[] arr = {2, -1, 2, 3, 4, -5};
        System.out.println(Arrays.toString(arr));
        System.out.println(maxSumSubsequences(arr));

    }

}
