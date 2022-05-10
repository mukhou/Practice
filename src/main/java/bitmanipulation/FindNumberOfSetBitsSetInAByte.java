package bitmanipulation;

public class FindNumberOfSetBitsSetInAByte {

	
	// preferred approach
	public static void findSet(byte value){
		int count = 0;
		while (value > 0) { // until all bits are zero
		if ((value & 1) == 1) // check lower bit
		count++;
		value >>= 1; // shift bits, removing lower bit
		
		}
		System.out.println(count);
	}
	
	
	public static void findSetBitsInByte(byte value){
		int count = 0;
		int x = value;
		while(x > 0){
			
			if(x % 2 == 1){
				count = count + 1;
			}
			x = x / 2;
			
		}
		System.out.println(count);
	}
	
	
	public static void main(String[] args) {
		
		findSet((byte) 15);
		//findSetBitsInByte((byte)18);
		/*Integer i=5;
	    Byte b = Byte.valueOf(i+""); //converts i to String and calls Byte.valueOf()
	    System.out.println(b);
	    System.out.println(Integer.valueOf(b));*/
		//System.out.println((byte) 128);
		
		
		

	}

}
