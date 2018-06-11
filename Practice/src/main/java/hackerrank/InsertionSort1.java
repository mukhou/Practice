package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/28/18
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertionSort1 {
    static void insertionSort1(int n, int[] arr) {
        int temp ;
        int length = arr.length;
        temp = arr[length - 1];
        boolean sorted = false;

        for(int i = length - 2 ; i >= 0; i --){
            if(temp < arr[i]){
                arr[i + 1] = arr[i];
            }else {
                arr[i + 1] = temp;
                sorted = true;
            }
            for(int k = 0; k < arr.length; k ++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();
            if(i == 0 && arr[0] > temp){
                arr[i] = temp;
                for(int k = 0; k < arr.length; k ++){
                    System.out.print(arr[k] + " ");
                }
            }

            if(sorted == true) break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}
