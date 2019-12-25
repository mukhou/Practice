package collectionsgenericsandstring;

import java.util.Arrays;

public class ReverseArray {

    static private void reverse(int[] arr){
        for(int i = 0; i < arr.length / 2; i++){
            int other = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[other];
            arr[other] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        int[] A = {2,8,7,1,4};
        reverse(A);

    }
}
