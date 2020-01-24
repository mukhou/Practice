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

    //DOESN'T WORK IF ARRAY HAS 0 AS AN ELEMENT, FOLLOW BELOW METHOD
    public static Set<Integer> findDups(int[] arr){
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0){
                result.add(Math.abs(arr[i]));
            }else {
                //make the element at index negative
                arr[index] = - arr[index];
            }
        }

        //reset the negative elements
        for(int i = 0; i < arr.length; i++){
            arr[i] = - arr[i];
        }
        return result;

    }

    //BAD APPROACH
    public static void findDuplicates(int[] arr){
        Set<Integer> set = new HashSet<Integer>();
        for(int n : arr){
            if(!set.contains(n)){
                set.add(n);
            }else{
                System.out.println(n);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(findDups(new int[]{0, 1, 1, 1}));
    }

}
