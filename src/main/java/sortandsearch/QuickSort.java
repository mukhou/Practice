package sortandsearch;

/**
 * Time complexity:
 *  Best: Ω(n log(n))
 *  Average: θ(n log(n))
 *  Worst: O(n^2)
 */
public class QuickSort {
	
	
	public static void swap (int A[], int x, int y)
	   {
	      int temp = A[x];
	      A[x] = A[y];
	      A[y] = temp;
	   }
	
	// preferred approach: Cormen method - pivot as last element
	   public static int create_partition(int[] A, int p, int r){
		   int x = A[r];//pivot element
		   int j = p - 1;
		   
		   // traverse till r - 1, since A[r] is the pivot
		   for(int i = p; i < r ; i++){
			   if(A[i] <= x){
				   j = j + 1;
				   swap(A, j, i);
			   }
		   }//for loop ends
		   // swap the pivot
		   swap(A, j + 1, r);

		   //return pivit
		   return j + 1;
	   }

	public static int create_partition_left(int[] A, int p, int r){
		int x = A[p];//pivot element
		int j = r + 1;


		// traverse till r - 1, since A[r] is the pivot
		for(int i = p; i < r ; i++){
			if(A[i] <= x){
				j = j + 1;
				swap(A, j, i);
			}
		}//for loop ends
		// swap the pivot
		swap(A, j + 1, r);

		return j + 1;
	}

	public static void Quicksort(int A[], int p, int r)	   {
	      if (p >= r) return;
	      int pivot = create_partition(A, p, r);
	      Quicksort(A, p, pivot - 1);
	      Quicksort(A, pivot + 1, r);
	   }

	   // Usage: java QuickSort [integer] ...
	   // All integers must be distinct
	   public static void main(String args[])
	   {
	      //int A[] = {6, 2, 15, 3, 45, 12, 34, 56, 23, 9, 10, 72, 4};
           int[] A = {2,8,7,1,4};
	      
	      
	      Quicksort(A, 0, A.length - 1 );

	      for (int i=0 ; i < A.length ; i++) System.out.print(A[i] + " ");
	      System.out.println();
	   }
}
