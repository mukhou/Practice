package byteBybyte;

public class Palindrome2 {
	
	public boolean palindrome(String str) throws NullPointerException{
		int i = 0, n = str.length() - 1;
		while(i < n){
			if(str.charAt(i) != str.charAt(n)){
				return false;
			}
			//check for next pair
			i ++;
			n --;
		}
		return true;


	}



	public static void main(String[] args) {
		
		Palindrome2 pal = new Palindrome2();
		System.out.println(pal.palindrome("basab"));
		
		
	}

}
