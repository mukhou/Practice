package test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteListToFile {

	public static void writeFile() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		try {
			//File file2 = new File("write.txt");
			PrintWriter pw = new PrintWriter(new FileWriter("write.txt"));
			for (Integer x : list) {
				pw.println(x.toString());
				pw.flush();
				
			}
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		writeFile();

	}

}
