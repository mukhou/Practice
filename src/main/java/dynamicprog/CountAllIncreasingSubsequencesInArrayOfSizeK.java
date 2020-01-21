/* 
User: Urmi
Date: 1/17/2020 
Time: 11:19 AM
*/

/**
 * Given an array arr[] containing n integers. The problem is to count number of increasing subsequences in the array of size k.
 * Input : arr[] = {2, 6, 4, 5, 7}, k = 3
 * Output : 5
 * The subsequences of size '3' are:
 * {2, 6, 7}, {2, 4, 5}, {2, 4, 7},
 * {2, 5, 7} and {4, 5, 7}.
 */
package dynamicprog;

//https://www.geeksforgeeks.org/count-number-increasing-subsequences-size-k/
public class CountAllIncreasingSubsequencesInArrayOfSizeK {

    //Time Complexity: O(kn2).
    //Auxiliary Space: O(kn).
    private static int countAllIncreasingSubsequencesOfSizeK(int[] arr, int k){
        if (arr.length == 0) {
            return 0;
        }

        int[][] countTable = new int[k][arr.length];
        //The idea is to use stored precomputed results in a dp table.
        // countTable[i][j] stores the count of increasing subsequences of size i ending with element arr[j].
        for(int i = 0; i < arr.length; i++){
            // default value count of increasing subsequences of size 1 ending at each arr[i]
            countTable[0][i] = 1;//A single item for siza k = 0 is neither increasing or decreasing
        }


        // building up the matrix dp[][]. Here 'l' signifies the size of increasing subsequence of size (l+1).
        //ATM: THE OUTERMOST LOOP IS JUST FOR CONTROLLING SIZE OF SUBESQUENCE,
        for(int len = 1; len < k; len++){
            // for each increasing subsequence of size 'l' ending with element arr[i]
            for(int i = len; i < arr.length; i ++){
                // count of increasing subsequences of size 'l' ending with element arr[i]
                //initialize position (len, i) to 0
                countTable[len][i] = 0;
                for(int j = len - 1; j < i; j++){
                    if(arr[i] > arr[j]){
                        //EXACTLY LIKE CountAllIncreasingSubsequencesInArray logic: countTable[i] += countTable[j];
                        countTable[len][i] += countTable[len - 1][j];
                    }
                }
            }
        }

        // sum up the count of increasing subsequences of size 'k'
        // ending at each element arr[i]
        int count = 0;
        for(int i = k - 1; i < arr.length; i++){
            count += countTable[k - 1][i];
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 4, 5, 7};
        System.out.println(countAllIncreasingSubsequencesOfSizeK(arr, 3));
    }
}
