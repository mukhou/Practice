/* 
User: Urmi
Date: 1/3/2020 
Time: 3:45 PM
*/

/**
 * Given an array, check if the sum of a subarray adds up to zero
 */
package byteBybyte;

//https://www.youtube.com/watch?v=hLcYp67wCcM&feature=emb_rel_pause
// Modification of ContinuousSubArraySum
public class ZeroSumSubarray {

    public static void zeroSubArray(int[] arr){
        int curr_sum = arr[0], start = 0;

        for(int i = 1; i < arr.length; i++){
            if(curr_sum == 0){
                System.out.println("Sum found between indexes and " +
                        String.valueOf(start) + " " + String.valueOf(i - 1));
                return;
            }
            curr_sum += arr[i];

            while (curr_sum > 0 && start < i - 1){
                curr_sum -= arr[start];
                start ++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, -5, 1, 2, -1};
        //int arr[] = {16, 5, 23, 1, 19};
        int n = 15;
        int sum = 24;
        zeroSubArray(arr);


    }
}
