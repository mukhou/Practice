package interview.qsns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SumOfNumbersFromAFile {

	public static void main(String[] args) {

		int x = 0;
		
		try {
			File file2 = new File("abhi1.txt");
			FileWriter writer = new FileWriter(file2);
			writer.write("12345");
			writer.flush();
			writer.close();

			FileReader reader = new FileReader(file2);
			BufferedReader br = new BufferedReader(reader);
			String str = br.readLine();
			for (int i = 0; i <= str.length() - 1; i++) {
				x = x + Integer.parseInt(Character.toString(str.charAt(i)));
			}
			System.out.println(x);
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
