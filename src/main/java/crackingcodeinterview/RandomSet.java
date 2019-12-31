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

import java.util.Arrays;
import java.util.Random;

//we initialize an array subset to be the first m elements in original.
// Then, we iterate through the array, starting at element m, inserting array[i] into
//the subset at (random) position k whenever k < m.
//CTCI pg 544, Q 17.3
public class RandomSet {

    public static int[] randomSubset(int[] original, int m){
        if (m > original.length) return null;

        int[] subset = new int[m];

        /* Fill in subset array with first part of original array */
        for(int i = 0; i < m; i ++){
            subset[i] = original[i];
        }

        Random rand = new Random();

        /* Go through rest of original array. */
        for(int i = m; i < original.length; i ++){
            int k = rand.nextInt(i + 1);
            if(k < m){
                subset[k] = original[i];
            }
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] set = randomSubset(cards, 4);
        System.out.println(Arrays.toString(set));
    }
}
