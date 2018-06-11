package com.cts.test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestMap {

	
	public static void main(String[] args) {
		
		Set<String> treesets = new TreeSet<String>();
		treesets.add("One");
		treesets.add("two");
		treesets.add("three");
		treesets.add("four");
		
		Iterator it = treesets.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
