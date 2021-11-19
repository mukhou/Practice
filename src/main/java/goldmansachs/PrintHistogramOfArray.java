package goldmansachs;

public class PrintHistogramOfArray {

	
	public static void drawHistrogram(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int temp = arr[i];
			for(int j = 0; j < temp; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		drawHistrogram(new int[]{1, 2, 3, 4, 5, 6 });

	}

}
