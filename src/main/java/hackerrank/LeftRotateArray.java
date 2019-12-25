package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/4/18
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 */
public class LeftRotateArray {
    //IDEA is for each rotation, the first element arr[0] gets placed at the last position [arr.length - 1]
    //rest elements move by 1 position to the left
    static int[] leftRotation(int[] arr, int d) {
        //store the first value
        for(int i = 0; i < d; i ++){
            int temp = arr[0];
            for(int j = 0; j < arr.length - 1; j++){
                //shift elements left
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
