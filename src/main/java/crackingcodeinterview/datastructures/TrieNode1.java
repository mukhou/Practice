/* 
User: Urmi
Date: 12/26/2019 
Time: 12:38 PM
*/

package crackingcodeinterview.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode1 {

    private HashMap<Character, TrieNode1> children;
    private ArrayList<Integer> indexes;

    public TrieNode1(HashMap<Character, TrieNode1> children, ArrayList<Integer> indexes) {
        this.children = new HashMap<>();
        this.indexes = new ArrayList<>();
    }

    public TrieNode1() {
    }

    public void insertString(String s, int index){
        if(s == null){
            return;
        }
        indexes.add(index);
        if(s.length() > 0){
            char c = s.charAt(0);
            TrieNode1 child = null;
            if(children.containsKey(c)){
                //get refernce to child
                 child = children.get(c);
            }else {
                //create child and put it in map
                child =  new TrieNode1();
                children.put(c, child);
            }

            String remainder = s.substring(1);
            child.insertString(remainder, index + 1);
        }
    }

    public ArrayList<Integer> search(String s){
        //we have reached the end of the string, so return index
        if(s == null || s.length() == 0){
            return indexes;
        }else {
            char first = s.charAt(0);
            if(children.containsKey(first)){
                TrieNode1 child = children.get(first);
                String remainder = s.substring(1);
                return child.search(remainder);
            }
        }
        return null;

    }
}
