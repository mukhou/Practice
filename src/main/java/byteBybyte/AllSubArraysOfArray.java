/* 
User: Urmi
Date: 1/8/2020 
Time: 5:45 PM
*/

//https://www.geeksforgeeks.org/generating-subarrays-using-recursion/
package byteBybyte;

public class AllSubArraysOfArray {

    //time complexity: O(n^2)
    public static void allSubArrYsWithRecursion(int[] arr, int start, int end){
        // Stop if we have reached the end of the array
        if(end == arr.length){
            return;
        }else if(start > end){ // Increment the end point and start from 0
            allSubArrYsWithRecursion(arr, 0, end + 1);
        }else {
            // Print the subarray and increment the starting point
            System.out.print("[");
            for(int i = start; i < end; i++){
                System.out.print(arr[i] + ", ");
            }
            System.out.println(arr[end] + "]");
            allSubArrYsWithRecursion(arr, start + 1, end);
        }
    }

    //BAD APPROACH
    //time complexity: O(n^3)
    public static void allSubArrYsWithIteration(int[] arr){
        int n = arr.length;
        for(int i = 0; i < arr.length; i ++){
            for(int j = i; j < arr.length; j++){
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k] + " ");
                }
            }
        }
    }

    public static void main(String args[])
    {
        int []arr = {1, 2, 3};
        allSubArrYsWithIteration(arr);
        allSubArrYsWithRecursion(arr, 0, 0);

    }
}
