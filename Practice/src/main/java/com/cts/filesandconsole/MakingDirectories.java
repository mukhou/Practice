package com.cts.filesandconsole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class MakingDirectories {
	
	public static void main(String args[]) {
		try{
			File myDir = new File("myDir");
			myDir.mkdir();
			System.out.println(myDir.isDirectory());
			File myFile = new File(myDir, "myFile.txt");
			File testFile = new File(myDir, "testFile.txt");
			myFile.createNewFile();
			testFile.createNewFile();
			
			PrintWriter pw = new PrintWriter(myFile);
			pw.println("Urmi Banerjee");
			pw.flush();
			pw.close();
			
			PrintWriter pw1 = new PrintWriter(testFile);
			pw1.println("Writing to file");
			pw1.flush();
			pw1.close();
			
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
			br.close();
			
			String[] files = new String[100];
			File search = new File("myDir");
			files = search.list(); // create the list
			for(String fn : files) // iterate through it
			System.out.println("found " + fn);
		}catch (Exception e) {
			
		}

	}

}
