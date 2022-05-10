package collectionsandstring;
// Inserts a string Jhini into the space in the given string

public class StringInsertion {
	
	public static void main(String[] args) {
		
		String str = "Urmi Banerjee";
		int index = str.indexOf(' ');
		System.out.println(index);
		// second argument is not 0 based
		String sub1 = str.substring(0, index);
		System.out.println(sub1);
		String sub2 = str.substring(index+1);
		System.out.println(sub2);
		String finalstring = sub1.concat("Jhini").concat(sub2);
		System.out.println(finalstring);
		
	}

}
