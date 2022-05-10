package com.generics;

public class GenericRestriction {

	
	
	public static void main(String[] args) {
		Integer[] n = {1, 2, 3};
		//
		Gen<Integer> iob = new Gen<Integer>(50, n);

	}

}

class Gen<T extends Number>{
	T ob;
	T[] vals;
	Gen(T o, T[] nums){
		ob = o;
		// Illegal, because T does not exist at runtime, so there is
		// no way for the compiler to know what type of array to actually create
		//vals = new T[10];
		
		// This is OK
		vals = nums;
	}
}
