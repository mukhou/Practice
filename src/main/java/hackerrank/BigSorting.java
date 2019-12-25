package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/27/18
 * Time: 9:09 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 */
public class BigSorting {
    static String[] bigSorting(String[] arr) {

        Arrays.sort(arr, (x, y) -> {
            if(x.length() != y.length()) return x.length() - y.length();
            return x.compareTo(y);
        });
        /*for(String s : arr){
            System.out.println(s);
        }*/
        return arr;
    }

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();*/
        String[] arr = {"6", "31415926535897932384626433832795", "1", "3", "10", "3", "5"};
        /*for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }*/
        String[] result = bigSorting(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        //in.close();
    }
}
