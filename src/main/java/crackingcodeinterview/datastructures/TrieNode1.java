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
    private boolean terminates = false;

    public TrieNode1(HashMap<Character, TrieNode1> children, ArrayList<Integer> indexes) {
        this.children = new HashMap<>();
        this.indexes = new ArrayList<>();
    }

    public TrieNode1() {
    }

    public void insertString(String s, int index){

        if (s == null || s.isEmpty()) {
            return;
        }
        if(s == null){
            return;
        }
        indexes.add(index);

        char first = s.charAt(0);
        TrieNode1 child= children.get(first);
        if (child == null) {
            child = new TrieNode1();
            children.put(first, child);
        }

        if (s.length() > 1) {
            child.insertString(s.substring(1), index + 1);
        } else {
            child.setTerminates(true);
        }
    }

    /* Set whether this node is the end of a complete word.*/
    public void setTerminates(boolean t) {
        terminates = t;
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
