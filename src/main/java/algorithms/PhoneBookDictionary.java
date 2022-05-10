/**
 * Design a phone book dictionary which on input any characters gives names and 
 * phone number of all the matching names(prefix)
 */

package algorithms;

import java.util.LinkedHashMap;

// We solve this by the Trie example
public class PhoneBookDictionary {

    LinkedHashMap l;

	// Create a plain old anonymous inner class, flavor two(Interface)
	private interface Node{
		
		public String getValue();
		public boolean containsChildValue(char c);
		public Node getChild(char c);
		
		public static final Node EMPTY_NODE = new Node(){
			@Override public String getValue() { return ""; }
            @Override public boolean containsChildValue(char c) { return false; }
            @Override public Node getChild(char c) { return this; }
		};

		
	}
	
	public Node findValue(Node startNode, String word){
		Node current = startNode;
		for(char c : word.toCharArray()){
			// check to see if the child of the current contains the character value
			// if yes, continue with that branch
			// else break
			if(current.containsChildValue(c)){
				current = current.getChild(c);
			}else{
				current = Node.EMPTY_NODE;
				break;
			}
		}
		return current;
	}

}
