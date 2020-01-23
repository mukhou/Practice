/* 
User: Urmi
Date: 1/22/2020 
Time: 12:30 PM
*/

/**
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of
 * C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 */

package dynamicprog;

import java.util.Arrays;

//watch this video: https://www.youtube.com/watch?v=jgiZlGzXMBw&t=25s
//code: https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ChangeMakingProblem/ChangeMakingProblem.java
public class RepresentMinCoins {

    private static int countMinWays(int[] coins, int amount) {
        // We use this to fill the dp table with default values
        int max = Integer.MAX_VALUE;

        int[] ways = new int[amount + 1];
        Arrays.fill(ways, max);
        /*The answer to making change with minimum coins for 0
          will always be 0 coins no matter what the coins we are given are*/
        ways[0] = 0;

        // Solve every subproblem from 1 to amount
        for(int i = 1; i <= amount; i++){
            // Solve the problem for each coin
            for(int j = 0; j < coins.length; j++){
                // If it is less than or equal to the sub problem amount
                int currentCoin = coins[j];
                if(currentCoin <= i){
                    // calculate ways[i] for all coins < current amount and keep updating it
                    ways[i] = Math.min(ways[i], ways[i - currentCoin] + 1);
                }

            }
        }
        return ways[amount] > amount ? -1 : ways[amount];
    }

    public static void main (String[] args){
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println ( "Minimum coins required is "
                + countMinWays(coins, V));
    }


}
