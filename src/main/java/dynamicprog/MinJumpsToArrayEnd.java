/* 
User: Urmi
Date: 1/15/2020 
Time: 3:57 PM
*/
/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
 * If an element is 0, then cannot move through that element.
 */
package dynamicprog;

//https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MinJumpsToArrayEnd {

    //In this method, we build a jumps[] array from left to right such that jumps[i] indicates
    // the minimum number of jumps needed to reach arr[i] from arr[0]. Finally, we return jumps[n-1].
    //Time Complexity: O(n^2)
    private static int minJumpsDynamic(int[] arr){

        //if first element is 0, no further jumps
        if(arr[0] == 0 || arr.length == 0){
            return Integer.MAX_VALUE;
        }

        // jumps[arr.length - 1] will hold the final result
        int[] jumps = new int[arr.length];
        jumps[0] = 0;//jump to first index is always 0

        //find min no. of jumps from 0 -> i(arr[0] to arr[i]) and assign the value to arr[i]
        for (int currPos = 1; currPos < arr.length; currPos ++) {
            jumps[currPos] = Integer.MAX_VALUE;
            for (int j = 0; j < currPos; j++) {
                //IMP: i <= j + arr[j] is to check if within array bounds
                if (jumps[j] != Integer.MAX_VALUE && currPos <= j + arr[j]) {
                    //take minimum
                    jumps[currPos] = Math.min(jumps[currPos], jumps[j] + 1);
                    break;
                }
            }
        }

        return jumps[arr.length - 1];


    }

    //time complexity: O(n^n)
    private static int minJumps(int[] arr){
        return minJumps(arr, 0, arr.length - 1);
    }
    private static int minJumps(int[] arr, int start, int end) {
        // Base case: when source and destination are same
        if(start == end){
            return 0;
        }
        // When nothing is reachable from the given source
        if(arr[start] == 0){
            return Integer.MAX_VALUE;
        }
        // Traverse through all the points.
        // Recursively get the minimum number of jumps needed to reach arr[h] from these reachable points.
        int min = Integer.MAX_VALUE;
        //IMP i begins with start + 1, assumtpion is we'll always have at least one jump
        for(int i = start + 1; i <= end && i <= start + arr[start]; i++){
            int jumps = minJumps(arr, i, end);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min){
                min = jumps + 1;//adding 1, as we already jumped to start + 1
            }
        }
        return min;
    }


    // Driver code
    public static void main(String args[]){
        int arr[] = { 3, 2, 1, 1, 4 };
        int n = arr.length;
        System.out.println("Minimum number of jumps to reach end is "
                + minJumps(arr));
        System.out.println(minJumpsDynamic(arr));
    }


}
