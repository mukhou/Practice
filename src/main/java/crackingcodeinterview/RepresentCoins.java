/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
package crackingcodeinterview;

//CTCI pg 374
public class RepresentCoins {


    //FOLLOW THIS, TIME EFFICIENT
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
        int ways = ways(10, denoms);
        System.out.println(ways);
        ways = ways1(10, denoms, 0);
        System.out.println(ways);
        System.out.println(makeChange(10, denoms));
    }


}
