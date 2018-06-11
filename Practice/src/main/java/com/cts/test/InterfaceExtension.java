package com.cts.test;

public class InterfaceExtension implements MyInterface{
	public void show(){
		System.out.println("x = " + x);
	}
	
	public static void main(String[] args){
		InterfaceExtension i = new InterfaceExtension();
		i.show();
	}

}
