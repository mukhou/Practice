package hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 */
public class NumberNeeded {
    public static int numberNeeded(String first, String second) {
         Map<Character, Integer> m1 = Utils.stringToHashMap(first.toCharArray());
        Map<Character, Integer> m2 = Utils.stringToHashMap(second.toCharArray());

        int difference = 0;
        for(Character c : m1.keySet()){
            if(m2.containsKey(c)){
                difference += Math.abs(m1.get(c) - m2.get(c));
                //IMP: remove keys which are already compared so as to mark them
                // for not being counted later
                m2.remove(c);
            }else {
                difference += m1.get(c);
            }
        }

        //now all left in m2 are the unmarked keys present only present in m2,
        // all of whose VALUES need to be removed
        //old way
        /*for(Integer i : m2.values()){
            difference += i;
        }*/
        //new java way
        difference += m2.values().stream().reduce(Integer::sum).get();

        return difference;

    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //fcrxzwscanmligyxyvym jxwtrhvujlmrpdoqbisbwhmgpmeoke
        String a = "mccbd";
        String b = "cnccde";
        /*String a = "abc";
        String b = "cde";*/

        System.out.println(numberNeeded(a, b));
    }

}
