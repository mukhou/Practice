/* 
User: Urmi
Date: 1/17/2020 
Time: 9:57 PM
*/

/**
 * Given N pairs of numbers. The task is to count ways to choose exactly one number from each pair such that
 * the sum of those numbers is odd.
 * Input:
 * N = 2
 * 3 4
 * 1 2
 * Output: 2
 * Explanation:
 * We can choose 3 from the first pair and 2 from the second pair, and their sum is 5 which is odd.
 * Also, we can choose 4 from the first pair and 1 from the second pair, and their sum is 5 which is odd.
 * So the total possible ways will be 2.
 */
package dynamicprog;

//https://www.geeksforgeeks.org/count-number-of-ways-to-get-odd-sum/
public class GetOddSum {

    private static int countOfOddSum(int[][] a, int n) {
        int[] oddNums = new int[a.length];
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            int[] nums = a[i];
            for(int k = 0; k < nums.length; k++){
                if(nums[k] % 2 == 1){
                    sum += nums[k];
                    break;
                }
            }
        }
        return sum;
    }

    public static void main (String[] args){
        int a[][] = {{ 1, 2 }, { 3, 6 }};
        int n = a.length;

        int ans = countOfOddSum(a, n);

        System.out.println(ans);
    }

}
