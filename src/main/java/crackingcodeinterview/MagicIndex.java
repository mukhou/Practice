/**
 * A magic index in an array A ( l . .. n - 1 ] is defined to bean index such that A [ i ] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
 * array A, What if the values are not distinct?
 */

package crackingcodeinterview;

public class MagicIndex {

   public int magic(int[] array){
        return magicIter(array, 0, array.length - 1);
    }

    private int magicIter(int[] arr, int start, int end) {
       if(start > end){
           return -1;
       }

       int midIndex = (start + end) / 2;
       int midValue = arr[midIndex];

       if(midValue == arr[midIndex]){
           return midIndex;
       }

       //search left
       int leftIndex = Math.min(midIndex - 1, midValue);
       int leftValue = magicIter(arr, start, leftIndex);
       if(leftValue >= 0){
           return leftValue;
       }

        //search right
        int rightIndex = Math.min(midIndex + 1, midValue);
        int rightValue = magicIter(arr, start, rightIndex);
        if(rightValue >= 0){
            return leftValue;
        }

        return -1;
    }

    public static int magicRecur(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid){
            return magicRecur(array, start, mid - 1);
        } else {
            return magicRecur(array, mid + 1, end);
        }
    }


}
