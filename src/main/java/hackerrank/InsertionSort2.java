package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/28/18
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort2 {
    static void insertionSort2(int n, int[] arr) {
        for(int j = 1; j < arr.length; j++){
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key){
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
            for(int k = 0; k < arr.length; k ++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort2(n, arr);
        in.close();
    }
}
