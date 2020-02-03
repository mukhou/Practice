package byteBybyte;

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
	public static String reverseString(String x){

		if((x == null) || (x.length() <= 1)){
			return x;
		}
		
		return reverseString(x.substring(1))+ x.charAt(0);
	}
	
	// By Iteration
	public static String stringReverse(String x){
		StringBuilder str = new StringBuilder();
		for(int i = x.length()-1; i >= 0; i--){
			str.append(x.charAt(i));
			//str = str + x.charAt(i);
		}
		return str.toString();
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
		//s = rv.reverseString("abcd");
        //System.out.println(System.currentTimeMillis() - start);
		//s = reverseStringWithoutTemp("urmi");
		/*System.out.println(s);
        s = reverse("abcd");
        System.out.println(s);
		System.out.println(stringReverse("abcd"));*/
		System.out.println(reverseString("urmi"));
		
		
		
		
		
		
	}

}
