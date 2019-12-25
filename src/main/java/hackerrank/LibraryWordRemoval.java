package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 9/7/15
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryWordRemoval {

    private static List<String> printCombinations(String instr, StringBuilder outstr, int index) {
        List<String> list = new ArrayList<>();
        for (int i = index; i < instr.length(); i++) {
            // append and print
            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            list.add(outstr.toString());
            printCombinations(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
        System.out.println(list);
        return list;
    }

    public static void removeLetter(String[] w){
        List<String> finalList = new ArrayList<>();
        int count = 0        ;
        for(String s : w){
            finalList = printCombinations(s, new StringBuilder(), 0);
            for(String word : finalList){
                int index = Arrays.binarySearch(w, word);
                if (index == 0){
                    count ++;
                }

            }
            System.out.println(count);
        }


    }
}
