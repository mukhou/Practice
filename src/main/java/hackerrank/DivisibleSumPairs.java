/* 
User: Urmi
Date: 12/27/2019 
Time: 1:54 PM
*/

package hackerrank;

//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
public class DivisibleSumPairs {

    public static void main(String[] args){

        int[] arr = {1, 3, 2, 6, 1, 2};
        int k = 3;
        System.out.println(divisibleSumPairs(arr, k));


    }
    static int divisibleSumPairs(int[] arr, int k){
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
//                if(arr[i] >= arr[j]){
//                    continue;
//                }
                if((arr[i] + arr[j]) % k == 0){
                    count++;
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
        return count;
    }
}
