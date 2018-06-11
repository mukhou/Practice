package interview.qsns;

import java.util.Set;

public class StringReversal {

    // Time efficient string reversal
    public static String reverse(String str) {

        char[] arr = str.toCharArray();
        // IMPORTANT: arr.length - 1 => last index
        int len = arr.length - 1;
        // find middle index of string
        int middleIndex = len / 2;

        // traverse till middle element
        for (int i = 0; i <= middleIndex; i++) {
            // swap first with last, second with second last..
            char temp = arr[i];
            arr[i] = arr[len - i];
            arr[len - i] = temp;
        }


        return new String(arr);

    }
	
	// By Recursion
	public String reverseString(String x){
		//String str = "";
		//base case


		if((x == null) || (x.length()<=1)){
			return x;
		}
		
		x = reverseString(x.substring(1))+ x.charAt(0);

        return x;
	}
	
	// By Iteration
	public String stringReverse(String x){
		
		String str = "";
		for(int i = x.length()-1; i >= 0; i--){
			str = str + x.charAt(i); 
		}
		return str;
	}
	
	// without using temp variables
	public static String reverseStringWithoutTemp(String str){
		return reverseHelper(str.length() -1 , str.toCharArray());
	}
	private static String reverseHelper(int index, char[] charArray) {		
		return index < 0 ? "" : charArray[index] + reverseHelper(index -1 , charArray); 
	}

	public static void main(String[] args) {
        long start = System.currentTimeMillis();
		StringReversal rv = new StringReversal();
		String s = "";
        System.out.println("abcd");
		//s = rv.reverseString("abcd");
        //System.out.println(System.currentTimeMillis() - start);
		//s = reverseStringWithoutTemp("urmi");
		System.out.println(s);
        s = reverse("abcd");
        System.out.println(s);
		
		
		
		
		
		
	}

}
