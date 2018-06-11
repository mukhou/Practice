package goldmansachs;

public class FindXOROfTwoNumbers {

	static int  aXORb(int a, int b){
		int temp;
		if(b == 0)
			return 1;
		temp = aXORb(a,b/2);
		if(b % 2 == 0)
			return(temp * temp);
		else {
			// check for -ve values
		     if(b > 1) {
		          return(temp * temp * a);
		     }
		     else {
		          return ((temp * temp)/a);
		     }
		}
	}
	
	public static void main(String[] args) {
		System.out.println(aXORb(1, 2));

	}

}
