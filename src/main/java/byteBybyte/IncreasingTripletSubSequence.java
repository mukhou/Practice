/* 
User: Urmi
Date: 1/16/2020 
Time: 2:03 PM
*/

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 */
package byteBybyte;

import java.util.Arrays;

public class IncreasingTripletSubSequence {

    private static boolean isTripleSequenceLinear(int[] arr){
        if(arr.length == 0){
            return false;
        }
        // Initializing small and large(second smaller)
        // by INT_MAX
        int firstSmallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        int i;
        for(i = 0; i < arr.length; i++){
            // Update small for smallest value of array
            if(arr[i] <= firstSmallest){
                firstSmallest = arr[i];
            }else if(arr[i] <= secondSmallest){
                secondSmallest = arr[i];
            }else {
                break;
            }
        }
        if(i == arr.length){
            return false;
        }else {
            return true;
        }
    }

    //time complexity: O(n)
    //space complexity: O(1)
    //https://www.geeksforgeeks.org/sorted-subsequence-size-3-linear-time-using-constant-space/
    //Algorithm:
    //As we are looking for sequence of length 3, at each index we can maintain smallest value we’ve got so far
    // and second smallest value after smallest value’s index. Now if we reach to an index,
    // whose value is larger than second smallest value, then we found our solution
    // because we already maintained a sorted pair and we just found an element which is larger than both,
    // so we found a 3 length sorted subsequence of array.
    private static void findTripleSequenceLinear(int[] arr){
        if(arr.length == 0 || arr.length < 3){
            return;
        }
        // Initializing small and large(second smaller)
        // by INT_MAX
        int i;
        int firstSmallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for(i = 0; i < arr.length; i++){
            // Update small for smallest value of array
            if(arr[i] <= firstSmallest){
                firstSmallest = arr[i];
            }else if(arr[i] <= secondSmallest){
                secondSmallest = arr[i];
            }else {
                // If we reach here, we found 3 numbers in
                // increasing order : small, large and arr[i]
                break;
            }
        }
        if (i == arr.length){
            System.out.println("No such triplet found");
            return;
        }
        // last and second last will be same, but first
        // element can be updated retrieving first element
        // by looping upto i
        for (int j = 0; j <= i; j++){
            if (arr[j] < secondSmallest){
                firstSmallest = arr[j];
                break;
            }
        }
        System.out.println(firstSmallest + " "+ secondSmallest + " " + arr[i]);
    }


    //time complexity: O(n^2)
    //space complexity: O(n)
    private static boolean isTripleSequence(int[] arr){
        if(arr.length == 0){
            return false;
        }

        boolean result = false;
        int[] countTable = new int[arr.length];
        Arrays.fill(countTable, 1);
        int maximumSoFar = 1;

        //Test every possible end index of a longest increasing subsequence
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    countTable[i] = Math.max(countTable[i], countTable[j] + 1);
                    if(countTable[i] == 3){
                        result = true;
                        break;
                    }
                }
            }

            maximumSoFar = Math.max(maximumSoFar, countTable[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 4, 5 };
        int arr[] = {5, 7, 4, 8};
        int[] arr1 = {5, 4, 1, 0, 2, 7};
        System.out.println(isTripleSequence(arr1));
        findTripleSequenceLinear(arr1);
        System.out.println(isTripleSequenceLinear(arr1));

    }
}
