/* 
User: Urmi
Date: 1/15/2020 
Time: 11:34 AM
*/

package byteBybyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraySumOfSize4 {

    private static List<List<Integer>> fourSum(int[] arr, int k) {

        List<List<Integer>> result = new ArrayList<>();
        //base case
        if(arr == null|| arr.length<4) {
            return null;
        }
        // IMP: sort the array
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {

            //IMP: this is the check which PREVENTS DUPLICATE ELEMENTS FROM BEING CONSIDERED IN NEXT ITERATION
            //when current element is same as element on the left
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for(int j = i + 1; j < arr.length - 2; j++){
                //IMP: this is the check which PREVENTS DUPLICATE ELEMENTS FROM BEING CONSIDERED IN NEXT ITERATION
                //when current starting element is same as element on the left
                //NOTE: j starts from (i + 1) so check on j > i + 1
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                //initialize left and right pointers
                int left = j + 1;
                int right = arr.length - 1;

                while (left < right) {
                    //IMP: this is the check which PREVENTS DUPLICATE ELEMENTS FROM BEING CONSIDERED IN NEXT ITERATION
                    //when current element is same as element on the right
                    if (right < arr.length - 1 && arr[right] == arr[right + 1]) {
                        right--;
                        continue;
                    }

                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if ( sum == k) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
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

        }

        return result;
    }


    //THIS HAS DUPLICATES
    //Time Complexity : O(n^3)
    private static void findQuartlets(int arr[], int k){
        int n = arr.length;

        // IMP: sort the array
        Arrays.sort(arr);

        //IMP: i goes up to n - 3
        for(int i = 0; i < n - 3; i ++){
            for(int j = i + 1; j < n - 2; j++){
                int left = j + 1;
                int right = n - 1;

                while (left < right){
                    if(arr[i] + arr[j] + arr[left] + arr[right] == k){
                        System.out.print(arr[i] + " ");
                        System.out.print(arr[j] + " ");
                        System.out.print(arr[left]+ " ");
                        System.out.println(arr[right]+ " ");
                        left ++;
                        right --;
                    }else if(arr[i] + arr[j] + arr[left] + arr[right] < k){
                        left ++;
                    }else {
                        right --;
                    }
                }
            }
        }
    }

    //WORST approach: time complexity: O(n^ 4)
    public static void subarraySumOfSize4(int[] arr){
        boolean found = true;
        for(int i = 0; i < arr.length - 3; i ++){
            for(int j = i + 1; j < arr.length - 2; j++){
                for(int k = j + 1; k < arr.length - 1; k++){
                    for(int l = k + 1; l < arr.length; l ++){
                        if(arr[i] + arr[j] + arr[k] + arr[l] == 0){
                            System.out.print(arr[i]);
                            System.out.print(" ");
                            System.out.print(arr[j]);
                            System.out.print(" ");
                            System.out.print(arr[k]);
                            System.out.print("\n");
                            System.out.print(arr[l]);
                            System.out.print("\n");
                            found = true;
                        }
                    }

                }
            }
        }
        // If no triplet with 0 sum found in array
        if (found == false)
            System.out.println(" not exist ");
    }


    // Driver program to test above functions
    public static void main(String[] args){
        int A[] = {1, 4, 45, 6, 10, 12};
        //int[] arr = {-1, 0, 1, 2, -1, -4};
        //int[] arr = {-2, 1, 1, 0, 0, -2};
        int[] arr = {1, 0, -1, 0, -2, 2};
        int X = 21;
        //findQuartlets(arr, 2);
        System.out.println("$$$$$$$$$$$$$$$$$");
        System.out.println(fourSum(arr, 0));
        System.out.println("$$$$$$$$$$$$$$$$$");
        //System.out.println(fourSumX(arr, 0));
    }
}
