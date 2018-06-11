package arraysandstrings;

public class ConvertIntegerToString {

	public static void integerToString(int num){
		StringBuilder sb = new StringBuilder();
		int temp;
		while(num > 0){
			temp = num % 10;
			// add '0' to the number and get its ASCII value
			// then cast it to a char
			sb.append((char)(temp + '0'));
			num /= 10;
		}
		System.out.println(sb.reverse().toString());
	}
	
	public static void main(String[] args) {
		integerToString(523);
		//System.out.println((char)(8 + '0'));

	}

}
