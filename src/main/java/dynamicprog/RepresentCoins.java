/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
package dynamicprog;

import java.util.Arrays;

//CTCI pg 374
//https://www.geeksforgeeks.org/coin-change-dp-7/
//watch this video: https://www.youtube.com/watch?v=DJ4a7cmjZY0
//https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/ChangeMakingProblem2/ChangeMakingProblem2.java

/**
 *        |  0  1  2  3  4  5
 * []     |  1  0  0  0  0  0
 * [1]    |  1  1  1  1  1  1
 * [1,2]  |  1  1  2  2  3  3
 * [1,2,5]|
 */
public class RepresentCoins {

    //FOLLOW THIS
    //Time Complexity: O(mn)
    private static int countWaysDyn(int[] coins, int amount){
        int[][] ways = new int[coins.length + 1][amount + 1];//coins on rows, amounts on cols
        //Max ways to make change for 0 will be 1, doing nothing.
        ways[0][0] = 1;
        //i starts from 1, because for the first row, it's an empty list of coins, []
        for(int i = 1; i <= coins.length; i++){
            //for first column(make change for amount 0, ways will ALWAYS BE 1, give nothing)
            ways[i][0] = 1;
            //IMP: current coin is coins[i - 1] and not coins[i], as the coin array is still 0 index based
            int currentCoin = coins[i - 1];
            /* waysTable[i][j] will be the sum of the ways to make change:
             * 1. not considering this coin:(waysTable[i-1][j]) and
             * 2. considering this coin(waysTable[i][j - currentCoinValue] ONLY if currentCoinValue <= j,
             * otherwise this coin can not contribute to the total # of ways to make change at this sub problem target*/
            for(int j = 1; j <= amount; j++){//j represents current amount
                int withoutThisCoin = ways[i - 1][j];
                int withThisCoin = currentCoin <= j ? ways[i][j - currentCoin] : 0;
                ways[i][j] = withoutThisCoin + withThisCoin;
            }
        }
        //The answer considering ALL coins for the FULL amount is what we want to return
        return ways[coins.length][amount];

    }



    //simple but difficult to understand
    private static long countWays(int coins[], int total){
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[total+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < coins.length; i ++) {
            int currentCoin = coins[i];
            for (int j = currentCoin; j <= total; j++) {
                table[j] += table[j - currentCoin];
            }

        }
        return table[total];
    }


    //CTCI way
    private static int makeChange(int total, int[] denoms) {
        int[][] table = new int[total + 1][denoms.length];
        return makeChangeHelper(total, denoms, 0, table);

    }
    private static int makeChangeHelper(int total, int[] denoms, int index, int[][] table) {
        /* Check cache for prior result. */
        if (table[total][index] > 0) { // retrieve value
            return table[total][index];
        }

        int coin = denoms[index];
        if (index == denoms.length - 1) {
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }
        int numberOfWays = 0;
        /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
        for (int amount = 0; amount <= total; amount += coin) {
            numberOfWays += makeChangeHelper(total - amount, denoms, index + 1, table); // go to next denom
        }

        /* Update cache with current result. */
        table[total][index] = numberOfWays;

        return numberOfWays;
    }

    public static int ways(int total, int[] denoms){
        return ways(total, denoms, 0);
    }

    //NOT OPTIMAL, TAKES EXPONENTIAL TIME
    private static int ways1(int total, int[] denoms, int index) {

        int coin = denoms[index];

        if(index == denoms.length - 1){
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }

        int ways = 0;
        /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
        for(int amount = 0; amount <= total; amount += coin){
           ways += ways(total - amount, denoms, index + 1);
        }
        return ways;
    }


    //OR
    private static int ways(int total, int[] denoms, int index) {

        int amount = denoms[index];

        if(index == denoms.length - 1){
            int remaining = total % amount;
            return remaining == 0 ? 1 : 0;
        }

        int ways = 0;
        /* Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest). */
        for(int i = 0; i * amount <= total; i ++){
            int remainingAmount = total - i * amount;
            ways += ways(remainingAmount, denoms, index + 1);
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] denoms = {25, 10, 5, 1};
        /*int ways = ways(10, denoms);
        System.out.println(ways);
        ways = ways1(10, denoms, 0);
        System.out.println(ways);
        System.out.println(makeChange(10, denoms));
        System.out.println(countWays(denoms, 10));*/
        System.out.println(countWaysDyn(denoms, 10));
    }


}
