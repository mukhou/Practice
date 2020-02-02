package byteBybyte;

public class ReverseANumber {

	// VERY NICE APPROACH
	public static int reverseNumber(int number){
        
        int reverse = 0;
        while(number != 0){
            //multiply by 10 to keep shifting the decimal places
            reverse = (reverse * 10) + number % 10;
            number /= 10;
        } 
        return reverse;
    }
	public static void main(String[] args) {
	System.out.println(reverseNumber(523));

	}

}
