/* 
User: Urmi
Date: 1/17/2020 
Time: 9:50 AM
*/

/**
 * We are given an array of digits (values lie in range from 0 to 9).
 * The task is to count all the sub sequences possible in array such that in each subsequence every digit is greater than
 * its previous digits in the subsequence.
 * Input : arr[] = {4, 3, 6, 5}
 * Output: 8
 * Sub-sequences are {4}, {3}, {6}, {5},
 * {4,6}, {4,5}, {3,6}, {3,5}
 */
package dynamicprog;

import java.util.Arrays;

//https://www.geeksforgeeks.org/count-all-increasing-subsequences/
//CODE: https://ide.geeksforgeeks.org/cLGaNg
public class CountAllIncreasingSubsequencesInArray {

    //A Simple Solution is to use Dynamic Programming Solution of Longest Increasing Subsequence (LIS) problem.
    // Like LIS problem, we first compute count of increasing subsequences ending at every index.
    // Finally, we return sum of all values (In LCS problem, we return max of all values).
    //Time Complexity : O(n2)
    //Auxiliary Space : O(n)
    private static int countAllIncreasingSubsequences(int[] arr){

        if (arr.length == 0) {
            return 0;
        }

        int[] countTable = new int[arr.length];
        Arrays.fill(countTable, 1);

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    //Similar to LIS, only NO NEED TO FIND MAX, JUST INCREASE COUNT
                    countTable[i]+= countTable[j];
                }
            }
        }

        //count
        int count = 0;
        for(int k = 0; k < countTable.length; k++) {
            count += countTable[k];
        }
        //System.out.println("Number of longest subsequences are: " + count);
        return count;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        int arr[] = {3, 2, 4, 5, 4};
        int[] arr1 = {5, 4, 1, 0};
        int[] arr2 = {1, 3, 5, 4, 7};
        System.out.println(countAllIncreasingSubsequences(arr));
    }
}
