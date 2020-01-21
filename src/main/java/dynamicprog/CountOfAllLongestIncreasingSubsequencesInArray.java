/* 
User: Urmi
Date: 1/17/2020 
Time: 10:00 AM
*/

package dynamicprog;

import java.util.Arrays;

public class CountOfAllLongestIncreasingSubsequencesInArray {

    private static int countAllLongestIncreasingSubsequences(int[] arr){

        if (arr.length == 0) {
            return 0;
        }

        int[] countTable = new int[arr.length];
        Arrays.fill(countTable, 1);

        // By default the best answer is a length of 1
        int maximumSoFar = 1;

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    countTable[i] = Math.max(countTable[i], countTable[j] + 1);
                }
            }
            maximumSoFar = Math.max(maximumSoFar, countTable[i]);
        }

        System.out.println(Arrays.toString(countTable));

        //count
        //IDEA: we know the maximum length of the subsequence, so any time we see a length
        //less than that, we increase the count.
        int count = 0;
        for(int k = 0; k < countTable.length; k++) {
            if(countTable[k] == maximumSoFar - 1){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr2 = {5, 4, 0, 1};
        System.out.println(countAllLongestIncreasingSubsequences(arr2));
    }

}
