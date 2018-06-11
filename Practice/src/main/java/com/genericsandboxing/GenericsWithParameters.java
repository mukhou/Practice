package com.genericsandboxing;

class TwoGen<T, V>{
	T obj1;
	V obj2;
	
	TwoGen(T o1, V o2){
		obj1 = o1;
		obj2 = o2;
	}
	
	void showTypes(){
		System.out.println("Type T is of "+obj1.getClass().getName());
		System.out.println("Type T is of "+obj2.getClass().getName());
	}
	T getObj1(){
		return obj1;
	}
	V getObj2(){
		return obj2;
	}
	
}

public class GenericsWithParameters {	
	public static void main(String[] args) {
		
		TwoGen<Integer, String> gen = new TwoGen<Integer, String>(3, "Urmi");
		gen.showTypes();
		
		// obtain value
		int x = gen.getObj1();
		System.out.println("Interger value is "+x);
		
		String s = gen.getObj2();
		System.out.println("String value is "+s);

	}

}
