/* 
User: Urmi
Date: 12/19/2019 
Time: 3:31 PM
*/

/**
 * In an array of integers, a "peak" is an element which is greater than or equal
 * to the adjacent integers and a "valley" is an element which is less than or equal to the adjacent
 * integers. For example, in the array (5, 8, 6, 2, 3, 4, 6}, (8,6} are peaks and {5, 2} are valleys.
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 */
package crackingcodeinterview;

import java.util.Arrays;

import static sortandsearch.QuickSort.swap;

public class PeaksAndValleys {

    public static int[] arrange(int[] arr){
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i +=2){
            swap(arr, i - 1, i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
        System.out.println(Arrays.toString(arrange(array)));
    }
}
