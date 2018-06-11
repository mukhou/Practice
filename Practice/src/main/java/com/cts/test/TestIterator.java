package com.cts.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Poets{
	
	public String name;
	Poets(String n){
		name = n;
	}
}

public class TestIterator {

	
	public static void main(String[] args) {
		
		List<Poets> poetList = new ArrayList<Poets>();
		Poets poet = new Poets("Shelly");
		poetList.add(poet);
		
		poetList.add(new Poets("Keats"));
		poetList.add(new Poets("Wordsworth"));
		
		Iterator<Poets> ite = poetList.iterator();
		while(ite.hasNext()){
			Poets pts = ite.next();
			System.out.println(pts.name);			
		}
		System.out.println(poetList.size());
		System.out.println("element2 " +poetList.get(2).name);
		System.out.println("Shelly "+poetList.indexOf(poet));
		
		poetList.remove(1);
		Object [] objArr = poetList.toArray();
		for(Object o : objArr){			
			System.out.println("\n" +((Poets)o).name);
		}
		
	}

}
