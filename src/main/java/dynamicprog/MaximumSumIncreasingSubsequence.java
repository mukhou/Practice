/* 
User: Urmi
Date: 1/22/2020 
Time: 7:43 PM
*/

/**
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array
 * such that the integers in the subsequence are in increasing order.
 */
package dynamicprog;

import java.util.Arrays;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaximumSumSubsequence.java
public class MaximumSumIncreasingSubsequence {

    private static int maxSumIncreasingSubsequences(int [] arr){
        if (arr.length == 0) {
            return 0;
        }
        int[] maxSumTable = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            maxSumTable[i] = arr[i];
        }

        int maxSumSoFar = maxSumTable[0];

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    //sum is maximum of the current sub problem and (previous sub problem + current item value)
                    //SIMILAR TO LongestIncreasingSubsequenceInArray
                    maxSumTable[i] = Math.max(maxSumTable[i], arr[i] + maxSumTable[j]);
                }
            }
            maxSumSoFar = Math.max(maxSumSoFar, maxSumTable[i]);
        }
        System.out.println(Arrays.toString(maxSumTable));

        return maxSumSoFar;
    }

    public static void main(String[] args){
        int[] arr = {2, 0, 1, 5};
        System.out.println(maxSumIncreasingSubsequences(arr));

    }
}
