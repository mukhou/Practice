package hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Very simply, if all elements are odd, then e is a vector of 1's.
 * If one element is even, e is a vector of all 0's except for that one position, which is a 1.
 * If more than one element is even, then e is a vector of 0's.
 * This requires a single pass through t (which is O(N)) to find the quantity of even elements;
 * then you can generate e in O(N) time
 */
public class ArrayProduct {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = {1, 2, 3, 4};
        int[] temp = new int[arr.length];
        int[] res = new int[arr.length];
        int evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                continue;
            }else {
                if(evenCount > 0){

                }
            }
        }
        if(evenCount == 0){
           // temp
        }
    }
}
