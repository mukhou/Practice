package goldmansachs;

public class ReverseSentenceAndString {

	
	public static void main(String[] args) {
		String testString = "The car is red";
		// spit the string
		String [] token = testString.split(" ");
		StringBuilder result = new StringBuilder();	
		// start from the end to reverse the sentence
		for(int i = token.length-1; i>=0; i--){
			StringBuilder sb = new StringBuilder(token[i]);			
			sb.reverse();
			result.append(sb).append(" ");
		}
		System.out.println(result);

	}

}
