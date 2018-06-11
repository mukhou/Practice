package com.genericsandboxing;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {	
	
	public static void main(String[] args) {
		List<Dog> animals = new ArrayList<Dog>();
		animals.add(new Dog());
		animals.add(new Dog());
		
		TestGenerics generics = new TestGenerics();
		
		List<Animal> dogs = new ArrayList<Animal>();
		dogs.add(new Dog());
		addDogs(dogs);
		
		// gives a compile time error
		// cannot pass list of dogs to the method expecting List<Animal>
		//generics.addAnimal(animals);
		
		Dog[] dog = new Dog[3];
		addDog(dog);

	}
	
	public void addAnimal(List<Animal> animals){
		animals.add(new Dog());
	}

	private static void addDogs(List<Animal> dogs) {
		dogs.add(new Cat());
		
	}

	// running this code throws the error ArrayStoreException
	// because we are trying to add Cat object
	// into an array supposed to hold Dog objects
	private static void addDog(Animal[] dog) {
		dog[0] = new Cat();
		
	}

}

class Animal{
	private String name;
	public String getName(){
		return name;
	}
}

class Dog extends Animal{
	
}

class Cat extends Animal{
	
}
