/* 
User: Urmi
Date: 12/29/2019 
Time: 3:03 PM
*/

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 */

package hackerrank;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem
public class MinSwapsInArray {

    static int minimumSwaps(int[] arr) {
        int swap = 0;
        boolean visited[] = new boolean[arr.length];

        for(int i = 0; i < arr.length; i ++){
            int j = i,cycle = 0;

            while(!visited[j]){
                visited[j] = true;
                j = arr[j] - 1;
                cycle ++;
            }

            if(cycle != 0)
                swap += cycle - 1;
        }
        return swap;
    }

    public static void main(String[] args){
        int[] arr = {4, 3, 1, 2};
        System.out.println(minimumSwaps(arr));
    }

}
