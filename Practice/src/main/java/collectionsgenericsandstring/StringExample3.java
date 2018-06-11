package collectionsgenericsandstring;

import java.util.Scanner;

public class StringExample3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter word: ");
		String st = input.next();
		for (int i = 0; i <= st.length(); i++) {
			//int j = i + 1;
			System.out.println(st.substring(0, i));
		}
	}

}
