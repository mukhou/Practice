/* 
User: Urmi
Date: 1/10/2020 
Time: 11:27 AM
*/


package crackingcodeinterview;

import java.util.Arrays;

//CTCI pg 355, Q 8.1
public class JumpNStairs {

    public static void main(String[] args){
        System.out.println(countStairs1(3));
    }

    private static int countStairs1(int n){
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return countStairs1(n, arr);
    }

    //For each recursive call(sub-problem), If we've seen this value of n before, return the cached value.
    // Each time we compute a fresh value,
    //add it to the cache.
    private static int countStairs1(int n, int[] arr) {
        if(n < 0){
            return 0;
        }else if( n == 0){
            return 1;
        }else if(arr[n] > -1){
            return arr[n];
        }else {
            arr[n] = countStairs1(n - 1, arr) + countStairs1(n - 2, arr) + countStairs1(n - 3, arr);
            return arr[ n];
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

}
