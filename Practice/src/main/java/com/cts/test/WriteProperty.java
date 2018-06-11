/**
 * This program takes a file name and it checks, if the file exists then performs 
 * the next operations Otherwise, it shows the appropriate messages like: "File not found!" 
 * and "Enter file name which has properties extension :". This message shows until, 
 * when you could not enter the correct file name. If the file name is correct then 
 * it takes the key and key-values of the properties file.  * After that it shows 
 * the appropriate message like: "Operation completly successfuly!". Then, you will see 
 * in the properties file, your inserted keys and values had been inserted in the properties
 *  file.
 */
package com.cts.test;

import java.io.*;
import java.util.*;

public class WriteProperty {
	String str, key, val;

	public static void main(String[] args) {
		WriteProperty w = new WriteProperty();
	}

	public WriteProperty() {
		try {
			int check = 0;
			while (check == 0) {
				check = 1;
				BufferedReader bf = new BufferedReader(new InputStreamReader(
						System.in));
				System.out
						.println("Enter file name which has properties extension:");
				str = bf.readLine();
				Properties pro = new Properties();
				File f = new File(str + ".properties");
				if (!f.exists()) {
					check = 0;
					System.out.println("File not found!");
				} else {
					FileInputStream in = new FileInputStream(f);
					pro.load(in);
					System.out.print("Enter Key : ");
					key = bf.readLine();
					System.out.print("Enter Value : ");
					val = bf.readLine();
					pro.setProperty(key, val);
					pro.store(new FileOutputStream(str + ".properties"), null);
					System.out.println("Operation completly successfuly!");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
