package com.cts.test;

public class MyCmmndLineArg {
	
	public void show(){
		System.out.println("Show method");
	}
	
	public void view(){
		System.out.println("View method");
	}
	public void call(String num, String param){
		if( num.equals("1")){
			show();
		}else{
			view();
		}
	}

	public static void main(String args[]) {

		/*String [] sarry = new String [2];
		for (String s : args){
			sarry[0] = s;
		}
		
		for (String s : sarry){
			System.out.println(s);
		}*/
		MyCmmndLineArg m1 = new MyCmmndLineArg();
		m1.call(args[0], args[1]);
	}

}
