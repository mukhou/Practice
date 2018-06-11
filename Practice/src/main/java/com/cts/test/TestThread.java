package com.cts.test;

public class TestThread {

	public static void main(String[] args) {

		Thread t = Thread.currentThread();
		System.out.println("Current thread is " + t);

		t.setName("Testing Thread");
		System.out.println("Changed name is " + t);

		try {
			for (int n = 5; n > 0; n--) {
				System.out.println(n);
			}

			t.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
	}

}
