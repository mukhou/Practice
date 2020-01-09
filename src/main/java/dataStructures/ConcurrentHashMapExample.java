/* 
User: Urmi
Date: 1/7/2020 
Time: 8:56 PM
*/

package dataStructures;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args){
        ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D", 4);
        hashMap.put("E", 5);
        hashMap.put("F", 6);
        hashMap.put("G", 7);

        //parallelismThreshold
        hashMap.forEach(2, (k, v) ->
                System.out.println("key is " + k + " value is " + v + " by thread " + Thread.currentThread().getName()));

    }
}
