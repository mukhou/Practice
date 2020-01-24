/* 
User: Urmi
Date: 12/26/2019 
Time: 11:49 AM
*/

/**
 * The Masseuse: A popular masseuse receives a sequence of back-to-back appointment requests
 * and is debating which ones to accept. She needs a 15-minute break between appointments and
 * therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appointment
 * requests (all multiples of 15 minutes, none overlap, and none can be moved), find the optimal
 * {highest total booked minutes) set the masseuse can honor. Return the number of minutes.
 * EXAMPLE
 * input: {30, 15, 60, 75, 45, 15, 15, 45}
 * Output: 180 minutes ({30, 60, 45, 45 } ) .
 */
package crackingcodeinterview;

//see details on CTCI pg 586
public class MaxMinutes {

    public static void main(String[] args) {
        int[] massages = {2*15, 1*15, 4*15, 5*15, 3*15, 1*15, 1*15, 3*15};
        System.out.println(maxMinutes(massages));
        System.out.println(maxMinutes(massages, 0, new int[massages.length]));
    }

    //PREFERRED APPROACH
    //time complexity: O(n), space complexity: O(1)
    private static int maxMinutes(int[] massages) {
        int oneAway = 0, twoAway = 0;
        for(int i = 0;  i < massages.length; i ++){
            int bestWith = massages[i] + twoAway;
            int bestWithout = oneAway;
            int current = Math.max(bestWith, bestWithout);
            //reset for next iteration
            twoAway = oneAway;
            oneAway = current;
        }
        //return oneAway as that held the last/current value in the last iteration
        return oneAway;
    }

    //OR CAN BE DONE RECURSIVELY WITH ADDITIONAL SPACE
    //time complexity: O(n), space complexity: O(n)
    private static int maxMinutes(int[] massages, int index, int[] memo){
        if(index >= massages.length){
            return 0;
        }

        int bestWith = massages[index] + maxMinutes(massages, index + 2, memo);
        int bestWithout = maxMinutes(massages, index + 1, memo);
        memo[index] = Math.max(bestWith, bestWithout);

        return memo[index];
    }

}
