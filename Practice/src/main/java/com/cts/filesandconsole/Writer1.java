package com.cts.filesandconsole;

import java.io.File;
import java.io.IOException;

public class Writer1 {
	public static void main(String args[]){
		try{
			boolean newFile = false;
			File file = new File("file1.txt");
			System.out.println(file.exists());
			newFile = file.createNewFile();
			System.out.println(newFile);
			System.out.println(file.exists());
		}catch(IOException e){
			
		}
	}

}
