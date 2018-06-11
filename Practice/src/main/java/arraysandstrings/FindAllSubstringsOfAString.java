package arraysandstrings;


import java.util.ArrayList;
import java.util.List;

public class FindAllSubstringsOfAString {
	//initial call: new StringBuffer(), 0
	private static void printCombinations(String instr, StringBuffer outstr, int index) {
		for (int i = index; i < instr.length(); i++) {
			// append and print
			outstr.append(instr.charAt(i));
			System.out.println(outstr);
			printCombinations(instr, outstr, i + 1);
			outstr.deleteCharAt(outstr.length() - 1);
		}


	}

	public static void main(String[] args) {
		System.out.println("Substrings of \"" + "abc" + "\" are :-");

		printCombinations("abc", new StringBuffer(), 0);
		

	}
}
