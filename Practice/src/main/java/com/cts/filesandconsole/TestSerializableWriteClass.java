package com.cts.filesandconsole;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestSerializableWriteClass {

	
	public static void main(String[] args) {
		String file = "testSer.ser";
		TestSerializableWriteClass testWrite = new TestSerializableWriteClass();
		FileOutputStream fo = null;
		ObjectOutputStream os = null;
		
		try{
			fo = new FileOutputStream(file);
			os = new ObjectOutputStream(fo);
			os.writeObject(testWrite);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
