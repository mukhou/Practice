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
        //findFirst("geeksforgeeks");
        findFirst("who wants hot watermelon");
        System.out.println(indexOfFirstNonRepeatingChar("aabbccc"));

    }
    public static char findFirst(String input){

        Map<Character, Integer> map = new LinkedHashMap<>();
        //new java way
        for(char i : input.toCharArray()){
            map.merge(i, 1, Integer::sum);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        return 0;
    }
    public static long indexOfFirstNonRepeatingChar(String s) {
        long index = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : s.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }
        Character res = null;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                res = entry.getKey();
                break;
            }
        }
        return res == null? -1 : s.indexOf(res);
    }
}
