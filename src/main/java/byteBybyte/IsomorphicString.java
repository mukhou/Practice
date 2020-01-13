/* 
User: Urmi
Date: 1/10/2020 
Time: 8:22 AM
*/

package byteBybyte;

import java.util.HashMap;
import java.util.HashSet;
//papa, kiki
public class IsomorphicString {


    //FOLLOW THIS, RETURNS FALSE EARLY IN STAGE
    public static boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if (c2 != map1.get(c1)) {
                    return false;
                }
            } else if (map2.containsKey(c2)) {
                return false;
            }

            map1.put(c1, c2);
            map2.put(c2, c1);
        }


        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            //same as other method
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }

        HashSet<Character> set = new HashSet<>(map.values());
        if (set.size() == map.values().size()) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        //System.out.println(isIsomorphic("bmprvm", "wwxqnf"));
        // System.out.println(isIsomorphic("papa", "kiki"));
        System.out.println(isIsomorphic1("bmprvm", "wwxqnf"));
    }

}
