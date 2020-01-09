package arraysandstrings;


import java.util.HashSet;
import java.util.Set;

public class FindAllSubstringsOfAString {
	//initial call: new StringBuffer(), 0
	private static void printCombinations(String instr, StringBuilder outstr, int index) {
		// ATM: i starts from index
		for (int i = index; i < instr.length(); i++) {
			// append and print
			outstr.append(instr.charAt(i));
			System.out.println(outstr);
			printCombinations(instr, outstr, i + 1);
			outstr.deleteCharAt(outstr.length() - 1);
		}
	}

	//exactly same logic, but creates a result set instead of printing the results in between
	private static Set<String> printCombinationsInSet(String instr, StringBuilder outstr, int index) {
		Set<String> set = new HashSet<>();
		for (int i = index; i < instr.length(); i++) {
			// append and print
			outstr.append(instr.charAt(i));
			set.add(outstr.toString());
			//recursive call
			set.addAll(printCombinationsInSet(instr, outstr, i + 1));
			outstr.deleteCharAt(outstr.length() - 1);
		}
		return set;
	}

	public static void main(String[] args) {
		System.out.println("Substrings of \"" + "zzzz" + "\" are :-");

		printCombinations("zzzyz", new StringBuilder(), 0);
		System.out.println(printCombinationsInSet("zzzz", new StringBuilder(), 0));


	}
}
