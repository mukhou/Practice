package arraysandstrings;

public class ConvertStringToInteger {
	
	// preferred approach
	public static int stringToInt(String str){
		int result = 0;
		for(int i = 0; i < str.length(); i++){
			result = (result * 10) + (str.charAt(i) - '0');
			
		}
		return result;
	}
/*
	public static int myStringToInteger(String str) {
	    int result = 0, factor = 1;
	    
	    for (int i = str.length()-1; i >= 0; i--) {
	    	// subtract '0' from the number and get its ASCII value
	    	// the compiler understands this and returns its numeric value
	    	// eg: '8' - '0'= 8
	        result += (str.charAt(i) - '0') * factor;	       
	        //System.out.println(result);
	        factor *= 10;
	    }
	    
	    return result;
	}*/
	
	public static void main(String[] args) {
		//System.out.println(myStringToInteger("523"));
		System.out.println(stringToInt("523"));

	}

}
