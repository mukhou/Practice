package interview.qsns;


public class ReverseEachWordInASentence {

	
	public static void main(String[] args) {
		
		String testString = "The car is red";
		StringBuilder result = new StringBuilder();
		String[] token = testString.split(" ");		
		for(int i = 0; i < token.length; i ++){
			StringBuilder sb = new StringBuilder(token[i]);
			sb.reverse();
			result.append(sb).append(" ");

		}
		
		System.out.println(result);
		
		

	}

}
