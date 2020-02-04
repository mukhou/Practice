package hackerrank;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 2/3/18
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroupedAnagrams {
    /**
     * A means for grouping words by anagram
     */
    @FunctionalInterface
    interface AnagramSolution{
        Set<Set<String>> group(List<String> words);
    }

    public static void testAnagrams(){
        List<String> words = Arrays.asList("cat", "dog", "act", "god");
        //here input will be replaced with words
         AnagramSolution sol = (input) -> {
             Map<String, Set<String>> wordMap = new HashMap<>();
             //for each word, create the map and add to it
             input.stream().forEach(word -> {
                 String sorted = sortCharacters(word);
                 if(!wordMap.containsKey(sorted)){
                     wordMap.put(sorted, new HashSet<>());
                 }
                 wordMap.get(sorted).add(word);

             });

            return new HashSet<>(wordMap.values());
         };

        Set<Set<String>> groupedWords = sol.group(words);
    }

    private static String sortCharacters(String word) {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);

    }
}
