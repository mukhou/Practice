/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */

package crackingcodeinterview;

import java.util.HashMap;
import java.util.Map;

//CTCI pg 204
public class IsUniqueString {
    public static void main(String [] args){
        System.out.println(isUniqueChars("urmu"));
        System.out.println(isUniqueChars1("urmu"));
    }

    //O(N) complexity
    //create an array of boolean values, where the flag at index i indicates whether character
    //i in the alphabet is contained in the string. The second time you see this character you can immediately
    //return false.
    static boolean isUniqueChars(String str ) {
        if(str.length() > 128){
            return false;
        }
        boolean[] charset = new boolean[128];
        for(int i = 0; i < str.length(); i ++){
            int val = str.charAt(i);
            if(charset[val]){
                return false;
            }
            charset[val] = true;
        }
        return true;
    }

    static boolean isUniqueChars1(String str ) {
        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
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
