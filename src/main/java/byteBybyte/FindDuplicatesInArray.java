/* 
User: Urmi
Date: 1/3/2020 
Time: 8:20 PM
*/

/**
 * Given an array of integers where each value 1 <= x <= len(array), write a function that finds all the duplicates in the array.
 */
package byteBybyte;

import java.util.HashSet;
import java.util.Set;

//https://www.byte-by-byte.com/findduplicates/
public class FindDuplicatesInArray {

    public static Set<Integer> findDups(int[] arr){
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0){
                result.add(arr[i]);
            }else {
                arr[index] = - arr[index];
            }
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = - arr[i];
        }
        return result;

    }

    public static void main(String[] args){
        System.out.println(findDups(new int[]{2, 1, 2, 1}));
    }

}
