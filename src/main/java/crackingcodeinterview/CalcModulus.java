package crackingcodeinterview;

public class CalcModulus {

	
	public static void main(String[] args) {
	    System.out.println(modulus(15, 4));
	    System.out.println(3 % 5);

	}

    /**
     * formula:
     * dividend = (divisor * quotient) + remainder
     * remainder = dividend -(divisor * quotient)
     */
	private static int modulus(int a, int b){
	    if(b <= 0){
	        return -1;
        }
        int div = a / b;
	    return a - (div * b);
    }

}
