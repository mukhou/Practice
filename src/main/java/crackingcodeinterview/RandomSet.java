/* 
User: Urmi
Date: 12/24/2019 
Time: 11:34 AM
*/

/**
 * Write a method to randomly generate a set of m integers from an array of size n. Each
 * element must have equal probability of being chosen.
 */
package crackingcodeinterview;

import java.util.Random;

//we initialize an array subset to be the first m
//elements in original.Then, we iterate through the array, starting at element m, inserting a r r a y [ i] into
//the subset at (random) position k whenever k < m.
public class RandomSet {

    public static int[] randomSubset(int[] arr, int m){
        int[] subset = new int[m];
        for(int i = 0; i < m; i ++){
            subset[m] = arr[m];
        }
        Random rand = new Random();
        for(int i = 0; i < arr.length; i ++){
            int k = rand.nextInt(i + 1);
            if(k < m){
                subset[k] = subset[i];
            }
        }

        return subset;
    }
}
