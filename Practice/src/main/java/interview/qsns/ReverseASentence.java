package interview.qsns;

import java.util.HashSet;

public class ReverseASentence {

	
	public static void main(String[] args) {
		
		String testString = "The car is red";
		String [] token = testString.split(" ");
		//String s = "";
		StringBuffer sb = new StringBuffer();
		for(int i = token.length-1; i>=0; i--){			
			//s = s + token[i] + " ";
			sb.append(token[i]).append(" ");
		}
		
		
		System.out.println(sb);


	}

}
