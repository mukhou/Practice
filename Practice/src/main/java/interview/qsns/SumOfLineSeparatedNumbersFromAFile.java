package interview.qsns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SumOfLineSeparatedNumbersFromAFile {

	public static void main(String[] args) {

		int x = 0;
		String str = "";
		long start = System.currentTimeMillis();

		try {
			File file2 = new File("abcd1.txt");
			PrintWriter pw = new PrintWriter(file2);
			pw.println("2");
			pw.println("3");
			pw.flush();
			pw.close();

			FileReader fr = new FileReader(file2);
			BufferedReader br = new BufferedReader(fr);
			
			while((str = br.readLine()) != null){
				x = x + Integer.parseInt(str);
			}
			System.out.println(x);
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}
}