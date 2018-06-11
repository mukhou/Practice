package hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindNumber {
    static String findNumber(int[] arr, int k) {
        boolean found = false;
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == k){
                found = true;
                break;
            }else if(arr[i] != k){
                if(i == arr.length - 1){
                    found = false;
                }else{
                    found = true;
                }
            }

        }
        System.out.println(found ? "YES" : "NO");
        return (found ? "YES" : "NO");



    }

    public static void main(String[] args){
        findNumber(new int[]{1, 2, 3, 4,5}, 1);
    }

}
