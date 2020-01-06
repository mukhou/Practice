package sortandsearch;

import java.util.Arrays;

public class MergeSort {

    void merge(int arr[], int left, int mid, int right){

        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[mid + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r){
        if (l < r)
        {
            // Find the middle point
            int mid = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, mid);
            sort(arr , mid+1, r);

            // Merge the sorted halves
            merge(arr, l, mid, r);
        }
    }

    public static void main(String args[]){
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");


        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array" + Arrays.toString(arr));

    }

}
