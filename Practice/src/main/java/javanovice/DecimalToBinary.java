package javanovice;

public class DecimalToBinary {

	public static void convertToBinary(int num){
		int index = 0;
		int[] binary = new int[25];
		while(num > 0){
			binary[index++] = num % 2;
			num = num / 2;			
		}
		for(int x : binary){
			System.out.print(binary[x]);
		}
	}
	
	public static void main(String[] args) {
		convertToBinary(25);

	}

}
