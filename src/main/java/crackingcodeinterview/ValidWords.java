/* 
User: Urmi
Date: 12/23/2019 
Time: 10:06 AM
*/

/**
 * On old cell phones, users typed on a numeric keypad and the phone would provide a list of words
 * that matched these numbers. Each digit mapped to a set of 0 - 4 letters. Implement an algorithm
 * to return a list of matching words, given a sequence of digits. You are provided a list of valid words
 * (provided in whatever data structure you'd like).
 */
package crackingcodeinterview;

import com.google.common.collect.Lists;
import crackingcodeinterview.datastructures.Trie;
import crackingcodeinterview.datastructures.TrieNode;

import java.util.ArrayList;
import java.util.List;

//See CTCI pg 517
public class ValidWords {

    public static List<String> getValidT9Words(String number, Trie trie) {
        List<String> result = Lists.newArrayList();
        getValidT9Words(number, 0, "", trie.getRoot(), result);
        return result;
    }

    private static void getValidT9Words(String number, int index, String prefix, TrieNode root, List<String> result) {
        /* If it's a complete word, print it. */
        if(index == number.length()){
            if(root.terminates()){
                result.add(prefix);
            }
        }

        char digit = number.charAt(index);
        char[] letters = getLettersForDigit(digit);
        for(char c : letters){
            TrieNode child = root.getChild(c);
            if(child != null){
                //add the new letter to prefix
                getValidT9Words(number, index + 1, prefix + c, child, result);
            }
        }
    }

    private static char[] getLettersForDigit(char digit) {
        if(!Character.isDigit(digit)){
            return null;
        }
        //IMPORTANT
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }

    public static char[][] t9Letters = {
            null, 					// 0
            null, 					// 1
            {'a', 'b', 'c'}, 		// 2
            {'d', 'e', 'f'}, 		// 3
            {'g', 'h', 'i'}, 		// 4
            {'j', 'k', 'l'},		// 5
            {'m', 'n', 'o'},		// 6
            {'p', 'q', 'r', 's'}, 	// 7
            {'t', 'u', 'v'},		// 8
            {'w', 'x', 'y', 'z'} 	// 9
    };

    public static void main(String[] args) {
        List<String> words = getValidT9Words("8733", new Trie(Lists.newArrayList()));
        for (String w: words) {
            System.out.println(w);
        }
    }
}
