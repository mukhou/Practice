/* 
User: Urmi
Date: 1/9/2020 
Time: 4:05 PM
*/

package byteBybyte;

//Wallmart Labs question
public class LargestContinuousProductInAnArray {

    public static int findContinuousProduct(int[] arr){

        // Variables to store maximum and minimum
        // product till ith index.
        int minVal = arr[0], maxVal = arr[0], maxProduct = arr[0];

        for (int i = 1; i < arr.length; i++){
            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (arr[i] < 0){
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            // maxVal and minVal stores the product of subarray ending at arr[i].
            //similar to LargestContinuousSubArraySum: curr_max = Math.max(arr[i], curr_max + arr[i]);
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }
        // Return maximum product found in array.
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -2, 4 };//new int[]{-4, -1, 2, 5, -9, 7, 10};
        System.out.println(findContinuousProduct(arr));

    }
}
