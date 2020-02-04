/* 
User: Urmi
Date: 1/15/2020 
Time: 5:44 PM
*/

package crackingcodeinterview;

import java.util.Arrays;
import java.util.HashMap;

public class FindIndicesFromAListOfNumbers {


    //Given an array of integers, return indices of the two numbers such that they addCharacter up to a specific target.e.
    public static int[] findIndicesOfSum(int[] arr, int sum) {
        if(arr == null || arr.length < 2)
            return new int[]{0,0};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                return new int[]{map.get(arr[i]), i};
            }else{
                map.put(sum - arr[i], i);
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findIndicesOfSum(new int[]{3, 2, 4}, 6)));
    }
}
