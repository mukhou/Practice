package crackingcodeinterview;

import java.util.HashMap;
import java.util.Map;

public class IsUniqueString {
    public static void main(String [] args){
        System.out.println(isUnqueString("urmi"));
    }

    private static boolean isUnqueString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.merge(c, 1, Integer::sum);
            if(map.get(c) > 1){
                return false;
            }
        }
        return true;
    }
}
