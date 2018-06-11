package com.cts.filesandconsole;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CompareTwoTextFiles {
	static int[][] matrix;
	static String[] arr1;
	
	public static void main(String args[]) {
		try {
			 matrix = new int[3][3];
			 arr1 = new String[3];
			BufferedReader br = new BufferedReader(new FileReader(
					"E:/file1.txt"));
			String str = "";
			for (int i = 0; i < 3; i++) {
				str = br.readLine();
				
				arr1[i] = (str.split(",")[1]);
				
			}
			System.out.println(Arrays.toString(arr1));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
