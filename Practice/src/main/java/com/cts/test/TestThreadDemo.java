package com.cts.test;

 class MyTest implements Runnable {

	Thread t;

	MyTest() {

		t = new Thread(this, "My Thread");
		System.out.println("Child thread " + t);
		t.start();
	}

	public void run() {

		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child thread " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			
			System.out.println("Child thread interrupted");
		}
		System.out.println("Child thread exiting");;

	}
}


public class TestThreadDemo{
	
	public static void main(String[] args) {
		new MyTest();
		try{
			for(int i=5;i>0;i--){
				System.out.println("Main thread "+i);
				Thread.sleep(1000);
				
			}
		}catch (InterruptedException e) {
			System.out.println("main thread interrupted");;
		}
		System.out.println("Main thread exiting");
	}
}