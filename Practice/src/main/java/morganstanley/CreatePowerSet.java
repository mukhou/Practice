package morganstanley;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreatePowerSet {

	// power set creates a set of sets, so return type is Set<Set<T>>,
	// where T can be of any type
	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
		Set<Set<T>> powerSet = new HashSet<Set<T>>();
	    if (originalSet.isEmpty()) {
	    	powerSet.add(new HashSet<T>());
	    	return powerSet;
	    }
	    // create a list with the original set
	    List<T> list = new ArrayList<T>(originalSet);
	    // find the head
	    T first = list.get(0);
	    // find rest
	    // first parameter is inclusive, second is exclusive
	    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
	    // recursively call the powerSet method over the rest, just like 
	    // the method in PrintAllCombosOfLetters class
	    for (Set<T> permute : powerSet(rest)) {
	    	Set<T> newSet = new HashSet<T>();
	    	// add head to newSet
	    	newSet.add(first);
	    	newSet.addAll(permute);
	    	powerSet.add(newSet);
	    	powerSet.add(permute);
	    }		
	    return powerSet;
	}
	
	public static void main(String[] args) {
		Set<Integer> mySet = new HashSet<Integer>();
		 mySet.add(1);
		 mySet.add(2);
		 mySet.add(3);
		 
		 for(Set<Integer> s : powerSet(mySet)){
			 System.out.println(s);
		 }

	}

}
