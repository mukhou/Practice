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

//IDEA: if we insert an element into the front of A, then we'll have to shift the existing
//elements backwards to make room for it. It's better to insert elements into the back of the array, where
//there's empty space.

public class MergeOneArayintoABigSortedArray {
    public void merge(int[] a, int[]b, int lastA, int lastB){
        int indexA = lastA - 1;//99
        int indexB = lastB - 1;//49
        int indexMerged = lastA + lastB - 1;

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

    }
}
