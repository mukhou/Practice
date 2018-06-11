package sortandsearch;

/**
 * https://www.geeksforgeeks.org/heap-sort/
 */

/**
 * We can find k’th smallest element using heaps.
 * A simple optimization is to create a Min Heap of the given n elements and call extractMin() k times.
 * Time complexity of this solution is O(n + kLogn).
 */
public class HeapSort {
    public void heapSort(int arr[])
    {
        int n = arr.length;

        // Build max heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);

        // the actual sorting algo: One by one extract an element from heap
        //starts from n - 1 as n is already largest
        for (int i = n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            maxHeapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void maxHeapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i ;  // left = 2*i + 1
        int r = 2*i + 1;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            maxHeapify(arr, n, largest);
        }
    }


    private void minHeapify(int[] arr, int size, int i) {
        int smallest = i;
        int l = 2*i ;  // left = 2*i + 1
        int r = 2*i + 1;  // right = 2*i + 2

        if(l < size && arr[l] < arr[i] ){
            smallest = l;
        }
        else {
            smallest = i;
        }

        if(r < size && arr[r] < arr[smallest]){
            smallest = r;
        }

        if(smallest != i){
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }

        minHeapify(arr, size, smallest);
    }


    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    int extractMax(int[] arr, int size){
        if(arr.length == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int max = arr[0];
        arr[0] = arr[arr.length - 1];
        size = size - 1;
        maxHeapify(arr, size, 0);
        return max;


    }

    //call it n no. of times to ket nth smallest array from element
    int extractMin(int[] arr, int size){
        if(arr.length == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int min = arr[0];
        arr[0] = arr[arr.length - 1];
        size = size - 1;
        minHeapify(arr, size, 1);
        return min;


    }


    // Driver program
    public static void main(String args[])
    {
        int arr[] = {10, 34, 2, 56, 72, 31};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
