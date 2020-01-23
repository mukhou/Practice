package byteBybyte;

public class DecimalToBinary {

	public static void convertToBinary(int num){
		int binary[] = new int[40];
		int index = 0;
		while(num > 0){
			binary[index++] = num % 2;
			num = num/2;
			//index++;
		}

		for(int i = index; i >= 0; i --){
			System.out.print(binary[i]);
		}
	}
	
	public static void main(String[] args) {
		convertToBinary(4);

	}

}
