package interview.qsns;

public class Palindrome2 {
	
	public boolean palindrome(String str) throws NullPointerException{
		boolean b = false;
		// use two variables
		for(int i = str.length()-1, j=0; i>=0; i--, j++){
			if(Character.toString(str.charAt(i)).
					equals(Character.toString(str.charAt(j)))){
				if(i==j){
					b = true;
					break;
				}
				//continue;
			}else{
				b = false;
				break;
			}
		}
		return b;
	}

	public static boolean palindrome(long n){
		boolean b = false;
		// use two variables
		String str = String.valueOf(n);
		for(int i = str.length()-1, j=0; i>=0; i--, j++){
			if(Character.toString(str.charAt(i)).
					equals(Character.toString(str.charAt(j)))){
				if(i==j){
					b = true;
					break;
				}
				//continue;
			}else{
				b = false;
				break;
			}
		}
		return b;
	}


	public static void main(String[] args) {
		
		Palindrome2 pal = new Palindrome2();
		System.out.println(pal.palindrome(12345654321l));
		
		
	}

}
