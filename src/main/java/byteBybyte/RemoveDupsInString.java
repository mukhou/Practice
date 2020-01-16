/* 
User: Urmi
Date: 1/14/2020 
Time: 5:25 PM
*/

package byteBybyte;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsInString {

    private static String removeDups(String str){
        Set<Character> set = new HashSet<>();
        for(char c : str.toCharArray()){
            set.add(c);
        }
        StringBuilder res = new StringBuilder();
        set.stream().forEach(character -> res.append(character));
        return res.toString();
    }

    private static String removeDups1(String str){
        String res = new String();
        for(char c: str.toCharArray()){
            if(res.indexOf(c) < 0){
                res += c;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(removeDups("aabbbddcc"));
        System.out.println(removeDups1("aabbbddcc"));

    }
}
