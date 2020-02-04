/* 
User: Urmi
Date: 12/19/2019 
Time: 12:56 PM
*/


/**
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order,
 */
package crackingcodeinterview;

//IDEA: if we addWord an element into the front of A, then we'll have to shift the existing
//elements backwards to make room for it. It's better to addWord elements into the back of the array, where
//there's empty space.
//CTCI Q 10.1

import java.util.Arrays;

/** Merges array
 * @param a first array
 * @param b second array
 * @param countA number of "real" elements in a
 * @param countB number of "real" elements in b
 */
public class MergeOneArayintoABigSortedArray {
    public static int[] merge(int[] a, int[]b, int countA, int countB){
        int indexA = countA - 1;//99
        int indexB = countB - 1;//49
        int indexMerged = countA + countB - 1;

        //iterate over b array
        while(indexB >= 0){
            if(indexA >= 0 && a[indexA] > b[indexB]){
                a[indexMerged] = a[indexA];
                indexA--;
            }else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
        return a;

    }

    public static void main(String[] args){
        int[] a = {10, 14, 19, 20, 30, 0, 0};
        int[] b = {25, 40};
        System.out.println(Arrays.toString(merge(a, b, 5, b.length)));

    }
}
