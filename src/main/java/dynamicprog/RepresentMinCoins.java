/* 
User: Urmi
Date: 1/22/2020 
Time: 12:30 PM
*/

/**
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of
 * C = { C1, C2, .. , Cm} valued coins, what is the minimum number of COINS to make the change?
 */

package dynamicprog;

import java.util.Arrays;

//watch Jenyy's video for better understanding: https://www.youtube.com/watch?v=J2eoCvk59Rc&t=976s
//watch this video: https://www.youtube.com/watch?v=jgiZlGzXMBw&t=25s
//code: https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ChangeMakingProblem/ChangeMakingProblem.java

/**
 *        |  0  1  2  3  4  5  6
 * []     |  0  M  M  M  M  M  M
 * [1]    |  0  1  2  3  4  5  6
 * [1,5]  |  0  1  2  3  4  1  2
 * [1,5,6]|  0  1  2  3  4  5  1
 */
public class RepresentMinCoins {

    //follow this, SIMILAR TO RepresentCoins(my own implementation)
    private static int countMinWays1(int[] coins, int amount){
        int[][] ways = new int[coins.length + 1][amount + 1];
        //min ways to make 0 change with 0 coins is 0
        ways[0][0] = 0;

        // We use this to fill the top row with default placeholder
        for(int j = 0; j <= amount; j++){
            ways[0][j] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= coins.length; i++){
            //min ways to make change for 0 with any coins is 0
            ways[i][0] = 0;
            int currentCoin = coins[i - 1];
            for(int j = 1; j <= amount; j++){
                int withoutThisCoin = ways[i - 1][j];
                //IMP, withoutThisCoin if current coin > amount
                int withThisCoin = currentCoin <= j ? 1 + ways[i][j - currentCoin] : withoutThisCoin;
                ways[i][j] = Math.min(withoutThisCoin, withThisCoin);
            }
        }
        return ways[coins.length - 1][amount];
    }

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
        int coins1[] = {1, 5, 6, 9};
        int m = coins.length;
        int V = 11;
        int V1 = 10;
        System.out.println ( "Minimum coins required is "
                + countMinWays(coins1, V1));

        System.out.println(countMinWays1(coins1, V1));
    }


}
