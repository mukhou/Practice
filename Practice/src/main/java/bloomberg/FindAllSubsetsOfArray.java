package bloomberg;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/2/18
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindAllSubsetsOfArray {
    public static void printSubSet(int[] arr){
        for(int i = 0; i < arr.length; i ++){
            boolean[] ifPrint = new boolean[arr.length];
            printSubSet(arr, ifPrint, 0, i);
        }

    }
    public static void printSubSet(int[] arr, boolean[] ifPrint, int start, int remain){
        //firstly if remain == 0, we are done
        if(remain == 0){
            System.out.print("{");
            for(int i = 0; i < ifPrint.length; i ++){
                if(ifPrint[i]){
                    System.out.print(arr[i] + ",");
                }
                System.out.print("}\n");
            }
        } else {
            if(start + remain > arr.length){
                ;
            }else {
                for(int i = start; i < arr.length; i ++){
                    if(!ifPrint[i]){
                        ifPrint[i] = true;
                        printSubSet(arr, ifPrint, i + 1, remain - 1);
                        ifPrint[i] = false;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubSet(arr);


        /*for(Set<Integer> s : subsets(mySet)){
            System.out.println(s);
        }*/

    }

}
