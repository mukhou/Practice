/* 
User: Urmi
Date: 12/25/2019 
Time: 6:09 PM
*/

package sortandsearch;

import java.util.ArrayList;
import java.util.List;

public class HeapSortWithMinHeapify {
    public void sort(int[] arr)
    {
        int n = arr.length;

        // Build heap (rearrange array)
        //n / 2 to 0
        buildMinHeap(arr, n);

        // One by one extract an element from heap
        //IMP: THIS LOOP SORTS THE ARRAY IN DESCENDING ORDER
        /*for (int i = arr.length - 1; i >= 0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max minHeapify on the reduced heap
            minHeapify(arr, i, 0);
        }*/
    }

    private void buildMinHeap(int[] arr, int n) {
        for(int i = n / 2 - 1; i >= 0; i --){
            minHeapify(arr, n, i);
        }
    }


    // To maxHeapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void minHeapify(int[] arr, int n, int i)
    {
        int smallest = i; // Initialize largest as root
        int l = 2*i; // left = 2*i
        int r = 2*i + 1; // right = 2*i + 1

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        // If largest is not root
        if (smallest != i)
        {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively minHeapify the affected sub-tree
            minHeapify(arr, n, smallest);
        }
    }



    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSortWithMinHeapify ob = new HeapSortWithMinHeapify();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

}
