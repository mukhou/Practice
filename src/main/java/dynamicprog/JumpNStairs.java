/* 
User: Urmi
Date: 1/10/2020 
Time: 11:27 AM
*/


package dynamicprog;

import java.util.Arrays;

//CTCI pg 355, Q 8.1
public class JumpNStairs {

    private static int countStairs1(int n){
        int[] jumps = new int[n + 1];
        Arrays.fill(jumps, -1);
        return countStairs1(n, jumps);
    }

    //For each recursive call(sub-problem), If we've seen this value of n before, return the cached value.
    // Each time we compute a fresh value,
    //add it to the cache.
    private static int countStairs1(int n, int[] jumps) {
        if(n < 0){
            return 0;
        }else if( n == 0){
            return 1;
        }else if(jumps[n] > -1){
            return jumps[n];
        }else {
            //recursively calculate sub problems
            jumps[n] = countStairs1(n - 1, jumps) + countStairs1(n - 2, jumps) + countStairs1(n - 3, jumps);
            return jumps[n];
        }
    }

    //BAD APPROACH(just like fibonacci)
    //TIME COMPLEXITY: o(n ^ 3)
    private static long countStairs(long n){
        if(n < 0){
            return 0;
        }else if(n == 0){
            return 1;
        }else {
            return countStairs(n - 1) + countStairs(n - 2) + countStairs(n - 3);
        }
    }


    public static void main(String[] args){
        System.out.println(countStairs1(3));
        System.out.println(countStairs(3));
    }

}
