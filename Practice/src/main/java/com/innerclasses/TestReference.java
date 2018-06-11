package com.innerclasses;

public class TestReference {
	public static void main(String[] args){
		Animal a = new Horse();
		// compiler error
		//a.buck();
	}

}

class Animal{
	public void eat(){
		
	}
}
 class Horse extends Animal{
	 public void buck(){
		 
	 }
 }