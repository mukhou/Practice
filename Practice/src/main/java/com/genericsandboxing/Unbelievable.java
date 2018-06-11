package com.genericsandboxing;

public class Unbelievable {

	static Integer i;
	public static void main(String[] args) {
		//It throws a NullPointerException when evaluating the expression (i == 42). The
		// problem is that i is an Integer, not an int, and like all object reference fields, its
		// initial value is null. When the program evaluates the expression (i == 42), it is
		// comparing an Integer to an int.
		if(i == 42){
			System.out.println("Unbelievable");
		}

	}

}
