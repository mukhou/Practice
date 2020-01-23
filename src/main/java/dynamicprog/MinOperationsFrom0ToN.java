/* 
User: Urmi
Date: 1/15/2020 
Time: 10:54 PM
*/

/**
 * You are given a number N. You have to find the minimum number of operations required to reach N from 0.
 * You have 2 operations available:
 * Double the number
 * Add one to the number
 */
package dynamicprog;

public class MinOperationsFrom0ToN {

    private static int minOper1(int n) {
        int count = 0;
        while (n > 0){
            if(n % 2 == 0){
                n /= 2;
                count ++;
            }else {
                n -= 1;
                count ++;
            }
        }
        return count;
    }

    /*private static int minOper(int n) {
        int count = 1, start = 1;
        while (start <= n){
            if(start % 2 == 0){
                start *= 2;
                count ++;
            }else {
                start += 1;
                count ++;
            }
        }
        return count;
    }*/


    public static void main(String args[]){
        System.out.println(minOper1(7));
        //System.out.println(minOper(7));
    }
}
