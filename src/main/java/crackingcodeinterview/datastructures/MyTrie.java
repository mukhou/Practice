/* 
User: Urmi
Date: 1/29/2020 
Time: 3:54 PM
*/

package crackingcodeinterview.datastructures;

import java.util.*;

//https://gist.github.com/jeanmw/9ce88093deafca3cf1ac5daed65d47eb
public class MyTrie {
    protected final Map<Character, MyTrie> children;
    protected String content;
    protected boolean terminates = false;

    public MyTrie() {
        children = new HashMap<>();
    }

    private MyTrie(String content) {
        this();
        this.content = content;
    }

    //method to append character
    protected void addCharacter(char character) {
        String s;
        if (this.content == null) {
            s = Character.toString(character);
        } else {
            s = this.content + character;
        }
        //character and the node
        children.put(character, new MyTrie(s));
    }


    //method for inserting a new diagnosis
    public void addWord(String str) {
        if (str == null) {
            return;
        }
        MyTrie node = this;
        for (char c : str.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.addCharacter(c);
            }
            //go to next node
            node = node.children.get(c);
        }
        node.terminates = true;
    }

    //method to search for a diagnosis entry
    public String find(String str) {
        if (str == null) {
            return "";
        }
        MyTrie node = this;
        for (char c : str.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return "";
            }
            node = node.children.get(c);
        }
        return node.content;
    }

    //check for fragment of an entry prefix
    //todo: fragment within the diagnosis string isn't detected.
    //since tries are prefix data structures, I would need to come up with a different data structure
    ///solution here.
    public Collection<String> autoComplete(String prefix) {
        MyTrie node = this;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return Collections.emptyList();
            }
            node = node.children.get(c);
        }
        return node.allPrefixes();
    }

    protected Collection<String> allPrefixes() {
        List<String> results = new ArrayList<String>();
        MyTrie node = this;
        if (node.terminates) {
            results.add(node.content);
        }
        for (Map.Entry<Character, MyTrie> entry : node.children.entrySet()) {
            MyTrie child = entry.getValue();
            Collection<String> childPrefixes = child.allPrefixes();
            results.addAll(childPrefixes);
        }
        return results;
    }

    public static void main(String[] args){
        MyTrie myTrie = new MyTrie();
        myTrie.addWord("tree");
        myTrie.addWord("tea");
        System.out.println(myTrie.autoComplete("t"));
    }

}
