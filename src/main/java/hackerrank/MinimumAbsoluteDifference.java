package hackerrank;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 2/27/18
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 */
public class MinimumAbsoluteDifference {
    static int minimumAbsoluteDifference(int n, int[] arr){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i ++){
            int temp = Math.abs(arr[i] - arr[i - 1]);
            if(temp < min){
                min = temp;
            }
        }
        return min;
    }
}
