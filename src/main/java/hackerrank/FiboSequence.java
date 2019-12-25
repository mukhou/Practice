package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/2/18
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class FiboSequence {

    private static void fiboSequence(Integer[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();
        map.put(0, 0);
        map.put(1, 1);
        for(int i = 0; i < arr.length; i ++){
            int val = arr[i];
            if(val <= 1){
                results.add(map.get(val));
            }else {
                /*int val_prev = val - 1;
                int val_prev_prev = val - 2;*/
                int temp_prev = 0, temp_prev_prev = 0;
                if (map.containsKey(val -1 )) {
                    temp_prev += map.get(val - 1);
                } else {
                    temp_prev = recurse(val - 1);
                    map.put(val - 1, temp_prev);
                }if(map.containsKey(val - 2)){
                    temp_prev_prev += map.get(val - 2);
                }else {
                    temp_prev_prev = recurse(val - 2);
                    map.put(val - 2, temp_prev_prev);
                }

                results.add(temp_prev + temp_prev_prev);


            }
        }
        for(Integer i : results){
            System.out.println(i);
        }
    }


    private static int recurse(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recurse(n - 1) + recurse(n - 2);
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        while(scan.hasNextInt()){
            list.add(scan.nextInt());
        }
        Integer[] intArr = new Integer[list.size()];
        intArr =  list.toArray(intArr);
        fiboSequence(intArr);

    }
}
