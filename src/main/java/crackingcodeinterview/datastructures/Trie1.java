/* 
User: Urmi
Date: 12/26/2019 
Time: 12:37 PM
*/

package crackingcodeinterview.datastructures;

import java.util.ArrayList;

public class Trie1 {

    private TrieNode1 root = new TrieNode1();

    public ArrayList<Integer> search(String s){
        return root.search(s);
    }

    public void insertString(String str, int location){
        root.insertString(str, location);
    }

    public static Trie1 createTrieFromString(String s){
        Trie1 trie1 = new Trie1();
        for(int i = 0; i < s.length(); i ++){
            String suffix = s.substring(i);
            trie1.insertString(suffix, i);
        }
        return trie1;
    }

}
