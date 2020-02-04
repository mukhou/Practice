/* 
User: Urmi
Date: 1/14/2020 
Time: 7:57 PM
*/

package byteBybyte;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    private static List<String> solve(List<String> words, String input){
        List<String> result = new ArrayList<>();
        while (input.length() > 0) {
            String longest = "", test = "";

            for (var i = 1; i <= input.length(); i++) {
                test = input.substring(0, i);

                if (words.contains(test)) {
                    result.add(test);
                    longest = test;
                }
            }

            input = input.substring(longest.length());

            //result.addCharacter(longest);
        }
        return result;
    }

    private static List<String> solve1(List<String> words, String input){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            for(int j = i + 1; j < input.length(); j++){
                String temp = input.substring(i, j);
                if(words.contains(temp)){
                    result.add(temp);

                }
            }
        }
        return result;

    }

    private static Set<String> findSubStrings(String str, StringBuilder sb, int index){
        Set<String> set = new HashSet<>();
        for(int i = index; i < str.length(); i++){
            sb.append(str.charAt(i));
            set.add(sb.toString());
            set.addAll(findSubStrings(str, sb, i + 1));
            sb.deleteCharAt(sb.length() - 1);

        }
        return set;

    }
    public static void main(String[] args){
        List<String> words = List.of("dog", "cats", "sand", "cat", "and");
        System.out.println(solve1(words, "catsanddog"));
        //System.out.println(findSubStrings("abc", new StringBuilder(), 0));
    }
}
