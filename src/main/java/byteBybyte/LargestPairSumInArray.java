/* 
User: Urmi
Date: 1/5/2020 
Time: 1:32 PM
*/

package byteBybyte;

//https://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/
public class LargestPairSumInArray {

    //this is for consecutive pair
    public static void largestPairSumConsecutive(int[] arr){
        int maxSum = 0, sumSoFar = 0,  start = 0, end = 0;
        for(int i = 0; i < arr.length - 1; i++){
            sumSoFar = arr[i] + arr[i + 1];
            if(sumSoFar > maxSum){
                maxSum = sumSoFar;
                start = arr[i];
                end = arr[i + 1];
            }
        }

        System.out.println(start + " " + end);
    }

    public static void largestPairSum(int[] arr){
        int firstLargest, secondLargest;
        firstLargest = Math.max(arr[0], arr[1]);
        secondLargest = Math.min(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            int curr = arr[i];
            if(curr > firstLargest){
                secondLargest = firstLargest;
                firstLargest = curr;
            }
            else if(curr > secondLargest && curr < firstLargest){
                secondLargest = curr;
            }
        }
        System.out.println(firstLargest + " " + secondLargest);
    }

    public static void main(String[] args){
        largestPairSumConsecutive(new int[]{1, 3, 2, 4});
        largestPairSum(new int[]{1, 3, 2, 4});

    }
}
