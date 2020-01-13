/* 
User: Urmi
Date: 1/9/2020 
Time: 4:52 PM
*/

package crackingcodeinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDifferenceFromAListOfNumbers {

    //BAD APPROACH
    public static void findDiff (List<Integer> numList, int diff){
        for(int i = 0; i < numList.size(); i++){
            for(int j = i + 1; j < numList.size(); j++){
                if(Math.abs(numList.get(i) - numList.get(j)) == diff){
                    System.out.println(numList.get(i) + " " + numList.get(j));
                }
            }
        }
    }

    //FOLLOW THIS
    //Time Complexity: O(nlogn)
    public static void findDiffUsingHashMap(int[] arr, int diff){
        Arrays.sort(arr);
        int start = 0, end = 0;

        while(end < arr.length){
            int d = Math.abs(arr[start] - arr[end]);
            if(d == diff){
                System.out.println(arr[start] + " " + arr[end]);
                start ++;
                end ++;
            }else if(d > diff){//increase starting point
                start ++;
            }else {
                end ++;//increase ending point
            }
        }
    }

    public static void main (String[]args){
        int arr[] =  {1, 5, 3, 4, 2};
        int k = 3;
        List<Integer> list = new ArrayList<>();
        for(int n : arr){
            list.add(n);
        }
        findDiff(list, k);
        findDiffUsingHashMap(arr, k);
    }
}
