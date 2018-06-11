/**
Random set of WORD. 
Given a word find out if the word can be broken into smaller word, by removing 
one alphabet at a time. 
a) all such word should be valid dictionary word.
( Assume a function is there to test whether the word exist in dictionary) 
b) Remove one alphabet at a time but the new word need to be in dictionary. 

For eg : 
restated -> restate -> estate -> state -> stat -> sat -> at -> a 
fullfill the criterion. ( single alphabet assume belong to dict) 
My solution below. I assume it can be done using dynamic programming or trie data structure 
 */

package algorithms;

import java.util.HashSet;
import java.util.Set;

public class RandomWord {

	public static void main(String[] args) {

		String str = "restated";
		System.out.print(checkword(str));
	}

	public static boolean checkword(String str) {
		boolean b = false;
		if (str.length() == 1) {
			b = true;
		}

		for (int i = 0; i < str.length(); i++) {
			// same as PrintAllCombosOfLetters
			String first = str.substring(0, i);
			String last = str.substring(i + 1);
			String word = first + last;

			if (isValidWord(word)) {
				System.out.println(word);
				if (checkword(word)) {
					b = true;
				} else {
					continue;
				}
			}
		}
		return b;

	}

	public static boolean isValidWord(String str) {

		Set<String> wordSet = new HashSet<String>();
		wordSet.add("restate");
		wordSet.add("estate");
		wordSet.add("state");
		wordSet.add("stte");
		wordSet.add("stat");
		wordSet.add("sat");
		wordSet.add("at");
		wordSet.add("a");

		return wordSet.contains(str);

	}
}
