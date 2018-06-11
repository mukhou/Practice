package hackerrank;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-two-stacks/problem
 */
public class GameOfTwoStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            findSum(in);

    }

    private static void findSum(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i = 0 ; i < n; i ++){
            arr1[i] = in.nextInt();
        }
        for(int i = 0 ; i < m; i ++){
            arr2[i] = in.nextInt();
        }

        int f1 = 0, sum1 = 0;
        while(f1 < n && sum1 + arr1[f1] <= x){
            sum1 += arr1[f1++];
        }
        int f2 = 0, sum2 = 0;
        while(f2 < m && sum2 + arr2[f2] + sum1 <= x){
            sum2 += arr2[f2++];
        }
        int result = sum1 + sum2;
        while(f1 > 0){
            sum1 -= arr1[--f1];
            while(f2 < m && arr2[f2] + sum1 + sum2 <= x){
                sum2 += arr2[f2];
            }
            result = Math.max(result, f1 + f2);
        }

    }
}
