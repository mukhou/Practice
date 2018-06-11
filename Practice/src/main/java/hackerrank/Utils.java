package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<Character,Integer> stringToHashMap(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : arr){
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }
}
