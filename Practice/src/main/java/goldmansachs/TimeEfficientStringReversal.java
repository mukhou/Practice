package goldmansachs;

// very good solution
// http://www.careercup.com/question?id=13083661
public class TimeEfficientStringReversal {

	public static String reverse(String str) {
        char[] arr = str.toCharArray();
        // IMPORTANT: arr.length - 1
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
	
	public static void main(String[] args) {
		System.out.println(reverse("abcd"));

	}

}
