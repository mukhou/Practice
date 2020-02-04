package sortandsearch;

import java.util.Arrays;

/**
 * Time complexity:
 *  Best: Ω(n)
 *  Average: θ(n^2)
 *  Worst: O(n^2)
 */

public class InsertionSort {



    // Cormen approach(pg 16) - COMPLEX
    public static int[] insertionSortCormen(int[] arr){
        // like a pack of cards, start with the first card on the left hand and the pile
        // from next card, keep checking from right to left
        // addWord card in correct position
        // NOTE: j starts from 2nd INDEX, which implies from the second card on the pile
        for(int j = 1; j < arr.length; j++){
            int key = arr[j];
            int i = j - 1;
            while( i >= 0 && arr[i] > key){
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }
        return arr;
    }


    public static void main(String[] args) {
		int[] arr = {10,34,2,56,7,67,1};
		//int[] result = insertionSort(arr);
        int[] result1 = insertionSortCormen(arr);
		//System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));

	}

}
