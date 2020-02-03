/* 
User: Urmi
Date: 1/26/2020 
Time: 9:55 AM
*/

/**
 * Given a change of amount, return true/false on whether change can be made from a fixet set of 5, 10 and 20 dollar bills
 */
package byteBybyte;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    private static boolean canMakeChange(int amount, Map<Integer, Integer> drawer){
        while(amount > 0){
            amount = makeChangeFor20(amount, drawer);
            amount = makeChangeFor10(amount, drawer);
            amount = makeChangeFor5(amount, drawer);
        }
        if(amount == 0){
            return true;
        }else {
            return false;
        }
    }

    private static int makeChangeFor5(int amount, Map<Integer,Integer> drawer) {
        if(amount >= 5){
            int billsAvailable = drawer.get(5);
            int billsNeeded = amount / 5;
            int min = Math.min(billsAvailable, billsNeeded);
            //amount = 45 - (2 * 20)
            amount = amount - (min * 5);
            drawer.put(5, billsAvailable - min);
            return amount;
        }
        return amount;
    }

    private static int makeChangeFor10(int amount, Map<Integer,Integer> drawer) {
        if(amount >= 10){
            int billsAvailable = drawer.get(10);
            int billsNeeded = amount / 10;
            int min = Math.min(billsAvailable, billsNeeded);
            //amount = 45 - (2 * 20)
            amount = amount - (min * 10);
            drawer.put(10, billsAvailable - min);
            return amount;
        }
        return amount;
    }

    private static int makeChangeFor20(int amount, Map<Integer,Integer> drawer) {
        if(amount >= 20){
            int billsAvailable = drawer.get(20);
            int billsNeeded = amount / 20;
            int min = Math.min(billsAvailable, billsNeeded);
            //amount = 45 - (2 * 20)
            amount = amount - (min * 20);
            drawer.put(20, billsAvailable - min);
            return amount;
        }
        return amount;
    }

    public static void main(String[] args){
        Map<Integer, Integer> drawer = new HashMap<>();
        drawer.put(20, 3);
        drawer.put(10, 2);
        drawer.put(5, 1);
        System.out.println(canMakeChange(45, drawer));
    }
}
