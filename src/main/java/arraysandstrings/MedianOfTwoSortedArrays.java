package arraysandstrings;

public class MedianOfTwoSortedArrays {

	public int findMedianOfTwoSortedArrays(int[] arr1, int[] arr2, int n){
		int m1, m2, finalMedian = 0;
		int[] arrayCopy1 = null;
		int[] arrayCopy2 = null;
		if(n <= 0) finalMedian =  -1;
		
		if(n == 1){
			finalMedian = (arr1[0] + arr2[0]) / 2;
		}
		
		if(n == 2){
			finalMedian = (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
		}
		
		m1 = calcMedian(arr1, n);
		m2 = calcMedian(arr2, n);
		
		if(m1 == m2) return m1;
		if(m1 < m2){ // median lies in the range > m1, < m2
			if(n % 2 == 0){
				arrayCopy1 = new int[n / 2];
				System.arraycopy(arr1, n / 2, arrayCopy1, 0, arrayCopy1.length);
				arrayCopy2 = new int[n / 2];
				System.arraycopy(arr2, 0, arrayCopy2, 0, arrayCopy1.length);
				finalMedian = findMedianOfTwoSortedArrays(arrayCopy1, arrayCopy2, n - n / 2);
			}else{
				arrayCopy1 = new int[n / 2 + 1];
				System.arraycopy(arr1, n / 2, arrayCopy1, 0, arrayCopy1.length);
				arrayCopy2 = new int[n / 2];
				System.arraycopy(arr2, 0, arrayCopy2, 0, arrayCopy1.length);
				finalMedian = findMedianOfTwoSortedArrays(arrayCopy1, arrayCopy2, n - n / 2 + 1);
			}
		}else if(m1 > m2){ // median lies in the range < m1, > m2
			if(n % 2 == 0){
				arrayCopy1 = new int[n / 2];
				System.arraycopy(arr1, 0, arrayCopy1, 0, arrayCopy1.length);
				arrayCopy2 = new int[n / 2];
				System.arraycopy(arr2, n / 2, arrayCopy2, 0, arrayCopy1.length);
				finalMedian = findMedianOfTwoSortedArrays(arrayCopy1, arrayCopy2, n - n / 2);
			}else{
				arrayCopy1 = new int[n / 2 + 1];
				System.arraycopy(arr1, 0, arrayCopy1, 0, arrayCopy1.length);
				arrayCopy2 = new int[n / 2];
				System.arraycopy(arr2, n / 2, arrayCopy2, 0, arrayCopy1.length);
				finalMedian = findMedianOfTwoSortedArrays(arrayCopy1, arrayCopy2, n - n / 2 + 1);
			}
		}
		return finalMedian;
		
		
	}
	
	public int calcMedian(int[] arr,int n){
		if(n % 2 == 0){
			return (arr[n / 2] + arr[(n / 2)+ 1]) / 2;
		}else{
			return arr[n / 2];
		}
	}

	//arr1 length should be smaller than arr2 length
	public double findMedianSortedArrays(int[] arr1, int[] arr2) {
		if(arr1.length > arr2.length){
			return findMedianSortedArrays(arr2, arr1);
		}

		int x = arr1.length;
		int y = arr2.length;

		int low = 0, high = x;
		while (low <= high){
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX) == 0 ? Integer.MIN_VALUE : arr1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr1[partitionY];

			if(maxLeftX <= minRightY && maxLeftY <= minRightX){
				if((x + y) % 2 == 0){
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				}else {
					return ((double) Math.max(maxLeftX, maxLeftY));
				}
			}else if(maxLeftX > minRightY){
				high = partitionX - 1;
			}else {
				low = partitionX + 1;
			}
		}

		throw new IllegalArgumentException();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
