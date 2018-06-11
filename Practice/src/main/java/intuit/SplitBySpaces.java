package intuit;

public class SplitBySpaces {

	
	public static void main(String[] args) {
		
		String testString = "Real How To";
	    String [] token = testString.split(" ");
	 // output is Real How To (each in separate line)
	    for(int i=0; i<token.length; i++){
	    	System.out.println(token[i]);
	    }
	    
	    
	    
	    // Efficient way to print the tokens
	    // output : [Real, How, To]
	    //System.out.println(java.util.Arrays.toString(testString.split("/")));

	}

}
