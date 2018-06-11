package hackerrank;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 1/31/18
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class FirstNonRepeating {
    public static void main (String args[]){
        String[] inputs = {"apple", "racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd'};
        findFirst("racecar");

    }
    public static char findFirst(String input){

        Map<Character, Integer> map = new LinkedHashMap<>();
        //new java way
        for(char i : input.toCharArray()){
            map.merge(i, 1, Integer::sum);
        }

        //old java way
        /*for(char i : input.toCharArray()){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else map.put(i, 1);
        }*/
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        return 0;
    }
}
