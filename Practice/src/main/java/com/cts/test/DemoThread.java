package com.cts.test;



class DemoTest implements Runnable{
	
	String name;
	Thread t;
	
	 DemoTest(String tName) {
		 
		 name = tName;
		 t = new Thread(this, name);
		 System.out.println("New Thread "+t);
		 t.start();
	
	}
	 
	 
	public void run() {
		
		try{
			synchronized (this) {
				
			}
			for(int i=5;i>0;i--){
				System.out.println(name + ": " + i);
				Thread.sleep(500);
				
			}
		}catch(InterruptedException e){
			System.out.println(name + "interrupted");
		}
		
	}
	
}

public class DemoThread {

	
	public static void main(String[] args) {
		
		new DemoTest("One");
		new DemoTest("Two");
		new DemoTest("Three");
		
		try{
			Thread.sleep(10000);
			
		}catch (Exception e) {
			System.out.println("Main thread interrupted");
		}
	}

}
