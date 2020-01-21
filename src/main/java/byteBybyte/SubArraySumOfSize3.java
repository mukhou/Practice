/* 
User: Urmi
Date: 1/14/2020 
Time: 3:16 PM
*/

/**
 *
 *  Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
 */
package byteBybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraySumOfSize3 {

    //Time complexity is O(n^2).
    //THIS RETURNS ONLY UNIQUE ELEMENTS
    private static List<List<Integer>> threeSum(int[] arr, int k) {
        // IMP: sort the array
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            //initialize left and right pointers
            int left = i + 1;
            int right = arr.length - 1;

            //IMP: this is the check which PREVENTS DUPLICATE ELEMENTS FROM BEING CONSIDERED IN NEXT ITERATION
            //when current element is same as element on the left
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            while (left < right) {
                //IMP: this is the check which PREVENTS DUPLICATE ELEMENTS FROM BEING CONSIDERED IN NEXT ITERATION
                //when current element is same as element on the right
                if (right < arr.length - 1 && arr[right] == arr[right + 1]) {
                    right--;
                    continue;
                }
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == k) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    result.add(list);
                    left++;
                    right--;
                } else if (sum < k) {
                    left++;
                } else {
                    right --;
                }
            }
        }

        return result;
    }

    //time complexity: o(n ^ 2)
    //THIS HAS DUPLICATES
    private static void findTriplets(int arr[]){
        boolean found = false;
        int n = arr.length;

        // IMP: sort the array
        Arrays.sort(arr);

        //IMP: i goes up to n - 1
        for(int i = 0; i < n - 1; i ++){
           // initialize left and right
            int left = i + 1;
            int right = n - 1;

            while (left < right){
                if(arr[i] + arr[left] + arr[right] == 0){
                    System.out.print(arr[i] + " ");
                    System.out.print(arr[left]+ " ");
                    System.out.println(arr[right]+ " ");
                    left ++;
                    right --;
                    found = true;
                }else if(arr[i] + arr[left] + arr[right] < 0){  // If sum of three elements is less than zero then increment in left
                    left ++;
                }else {
                    right --;
                }
            }
        }


        if (found == false)
            System.out.println(" No Triplet Found");
    }

    //WORST approach: time complexity: O(n^ 3)
    public static void subarraySumOfSize3(int[] arr){
        boolean found = true;
        for(int i = 0; i < arr.length - 2; i ++){
            for(int j = i + 1; j < arr.length - 1; j++){
                for(int k = j + 1; k < arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        System.out.print(arr[i]);
                        System.out.print(" ");
                        System.out.print(arr[j]);
                        System.out.print(" ");
                        System.out.print(arr[k]);
                        System.out.print("\n");
                        found = true;
                    }
                }
            }
        }
        // If no triplet with 0 sum found in array
        if (found == false)
            System.out.println(" not exist ");
    }

    public static void main(String[] args)
    {
        int arr[] = {-2, 0, 1, 1, 2};
        int n = arr.length;
        //subarraySumOfSize3(arr);
        System.out.println(threeSum(arr, 0));

        int[] arr1 = {-2, 0, 0, 2, 2};
        //System.out.println(threeSum(arr1));
        //findTriplets(arr);

    }

}
