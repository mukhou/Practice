/* 
User: Urmi
Date: 1/5/2020 
Time: 1:32 PM
*/

package byteBybyte;

//https://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/
public class LargestPairSumInArray {

    //this is for consecutive/adjacent pair
    public static void largestPairSumConsecutive(int[] arr){
        int maxSum = 0, start = 0, end = 0;
        for(int i = 0; i < arr.length - 1; i++){
            int sumSoFar = arr[i] + arr[i + 1];
            if(sumSoFar > maxSum){
                maxSum = sumSoFar;
                start = arr[i];
                end = arr[i + 1];
            }
        }

        System.out.println(start + " " + end);
    }

    //if asked to find second largest, return secondLargest
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

    //modification: first and last elements should also not be taken together
    public static void largestPairSum1(int[] arr){
        int start, end;
        if(arr[0] > arr[arr.length - 1]){
            start = 0;
            end = arr.length - 1;
        }else {
            start = 1;
            end = arr.length;
        }
        int firstLargest, secondLargest;
        firstLargest = Math.max(arr[start], arr[start + 1]);
        secondLargest = Math.min(arr[start], arr[start + 1]);
        for(int i = start; i < end; i++){
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
        largestPairSum1(new int[]{3, 1, 2, 4});

    }
}
