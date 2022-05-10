package com.general;

import java.util.Date;

class Animal1{
	static void doStuff(){
		System.out.println("animal");
	}
}

class Dog extends Animal1{
	static void doStuff(){
	System.out.println("dog");	
	}
}

public class TestStaticAnimals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal1 [] animalList = {new Animal1(), new Dog(), new Animal1()};
		for(Animal1 a : animalList){
			// this prints "animal" thrice. Since its accessing a static method,
			// the Object Reference is used to access the method,
			// rather than the actual object. The compiler does like this:
			// Animal.doStuff()
			a.doStuff();
			
			byte a1 = 3;
			byte b = 8;
			byte c = (byte)(a1 + b);
			int x = 9;
			//b = x; ====================GIVES ERROR

		}
		Animal a = new Animal();
		//Dog d = (Dog) a; ====================GIVES ERROR
		Date date;
		//====================GIVES ERROR
		/*if(date == null){

		}*/

	}

}
