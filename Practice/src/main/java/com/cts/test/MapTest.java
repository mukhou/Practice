package com.cts.test;/*package com.cts.test;

import java.util.HashMap;
import java.util.Map;

class Dog{
	
	public String name;
	public Dog(String n){
		name = n;
	}
	
	public boolean equals(Object o){
		
		if((o instanceof Dog) && (((Dog)o).name == this.name)){
			return true;
		}else{
			return false;
		}
	}
	
	public int hashCode(){
		return name.length();
	}
}

class Cat { }

enum Pets{DOG, CAT, HORSE};

public class MapTest {
	
	public static void main(String[] args) {
		
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("k1", new Dog("Rex"));
		m.put("k2", Pets.DOG);
		m.put(Pets.CAT, "CAT key");
		Dog d1 = new Dog("clover");
		m.put(d1, "Dog Key");
		m.put(new Cat(), "Cat key");
		System.out.println(m.get("k1")); // #1
		String k2 = "k2";
		System.out.println(m.get(k2)); // #2
		Pets p = Pets.CAT;
		System.out.println(m.get(p)); // #3
		System.out.println(m.get(d1)); // #4
		System.out.println(m.get(new Cat())); // #5
		System.out.println(m.size()); // #6		

	}

}
*/