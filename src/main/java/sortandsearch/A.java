/* 
User: Urmi
Date: 12/25/2019 
Time: 7:07 PM
*/

package sortandsearch;

import java.util.ArrayList;

public class A {

    private ArrayList<Integer> list;

    A(ArrayList<Integer> items){
        list = items;
        for (int i = list.size() / 2 ; i >= 0; i--)
            minHeapify(list, list.size(), i);
    }


    private void minHeapify(ArrayList<Integer> list, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = -1;

        // find the smallest key between current node and its children.
        if (left <= list.size() - 1 && list.get(left) < list.get(i)) {
            smallest = left;
        }else {
            smallest = i;
        }

        if (right <= list.size() - 1 && list.get(right) < list.get(smallest)) {
            smallest = right;
        }

        // if the smallest key is not the current key then bubble-down it.
        if (smallest != i) {

            swap(list, i, smallest);
            minHeapify(list, list.size(), smallest);
        }
    }

    private void swap(ArrayList<Integer> list, int i, int smallest) {

        int temp = list.get(smallest);
        list.set(smallest, list.get(i));
        list.set(i, temp);
    }

    private int extractMin(ArrayList<Integer> list){
        if(list.size() == 0){
            throw new IllegalStateException("EMpty list");
        }
        if (list.size() == 1){
            return list.remove(0);
        }

        int min = list.get(0);
        int last = list.remove(list.size() - 1);
        list.set(0, last);
        minHeapify(list, list.size(), 0);
        return min;
    }
    public static void main(String args[]) {

        int arr[] = {12, 11, 13, 5, 26, 7};
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : arr) {
            list.add(i);
        }
        A a = new A(list);
        System.out.println(list);
    }
}
