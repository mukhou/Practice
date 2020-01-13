package byteBybyte;

import java.util.Arrays;

public class ReverseArray {

    static private void reverse(int[] arr){
        for(int i = 0; i < arr.length / 2; i++){
           int temp = arr[arr.length - i - 1];
           arr[arr.length - i - 1] = arr[i];
           arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        int[] A = {2,8,7,1,4};
        reverse(A);

    }
}
