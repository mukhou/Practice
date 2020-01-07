/* 
User: Urmi
Date: 1/6/2020 
Time: 6:39 PM
*/

/**
 * Design a data structure that supports the following operations in Θ(1) time:
 * insert(x): Inserts an item x to the data structure if not already present.
 * remove(x): Removes an item x from the data structure if present.
 *search(x): Searches an item x in the data structure.
 * getRandom(): Returns a random element from current set of elements
 *
 * ALGORITHM:
 * Use arraylist and map to achieve this.
 */
package byteBybyte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

//https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
public class ConstantTimeDataStructure {

    private ArrayList<Integer> list;
    private Map<Integer, Integer> map;

    public ConstantTimeDataStructure(ArrayList<Integer> list, Map<Integer, Integer> map) {
        this.list = list;
        this.map = map;
    }

    /**
     * 1) Check if x is already present by doing a hash map lookup.
     * 2) If not present, then insert it at the end of the array.
     * 3) Add in the hash table also, x is added as key and last array index as the index.
     */
    private void insert(Integer x){
        if(map.get(x) != null){
            return;
        }
        list.add(x);
        int size = list.size();
        //the value and its index in the list
        map.put(x, size - 1);
    }

    /**
     * 1) Check if x is present by doing a hash map lookup.
     * 2) If present, then find its index and remove it from a hash map.
     * 3) Swap the last element with this element in an array and remove the last element.
     *    Swapping is done because the last element can be removed in O(1) time.
     * 4) Update index of the last element in a hash map.
     */
    private void remove(Integer x){
        Integer index = map.get(x);
        if(index == null){
            return;
        }
        map.remove(x);

        // Swap element with last element so that remove from
        // arr[] can be done in O(1) time
        int size = list.size();
        int last = list.get(size - 1);
        Collections.swap(list, index, size - 1);

        // Remove last element (This is O(1))
        list.remove(size - 1);
        // Update hash table for new index of last element

        map.put(last, index);
    }

    private Integer search(Integer x){
        return map.get(x);
    }

    // Returns a random element from MyDS
    int getRandom(){
        // Find a random index from 0 to size - 1
        Random rand = new Random();  // Choose a different seed
        int index = rand.nextInt(list.size());

        // Return element at randomly picked index
        return list.get(index);
    }

}
