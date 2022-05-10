package arraysandstrings;

public class RemoveCharsFromString {

	public static void removeString(String str, char a, char k) {
		StringBuilder sb = new StringBuilder(str);
		for(int x = 0; x < sb.length(); x ++){
			if(sb.charAt(x) == a || sb.charAt(x) == k){
				sb.deleteCharAt(x);
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		removeString("abicdeffi", 'a', 'i');

	}

}
