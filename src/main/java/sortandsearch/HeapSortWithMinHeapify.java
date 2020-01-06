/* 
User: Urmi
Date: 12/25/2019 
Time: 6:09 PM
*/

package sortandsearch;

import java.util.Arrays;

//THIS HAS LOGIC FOR THE FOLLOWING TWO THINGS:
//1. HEAPSORT USING MIN HEAPS
//2. FIND KTH LARGEST INTEGER IN ARRAY which can be done in the following two ways:
// a) run Heapsort and return arr[k - 1] : O(n log n)
// b) run buildminheap and run extractMin k times: O(n) + O(log n) -- BETTER COMPLEXITY
public class HeapSortWithMinHeapify {
    public void sort(int[] arr)
    {
        int n = arr.length;

        // Build heap (rearrange array)
        //n / 2 to 0
        buildMinHeap(arr, n);

        // One by one extract an element from heap
        //IMP: THIS LOOP SORTS THE ARRAY IN DESCENDING ORDER
        for (int heapSize = arr.length - 1; heapSize >= 0; heapSize--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[heapSize];
            arr[heapSize] = temp;

            // call min minHeapify on the reduced heap with heapSize and 0
            minHeapify(arr, heapSize, 0);
        }
    }

    private void buildMinHeap(int[] arr, int n) {
        for(int i = n / 2 - 1; i >= 0; i --){
            minHeapify(arr, n, i);
        }
    }


    // To minHeapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void minHeapify(int[] arr, int n, int i)
    {
        int smallest = i; // Initialize smallest as root
        int l = 2*i; // left = 2*i
        int r = 2*i + 1; // right = 2*i + 1

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        // If largest is not root
        if (smallest != i){
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively minHeapify the affected sub-tree
            minHeapify(arr, n, smallest);
        }
    }

    static int extractMin(int[] arr, int heapSize){
        if(heapSize == 0){
            return -1;
        }

        //get min
        int root = arr[0];
        if(heapSize > 1){
            //replace min with last
            arr[0] = arr[heapSize - 1];
            minHeapify(arr, heapSize, 0);
        }
        heapSize --;
        return root;

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
        int arr[] = {12, 11, 13, 5, 26, 47, 36};
        HeapSortWithMinHeapify ob = new HeapSortWithMinHeapify();
        ob.sort(arr);
        int k = 3;
        System.out.println("kth largest integer is " + arr[k - 1]);

        //FIND KTH LARGEST NUMBER USING MINHEAP AND EXTRACTMIN
        /*ob.buildMinHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        int value = 0;
        while(k != 0){
            value = extractMin(arr, arr.length);
            k--;
        }
        System.out.println("kth smallest integer is " + value);*/
        System.out.println("Sorted array is");
        printArray(arr);
    }

}
