package interview.qsns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveVowels {

	public static void removeVowels(List<Character> charList)
    {
		Set<Character> set = new HashSet<Character>();		
        for(Character c : charList){
        	if(!Character.toString(c).equalsIgnoreCase("a") && !Character.toString(c).equalsIgnoreCase("o") &&
        			!Character.toString(c).equalsIgnoreCase("e") && !Character.toString(c).equalsIgnoreCase("i")
        			&& !Character.toString(c).equalsIgnoreCase("u")){
        		set.add(c);
        	}
        }
        
        for(Character ch : set){
        	System.out.println(ch);
        }
        
            
    }
	public static void main(String[] args) {
		List<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.add('i');
		list.add('e');
		
		removeVowels(list);

	}

}
