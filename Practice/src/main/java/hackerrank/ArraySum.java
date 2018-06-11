package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //initialize array
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = 0;
        }

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            findMax(arr, a, b, k);
        }

        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);


        in.close();
    }

    private static int[] findMax(int[] arr, int a, int b, int k) {
        int max = 0;
        for(int i = a; i <= b && i != arr.length; i++){
            arr[i] = arr[i] + k;
            if(max < arr[i]){
                max = arr[i];
            }
        }

        return arr;
    }
}
