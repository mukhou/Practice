/* 
User: Urmi
Date: 12/24/2019 
Time: 10:58 AM
*/

/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other words, each
 * of the 52! permutations of the deck has to be equally likely. Assume that you are given a random
 * number generator which is perfect.
 */
package crackingcodeinterview;

import java.util.Random;

//see explanation from book, pg 543
public class ShuffleCards {

    public static int[] shuffle(int[] arr){
        Random random = new Random();
        for(int i = 0; i < arr.length; i++){
            int k = random.nextInt(i + 1);
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
