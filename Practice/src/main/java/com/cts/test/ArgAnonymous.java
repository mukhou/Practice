package com.cts.test;

public class ArgAnonymous {
	
	public static void main(String[] args){
		Bar b = new Bar();
		b.doStuff(new Foo(){
			public void foof(){
				System.out.println("This is the anonymous class");
			}
		});
	}
	
	
}


class Bar{
	void doStuff(Foo f){
		System.out.println("Interface Foo");
	}
}
