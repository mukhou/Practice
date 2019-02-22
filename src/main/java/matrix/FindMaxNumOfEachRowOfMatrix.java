package matrix;

public class FindMaxNumOfEachRowOfMatrix {

	public static void findMaxOfRow(int[][] data) {
		for (int row = 0; row < data.length; row++){

			// initialize max as the col[0] value of each row
			int max = data[row][0];
			//int col = data[0].length;

			// start searching from the col[1] value
			for (int col = 1; col < data[row].length; col++) {

				if (data[row][col] > max)

					max = data[row][col];

			}

			System.out.println("Maximum in row[" + row + "]: " + max);

		}
	}

	public static void main(String[] args) {
		int a[][]= {
				{5, 2, 3},
                {4, 5, 6},
                {7, 8, 9}                
                };
		findMaxOfRow(a);

	}

}
