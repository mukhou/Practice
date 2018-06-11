package com.cts.filesandconsole;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestSerializableReadClass {

	
	public static void main(String[] args) {
		String file = "testSer.ser";
		TestSerializableReadClass testRead = null;
		FileInputStream fi;
		ObjectInputStream ois;
		
		try{
			fi = new FileInputStream(file);
			ois = new ObjectInputStream(fi);
			testRead = (TestSerializableReadClass)ois.readObject();
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
