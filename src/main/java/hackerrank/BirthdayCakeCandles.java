package hackerrank;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 10/17/17
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
//https://www.hackerrank.com/challenges/birthday-cake-candles/problem?h_r=internal-search
public class BirthdayCakeCandles {
    static int birthdayCakeCandles(int n, int[] arr) {
        int max = 0, count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
                count = 1;
            }else if(arr[i] == max){
                count ++;
            }
        }
        System.out.println(Arrays.stream(arr).max());
        return count;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);

        //better way
        //first input
        /*int n = in.nextInt();
        int max = 0;
        int count = 0;
        int num;
        for(int i = 0; i < n; i ++){
            num = in.nextInt();
            if(num > max){
                count = 1;
                max = num;
            }else if(max == num){
                count ++;
            }
        }
        System.out.println(count);*/
    }
}
