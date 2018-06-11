package collectionsgenericsandstring;

import java.util.Scanner;

public class InputForGraph {

	public static void input(char i, char j){
		System.out.println(i + j);
	}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter  inputs: ");
		// convert input to string
		String str1 = input.next();
		// add input to char array
		// iterate and get the values for i and j
		char[] characters = str1.toCharArray();
		for(char c : characters){
			System.out.println(c);
		}
		

	}

}
