/* 
User: Urmi
Date: 1/7/2020 
Time: 5:44 PM
*/

package byteBybyte;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {
    public static int solution(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : S.toCharArray()){
            map.merge(ch, 1, Integer::sum);
        }
        int counter = 0;

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            String str = "";
            int x = entry.getValue();
            while(x != 0){
                str += entry.getKey();
                x--;
            }
            int size = printCombinationsInSet(str, new StringBuilder(), 0).size();
            if(size != 1){
                counter += (size * 2) - 1;
            }
            else {
                counter += 1;
            }
        }
        return counter;
    }

    private static Set<String> printCombinationsInSet(String instr, StringBuilder outstr, int index) {
        Set<String> set = new HashSet<>();
        for (int i = index; i < instr.length(); i++) {
            // append and print
            outstr.append(instr.charAt(i));
            set.add(outstr.toString());
            //recursive call
            set.addAll(printCombinationsInSet(instr, outstr, i + 1));
            outstr.deleteCharAt(outstr.length() - 1);
        }
        return set;
    }

    public static void main(String[] args){
        System.out.println(solution("zzzyz"));
    }
}
