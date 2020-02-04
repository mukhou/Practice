package byteBybyte;

import java.util.*;

/**
 * Given a set, create a set of all possible combination sets of the set
 */

/**
 * time complexity: O(2 ^ n)
 Something like this:
 T(1)=T(0);
 T(2)=T(1)+T(0)=2T(0);
 T(3)=T(2)+T(1)+T(0)=2T(2);
 Thus we have
 T(N)=2T(N-1)=4T(N-2)=... = 2^(N-1)T(1), which is O(2^N)
 */

public class CreatePowerSet {

	// power set creates a set of sets, so return type is Set<Set<T>>,
	// where T can be of any type
	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {

		Set<Set<T>> powerSet = new HashSet<>();
	    if (originalSet.isEmpty()) {
	    	powerSet.add(new HashSet<T>());
	    	//IMP: RETURN STATEMENT
	    	return powerSet;
	    }
	    //IMP there is NO ELSE
	    // create a list with the original set
	    List<T> list = new ArrayList<T>(originalSet);
	    // find the head
	    T first = list.get(0);
	    // find rest
	    // first parameter is inclusive, second is exclusive
	    Set<T> rest = new HashSet<>(list.subList(1, list.size()));
	    //LEAVE first, RECURSE ON rest
	    // recursively call the powerSet method over the rest ONLY
	    for (Set<T> permute : powerSet(rest)) {
	    	Set<T> newSet = new HashSet<T>();
	    	// addCharacter head to newSet
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
