package com.general;

import java.io.IOException;

class Animal3 {
	Animal3(String s) {

	}

	
	  public Animal3() {
	  
	  }
	 

	public void eat() {
		System.out.println("Generic Animal Eating Generically");
	}

	static void doStuff() {
		System.out.print("a ");
	}
	
	 public void eat(String s) { System.out.println("Animal eating " + s); }
	 
}

class Horse extends Animal3 {
	static String str;

	// only access static variables from within a constructor
	Horse() {
		this(str);
	}

	Horse(String s) {
		super(s);

	}
	static void doStuff() { // it's a redefinition,
		// not an override
		System.out.print("d ");
		}

	public void eat() {
		System.out.println("Horse eating hay ");
	}

	public void eat(String s) {
		System.out.println("Horse eating " + s);
	}
}

public class TestAnimals {

	public static void show(Horse h) {
		System.out.println("Horse method");
	}

	public static void main(String[] args) {
		Animal3 [] a = {new Animal3(), new Horse(), new Animal3()};
		for(int x = 0; x < a.length; x++)
		a[x].doStuff(); // invoke the static method
		
		// Animal a = new Animal();
		// Dog d = (Dog) a;
		
		  Horse h = new Horse(); Animal3 a2 = new Horse();
		  
		 
		 
		// show((Horse)a);
		// a.eat("Carrots");
		// a2.eat("Apples");

		

	}

}
