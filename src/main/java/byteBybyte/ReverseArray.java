package byteBybyte;

import java.util.Arrays;

public class ReverseArray {

    static private void reverse(int[] arr){
        int len = arr.length - 1;
        for(int i = 0; i < arr.length / 2; i++){
           int temp = arr[len - i];
           arr[len - i] = arr[i];
           arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        int[] A = {2,8,7,1,4};
        reverse(A);

    }
}
