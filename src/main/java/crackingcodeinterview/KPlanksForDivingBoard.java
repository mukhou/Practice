/* 
User: Urmi
Date: 12/21/2019 
Time: 1:56 PM
*/

/**
 * You are building a diving board by placing a bunch of planks of wood end-to-end.
 * There are two types of planks, one of length shorter and one of length longer. You must use
 * exactly K planks of wood. Write a method to generate ail possible lengths for the diving board.
 */
package crackingcodeinterview;

import java.util.HashSet;
import java.util.Set;

public class KPlanksForDivingBoard {

    //We just need to go through all unique sets
    //of K planks (sets, not orders!}. There are only K ways of picking K planks if we only have two possible types:
    //{0 of type A, K of type 8}, {1 of type A, K - l of type B}, (2 of type A, K-2 of type B},...
    public static Set<Integer> kWays(int k, int shorter, int longer){
        Set<Integer> lengths = new HashSet<>();
        for(int nShorter = 0; nShorter < k; nShorter ++){
            int nLonger = k - nShorter;
            int length = nShorter * shorter + nLonger * longer;
            lengths.add(length);
        }
        return lengths;
    }
}
