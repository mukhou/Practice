package hackerrank;



import java.util.Arrays;
import java.util.Scanner;

public class MinMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        long sum = 0;
        for(int i = 0; i < 5; i ++){
            arr[i] = in.nextLong();
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.print((sum-arr[4])+" "+(sum-arr[0]));

        /*long lo = 0, hi = 0;
        long s = 0;
        for (long i = 0; i < 5; i++) {
            long x = s - arr[i];
            if (x < lo) lo = x;
            if (x > hi) hi = x;
        }
        System.out.prlongln(lo + " " + hi);*/

        /*long max = 0, min = 0;
        for(long i = 0; i < arr.length; i++){
            if(arr[i] > arr[i + 1]){
                max += arr[i];
            }else{
                max += arr[i + 1];
            }
        }*/
    }
}
