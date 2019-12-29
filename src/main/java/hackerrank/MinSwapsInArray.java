/* 
User: Urmi
Date: 12/29/2019 
Time: 3:03 PM
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
