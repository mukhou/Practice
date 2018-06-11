package com.genericsandboxing;

import java.util.ArrayList;
import java.util.List;

public class GenericsWithWildCard {

	public void addAnimal(List<? super Dog> animals){
		animals.add(new Dog());
	}
	
	public static void main(String[] args) {		
		//Also works with
		//List<Animal> animals = new ArrayList<Animal>();
		List<Dog> animals = new ArrayList<Dog>();
		animals.add(new Dog());
		animals.add(new Dog());
		
		GenericsWithWildCard generics = new GenericsWithWildCard();
		
		// THIS WORKS...BECAUSE WE HAVE USED THE KEYWORD SUPER IN THE METHOD DECLARATION
		// This means the compiler will accept any List with a generic type that is of type
		//Dog, or a supertype of Dog.
		generics.addAnimal(animals);

	}

}


