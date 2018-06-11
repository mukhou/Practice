package com.cts.test;

import java.io.File;
import java.io.IOException;

public class FileTest {

	
	public static void main(String[] args) {
		
		try{
			boolean newFile = false;
			File file = new File("f1.txt");
			System.out.println(file.exists());
			newFile = file.createNewFile();
			System.out.println (newFile); // already there?
			System.out.println (file.exists()); // look again

		}catch(IOException ie){
			
		}

	}

}
