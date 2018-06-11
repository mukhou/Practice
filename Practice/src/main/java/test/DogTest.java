package test;

import java.util.ArrayList;

class Dog1{
	String name;
	Dog1(String n){
		name = n;
	}
}

public class DogTest {
	public static void main(String[] args) {
		ArrayList<Dog1> dogs = new ArrayList<Dog1>(); 
		Dog1 d1 = new Dog1("abc");
		Dog1 d2 = new Dog1("def");
		Dog1 d3 = new Dog1("mno");
		dogs.add(d3);
		dogs.add(d2);
		dogs.add(d1);
		System.out.println(dogs.indexOf(d3));
		Dog1[] o = new Dog1[3];
		o = dogs.toArray(o);
		for(Dog1 o1 : o){
			System.out.println(o1.name);
		}
		
	}

}
