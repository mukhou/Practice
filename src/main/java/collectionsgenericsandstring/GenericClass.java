package collectionsgenericsandstring;

import java.util.ArrayList;
import java.util.List;

public class GenericClass {

	public static void main(String[] args) {
		List<Dog> animals = new ArrayList<Dog>();
		animals.add(new Dog());
		animals.add(new Dog());
		addAnimalsSuper(animals);

		List<Animal> dogs = new ArrayList<Animal>();
		dogs.add(new Dog());
		dogs.add(new Dog());
        dogs.add(new Cat());
        addDogs(dogs);
		addAnimalsSuper(dogs);
		removeAnimalsWildcard(dogs);
		addAnimalsWildcard(animals);
		removeWildCardOnly(animals);
		

		// gives a compile time error
		// cannot pass list of dogs to the method expecting List<Animal>
		 //generics.addAnimal(animals);

		Dog[] dog = new Dog[3];
		addDog(dog);

	}

	private void addAnimal(List<Animal> animals) {
		animals.add(new Dog());
	}

	// this method WILL NOT compile
	// since we are using wildcard, we CANNOT ADD ANYTHING to the collection
	
	private static void addAnimalsWildcard(List<? extends Animal> animals){
		//COMPILER ERROR
	 // animals.add(new Dog());
		animals.remove(0);
	}

	private static void removeAnimalsWildcard(List<? extends Animal> animals){
		System.out.println("########## inside extends");
		System.out.println(animals.size());
		animals.remove(0);
		System.out.println(animals.size());
	}
	 
	
	private static void addAnimalsSuper(List<? super Dog> animals){
		System.out.println("############ inside super");
		System.out.println(animals.size());
		animals.add(new Dog());
		System.out.println(animals.size());
	}

	private static void removeWildCardOnly(List<?> animals){
		System.out.println("############ inside wildcard");
		System.out.println(animals.size());
		animals.remove(0);
		System.out.println(animals.size());
		//compile error
		//animals.add(new Dog());
		//animals.set(0, animals.get(0));
	}

	private static void addDogs(List<Animal> dogs) {
		dogs.add(new Cat());

	}

	// running this code throws the error ArrayStoreException
	// because we are trying to add Cat object
	// into an array supposed to hold Dog objects
	private static void addDog(Animal[] dog) {
		//ArrayStoreException
		//dog[0] = new Cat();

	}

}

class Animal {
	private String name;

	public String getName() {
		return name;
	}
}

class Dog extends Animal {

}

class Cat extends Animal {

}