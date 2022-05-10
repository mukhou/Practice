package collectionsandstring;


public class ArrayCopyExample {
	
	
	public void copySecondHalfOfArray(int arr[]) {
				
		// the new array
		if (arr.length % 2 == 0) {
			int[] array2 = new int[arr.length / 2];

			// copy content into the second array
			System.arraycopy(arr, arr.length / 2, array2, 0, array2.length);

			// print the array
			for (int i = 0; i < array2.length; i++) {
				System.out.println(array2[i]);
			}
		} else {
			// the new array
			int[] array2 = new int[arr.length / 2 + 1];

			// copy content into the second array
			System.arraycopy(arr, arr.length / 2, array2, 0, array2.length);			

			// print the array
			for (int i = 0; i < array2.length; i++) {
				System.out.println(array2[i]);
			}

		}
	}
	
	public void copyFirstHalfOfArray(int arr[]) {
		if (arr.length % 2 == 0) {
			// the new array
			int[] array2 = new int[arr.length / 2];

			// copy content into the second array
			System.arraycopy(arr, 0, array2, 0, array2.length);

			// print the array
			for (int i = 0; i < array2.length; i++) {
				System.out.println(array2[i]);
			}
		} else {
			int[] array2 = new int[arr.length / 2 + 1];

			// copy content into the second array
			System.arraycopy(arr, 0, array2, 0, array2.length);

			// print the array
			for (int i = 0; i < array2.length; i++) {
				System.out.println(array2[i]);
			}

		}
	}
	public static void main(String[] args) {
		
		ArrayCopyExample example = new ArrayCopyExample();
		int[] x = new int[]{1, 2, 3, 4, 5, 6, 7};
		example.copySecondHalfOfArray(x);
		//example.copyFirstHalfOfArray(x);
		

	}

}
