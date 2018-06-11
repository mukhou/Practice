package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 2/17/18
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort3 {
    static int runningTime(int[] arr) {
        int shift = 0;
        for(int j = 1; j < arr.length; j++){
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key){
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
            shift ++;

        }

        return shift;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        /*int result = runningTime(arr);
        System.out.println(result);*/
        for(int i = arr.length; i > 0; i --){
            System.out.print(arr[i] + " ");
        }
        in.close();
    }
}
