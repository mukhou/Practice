/**
 * A magic index in an array A ( l . .. n - 1 ] is defined to be an index such that A [ i ] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
 * array A, What if the values are not distinct?
 */

package crackingcodeinterview;

//CTCI pg 359
//IMP CHECK BOTH METHODS FOR duplicates and unique
//NOTE: ARRAY IS SORTED
public class MagicIndex {

    //brute force solution
    public int magic1(int[] arr){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == i){
                return i;
            }
        }
        return -1;
    }

    public int magic(int[] array){
        //return magicWithUniqueElements(array, 0, array.length - 1);
        return magicWithDuplicates(array, 0, array.length - 1);
    }


    //time complexity: O(n log n)
    //ASSUMPTION: all elements are distinct
    //initial call: (arr, 0, arr.length - 1)
    public static int magicWithUniqueElements(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid){
            return magicWithUniqueElements(array, start, mid - 1);
        } else {
            return magicWithUniqueElements(array, mid + 1, end);
        }
    }

    //elements can be duplicate
    //see detailed explanation on CTCI pg 359
    private int magicWithDuplicates(int[] arr, int start, int end) {
       if(start > end){
           return -1;
       }

       int midIndex = (start + end) / 2;
       int midValue = arr[midIndex];

       if(midValue == midValue){
           return midIndex;
       }

       //search left: find minimum of these tow values
       int leftIndex = Math.min(midIndex - 1, midValue);
       int leftValue = magicWithDuplicates(arr, start, leftIndex);
       if(leftValue >= 0){
           return leftValue;
       }

        //search right: find maximum of these two values
        int rightIndex = Math.max(midIndex + 1, midValue);
        int rightValue = magicWithDuplicates(arr, rightIndex, end);

        return rightValue;
    }



}
