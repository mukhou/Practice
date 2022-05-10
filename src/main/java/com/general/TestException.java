package com.general;

import java.io.File;
import java.io.IOException;

public class TestException {

	static void show() {
		int[] array = {1, 2, 3};
		array[3] = 8;
		System.out.println(array);
		
	}
	public static void main(String[] args) {
		show();
		System.out.println("%%%%%%%%%%%%%%%%%");

	}

	//HANDLE AND DECLARE
	public void doStuff() throws IOException{
		try {
			File file = new File("");
			file.createNewFile();
		} catch(IOException ex) {
			throw ex; // Can't throw it unless you declare it
		}
	}

}
