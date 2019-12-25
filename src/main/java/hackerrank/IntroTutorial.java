package hackerrank;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/28/18
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntroTutorial {
    static int introTutorial(int V, int[] arr) {
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == V){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = introTutorial(V, arr);
        System.out.println(result);
        in.close();
    }
}
