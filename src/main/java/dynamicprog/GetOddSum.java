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
//IDEA: Count the number of odd and even numbers in both the arrays and the answer to the number of pairs will be
// min(odd1, even2) + min(odd2, even1), because odd + even is only odd.
public class GetOddSum {

    private static int countOfOddSum(int[] a, int[] b) {
        int odd1 = 0, even1 = 0, odd2 = 0, even2 = 0;

        for(int i = 0; i < a.length; i ++){
            if(a[i] % 2 == 1){
                odd1 ++;
            }else {
                even1 ++;
            }
        }

        for(int i = 0; i < b.length; i ++){
            if(b[i] % 2 == 1){
                odd2 ++;
            }else {
                even2 ++;
            }
        }
        int countOfPairs = Math.min(odd1, even2) + Math.min(odd2, even1);
        return countOfPairs;
    }

    public static void main (String[] args){
        int a[] = { 1, 2 };
        int[] b = {3, 6};
        int n = a.length;

        int ans = countOfOddSum(a, b);

        System.out.println(ans);
    }

}
