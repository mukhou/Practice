package com.cts.test;

class NameRunnable implements Runnable{
	
	public void run(){
		System.out.println("NameRunnable running");
		System.out.println("Run by " + Thread.currentThread().getName());
	}
}


public class NameThead {

	
	public static void main(String[] args) {
		NameRunnable runnable = new NameRunnable();
		Thread t = new Thread(runnable);
		System.out.println("Main thread is "+ Thread.currentThread().getName());
		t.setName("Urmi Thread");
		t.start();

	}

}

