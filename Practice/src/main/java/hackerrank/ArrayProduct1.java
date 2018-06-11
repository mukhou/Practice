package hackerrank;

import java.util.Arrays;

public class ArrayProduct1 {
    public static void main(String [] args){
        int[] arr = {1, 2, 3, 4};
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            int prd = 1;
            for(int j = 0; j < arr.length; j++){
                if(i == j) {
                    continue;
                }
                prd *= arr[j];
            }

            if((prd & 1) == 0){
                res[i] = 0;
            }else {
                res[i] = 1;
            }
        }
        System.out.println(Arrays.toString(res));
    }

}
