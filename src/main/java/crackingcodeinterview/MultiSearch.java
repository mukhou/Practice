/* 
User: Urmi
Date: 12/26/2019 
Time: 12:37 PM
*/

/**
 * Multi Search: Given a string b and an array of smaller strings T, design a method to search b for
 * each small string in T.
 */
package crackingcodeinterview;

import crackingcodeinterview.datastructures.Trie1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CTCI pg 590
public class MultiSearch {

    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "mississippi"};
        Map<String, List<Integer>> locations = searchAll(big, smalls);
        System.out.println(locations.toString());
    }

    //0 ( b ^ 2 ) time to create the tree and 0 ( k t ) time to search for the locations.
    //k is the length of the longest string in T, b is the length of the bigger string, and t is
    //the number of smaller strings within T.
    private static Map<String,List<Integer>> searchAll(String big, String[] smalls) {
        Map<String, List<Integer>> map = new HashMap<>();

        Trie1 trie1 = Trie1.createTrieFromString(big);
        for(String s : smalls){
            /* Get terminating location of each occurrence.*/
            ArrayList<Integer> locations = trie1.search(s);

            /* Adjust to starting location. */
            subtractValue(locations, s.length());

            /* Insert. */
            map.put(s, locations);
        }
        return map;

    }

    private static void subtractValue(ArrayList<Integer> locations, int delta) {
        if(locations == null){
            return;
        }
        for(int i = 0; i < locations.size(); i++){
            locations.set(i, locations.get(i) - delta);
        }
    }
}
