/* 
User: Urmi
Date: 1/7/2020 
Time: 8:56 PM
*/

package dataStructures;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args){
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);

        //parallelismThreshold
        map.forEach(2, (k, v) ->
                System.out.println("key is " + k + " value is " + v + " by thread " + Thread.currentThread().getName()));

        //search functionality
        String result = map.search(1, (k, v) -> {
            System.out.println(Thread.currentThread().getName());
            if(k.equals("A")){
                return k +"-" +v;
            }
            return null;
        });
        System.out.println(result);

    }
}
