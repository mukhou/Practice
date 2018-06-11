package arraysandstrings;

public class RemoveCommaFromString {

	
	public static void main(String[] args) {
		String str = "345,000,000";		
		str = str.replaceAll(",", "");
		System.out.println(str);

	}

}
