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

import static crackingcodeinterview.util.DataUtil.getListOfWords;

//See CTCI pg 517
public class ValidWords {

    public static List<String> getValidT9Words(String number, Trie trie) {
        ArrayList<String> result = Lists.newArrayList();
        getValidWords(number, 0, "", trie.getRoot(), result);
        return result;
    }

    public static void getValidWords(String number, int index, String prefix, TrieNode trieNode, ArrayList<String> results) {
        /* If it's a complete word, print it. */
        if (index == number.length()) {
            if (trieNode.terminates()) { // Is complete word
                results.add(prefix);
            }
            return;
        }

        /* Get characters that match this digit */
        char digit = number.charAt(index);
        char[] letters = getLetterForDigit(digit);

        /* Go through all remaining options. */
        if (letters != null) {
            for (char letter : letters) {
                TrieNode child = trieNode.getChild(letter);
                if (child != null) { /* If there are words that start with prefix + letter, continue */
                    getValidWords(number, index + 1, prefix + letter, child, results);
                }
            }
        }
    }

    public static char[] getLetterForDigit(char digit) {
        if (!Character.isDigit(digit)) {
            return null;
        }
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return telephoneKeypad[dig];
    }

    public static char[][] telephoneKeypad = {
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

    public static Trie getTrieDictionary() {
        return new Trie(getListOfWords());
    }

    public static void main(String[] args) {
        List<String> words = getValidT9Words("8733", getTrieDictionary());
        for (String w: words) {
            System.out.println(w);
        }
    }
}
