package com.cts.filesandconsole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer2 {
	public static void main(String args[]) {
		char[] input = new char[50];
		int size = 0;
		try {
			File file2 = new File("readwrite.txt");
			FileWriter writer = new FileWriter(file2);
			writer.write("Jhini Banerjee");
			writer.flush();
			writer.close();
			
			// reads one line at a time, more efficient
			FileReader reader = new FileReader(file2);
			/*BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			System.out.println(str);*/
			
			// reads a character, less efficient
			FileReader reader1 = new FileReader(file2);
			size = reader1.read(input);
			System.out.println(size);
			for (char c : input) {
				System.out.println(c);
			}
			reader.close();
		} catch (IOException e) {
		}

	}
}
