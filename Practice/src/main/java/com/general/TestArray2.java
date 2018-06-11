package com.general;

public class TestArray2 {
	static int[] year = new int[100];
	//just the declaration will give NullPointerEx
	//static int[] year

	public static void main(String[] args) {
		/*for (int i = 0; i < 100; i++)
			System.out.println("year[" + i + "] = " + year[i]);*/
		show();
	}

	static void show() {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}

}
