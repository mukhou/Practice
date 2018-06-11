package com.cts.filesandconsole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer3 {
	public static void main(String args[]) {
		try{
			File myfile = new File("abhi.txt");
			FileWriter fw = new FileWriter(myfile);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("1 2 3");
			pw.flush();
			pw.close();
			
			FileReader reader = new FileReader(myfile);
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			System.out.println(str);
			br.close();
		}catch(IOException e){
			
		}
	}

}
