package com.innerclasses;


class BigOuter{
	
	static class Nest{
		public void nest(){
			System.out.println("This is nested class");
		}
	}
}

public class MyNestedClass {

	static class Nest2{
		public void nest2(){
			System.out.println("This is nest2");
		}
	}
	public static void main(String[] args) {
		
		Nest2 nest2 = new Nest2();
		nest2.nest2();
		BigOuter.Nest nest = new BigOuter.Nest();
		nest.nest();
		 

	}

}
