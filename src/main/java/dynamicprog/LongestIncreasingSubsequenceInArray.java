/* 
User: Urmi
Date: 1/16/2020 
Time: 11:10 AM
*/
/**
 * Given a sequence A of size N, find the length of the longest increasing subsequence from a given sequence .
 * The longest increasing subsequence means to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 * Note: Duplicate numbers are not counted as increasing subsequence.
 */

package dynamicprog;

import java.util.Arrays;

//WATCH THIS VIDEO: https://www.youtube.com/watch?v=fV-TF4OvZpk
//https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestIncreasingSubsequence/LongestIncreasingSubsequence.java
//IMP: read the explanation the above link SUPER HELPFUL
//NOTE: this method also returns the total number of longest increasing subsequences
public class LongestIncreasingSubsequenceInArray {

    private static int longestIncreasingSubsequence(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        /* Array to store our subproblems, default answer is 1. A single
        item is neither increasing or decreasing, kind of a middle ground.
        Each index records the answer to "what is the longest increasing
        subsequence ending at index i of the original array?"*/
        int[] maxLengthTable = new int[arr.length];
        Arrays.fill(maxLengthTable, 1);

        // By default the best answer is a length of 1
        int maximumSoFar = 1;

        //Test every possible end index of a longest increasing subsequence
        for (int i = 1; i < arr.length; i++) {
            /*We aim to see if we can append the item at nums[i]
              to extend the Longest Increasing Subsequence achieved
              from index 0...j (which is what the cache records)
              We want to solve for maxLength[i] if the value at 'i'
              beats 'j'. If we can we see which is greater between
              these then we have our answer:
              1.) maxLength[i]: The best answer so far for the LIS from 0...i
              2.) maxLength[j] + 1: The value of maxLength[j] is the length
              of the LIS from 0...j, we conceptually "append" this item to
              that LIS by adding 1 to that subproblem answer, yielding a
                potentially new answer for LIS[0..i]*/
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    maxLengthTable[i] = Math.max(maxLengthTable[i], maxLengthTable[j] + 1);
                }
            }
            /*We now have an answer for LIS[0...i]. Compete it against the
           best LIS length found so far.*/
            maximumSoFar = Math.max(maximumSoFar, maxLengthTable[i]);

        }

        //number
        int count = 0;
        for(int k = 0; k < maxLengthTable.length; k++) {
            if(maxLengthTable[k] == maximumSoFar - 1){
                count++;
            }
        }
        System.out.println("Number of longest subsequences are: " + count);
        return maximumSoFar;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        int arr[] = {5, 7, 4, 8};
        int[] arr1 = {5, 4, 1, 0};
        int[] arr2 = {1,3,5,4,7};
        System.out.println(longestIncreasingSubsequence(arr2));
    }
}
