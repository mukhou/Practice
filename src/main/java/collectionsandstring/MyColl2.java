package collectionsandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyColl2 {
	
	public static void main(String args[]) {
		
		List<String> list = new ArrayList<String>();
		list.add("India");
		list.add("Russia");
		list.add("Japan");
		list.add("Korea");
		list.add("Finland");
		list.add("USA");
		
		System.out.println("Before sorting " + list);
		
		// the sort method takes a List as the input parameter
		Collections.sort(list);
		
		System.out.println("the sorted list is "+ list);
		
		String[] strArr = new String[6];
		strArr = list.toArray(strArr);
		
		// the sort method takes an Object array as the input parameter
		Arrays.sort(strArr);
		
	}

}
