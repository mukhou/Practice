/* 
User: Urmi
Date: 1/3/2020 
Time: 2:28 PM
*/

package crackingcodeinterview;

import java.util.Arrays;

//https://www.geeksforgeeks.org/find-two-missing-numbers-set-1-an-interesting-linear-time-solution/
public class TwoMissingNumbers {



    public static void main(String[] args)
    {
        int arr[] = {1, 3, 5, 6};

        // Range of numbers is 2 plus size of array
        int n = arr.length + 2;

        findTwoMissingNumbers(arr, n);
        findTwoMissingNumbers1(arr, n);

    }

    //  time complexity: O(n)
    //  Extra Space O(n)
    private static void findTwoMissingNumbers1(int[] arr, int n) {
        int arrSum = getSum(arr);
        int totalSum = n * (n + 1) / 2;
        int sumOfTwoMissing = totalSum - arrSum;
        int avg = sumOfTwoMissing / 2;
        int sumOfNosBelowAvg = 0;
        for(int i : arr){
            if(i <= avg){
                sumOfNosBelowAvg += i;
            }
        }
        int totalSumTillAvg = avg * (avg + 1) / 2;
        int firstMissing = totalSumTillAvg - sumOfNosBelowAvg;
        int secondMissing = sumOfTwoMissing - firstMissing;
        System.out.println("numbers are " + firstMissing + " " + secondMissing);
    }

    private static int getSum(int[] arr) {
        return Arrays.stream(arr).reduce(Integer::sum).getAsInt();
    }

    //  time complexity: O(n)
    //  Extra Space O(n)
    private static void findTwoMissingNumbers(int[] arr, int n) {
        boolean[] mark = new boolean[n + 1];

        for(int i : arr){
            mark[i] = true;
        }

        for(int i = 1; i <= n; i++){
            if(!mark[i]){
                System.out.println("number is " + i);
            }
        }
    }
}
