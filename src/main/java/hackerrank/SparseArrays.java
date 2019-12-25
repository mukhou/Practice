package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 2/18/18
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stringSize = in.nextInt();
        String[] arr = new String[stringSize];
        for(int ar_i = 0; ar_i < stringSize; ar_i++){
            arr[ar_i] = in.next();
        }
        System.out.println(Arrays.toString(arr));

        int querySize = in.nextInt();
        String[] arr1 = new String[querySize];
        for(int ar_i = 0; ar_i < querySize; ar_i++){
            arr1[ar_i] = in.next();
        }
        System.out.println(Arrays.toString(arr1));
        sparseArrays(arr, arr1);

    }

    private static void sparseArrays(String[] inputString, String[] queryString) {
        for(int i = 0; i < queryString.length; i++){
            int count = 0;
            for(int j = 0; j < inputString.length ; j ++){
                if(queryString[i].equalsIgnoreCase(inputString[j])){
                    count++;
                }
            }
            System.out.println(count);
        }
    }



}
