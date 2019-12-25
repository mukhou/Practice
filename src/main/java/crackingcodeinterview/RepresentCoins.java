/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
 * pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
package crackingcodeinterview;

public class RepresentCoins {

    public static int ways(int total, int[] denoms){
        return ways(total, denoms, 0);
    }

    private static int ways(int total, int[] denoms, int index) {
        int coin = denoms[index];
        if(index == denoms.length - 1){
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }

        int ways = 0;
        for(int amount = 0; amount < total; amount += coin){
            ways += ways(total - amount, denoms, index + 1);
        }
        return ways;
    }
}
