package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AliceBob {
    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        List<Integer> list = new ArrayList<>();
        int aliceScore = 0;
        int bobScore = 0;

        int[] res = new int[2];


        int[] arr = new int[6];
        arr[0] = a0;
        arr[1] = a1;
        arr[2] = a2;
        arr[3] = b0;
        arr[4] = b1;
        arr[5] = b2;

        for(int i = 0, j = 3; i < 3; i ++, j++){
            if(arr[i] > arr[j]){
                aliceScore = aliceScore + 1;
            }else if(arr[i] < arr[j]){
                bobScore =  bobScore + 1;
            }
        }
        System.out.println(aliceScore);
        System.out.println(bobScore);
        res[0] = aliceScore;
        res[1] = bobScore;
        return res;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


    }
}
