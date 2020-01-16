package sortandsearch;

/**
 * https://www.geeksforgeeks.org/heap-sort/
 */

/**
 * We can find k’th smallest element using heaps.
 * A simple optimization is to create a Min Heap of the given n elements and call extractMin() k times.
 * NOTE: in a max heap, root it the largest and that becomes the last element of the array
 */
//https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
//Time complexity of this solution is O(n + k Log n).
public class HeapSortWithMaxHeapify {
    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        buildMaxHeap(arr, n);

        /**
         * The heapsort algorithm starts by using BUILD-MAX-HEAP to build a max-heap
         * on the input array A[1...n], where n = A:length.
         * Since the maximum element of the array is stored at the root A[1],
         * we can put it into its correct final position by exchanging it with A[n]
         */
        for (int heapSize = n-1; heapSize >= 0; heapSize --)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[heapSize];
            arr[heapSize] = temp;

            // call max minHeapify on the reduced heap
            maxHeapify(arr, heapSize, 0);
        }
    }

    //time complexity: O(n)
    private void buildMaxHeap(int[] arr, int n) {
        for(int i = n / 2 - 1; i >= 0; i --){
            maxHeapify(arr, n, i);
        }
    }

    // To maxHeapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    //time complexity: O(h): h is height of tree
   static void maxHeapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i;
        int r = 2*i + 1;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively maxHeapify the affected sub-tree
            maxHeapify(arr, n, largest);
        }
    }

    //time complexity: O(log n), since it performs only a
    //constant amount of work on top of the O.lg n/ time for MAX-HEAPIFY.
    private static int extractMax(int[] arr, int heapSize){
        if(heapSize == 0){
            return -1;
        }

        //get max
        int root_data = arr[0];
        if(heapSize > 1){
            //replace max with last
            arr[0] = arr[heapSize - 1];
            maxHeapify(arr, heapSize, 0);
        }
        heapSize --;
        return root_data;
    }


    /* A utility function to print array of size n */
    static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 26, 7};

        HeapSortWithMaxHeapify ob = new HeapSortWithMaxHeapify();
        ob.sort(arr);

        /*ob.buildMaxHeap(arr, arr.length);
        int k = 3, value = 0;
        while (k != 0){
            value = extractMax(arr, arr.length);
            k--;
        }

        System.out.println("kth largest integer is " + value);*/


        System.out.println("Sorted array is");
        printArray(arr);
    }
}
