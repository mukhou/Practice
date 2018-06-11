package bloomberg;

import java.util.ArrayList;
import java.util.List;

/**
 * this is a Morgan Stanley final round question
 * Given a string "9899101102" find the missing numbers in this sequence (it is 100 in this case)
 * All numbers are less than 1000
 */

public class FindMissingNumber {
    public static void main(String[] args){
        String str = "9899101102";
        int count = 3, start = 0;
        List<Integer> list = new ArrayList<>();
        findPattern(str, list, start, count);
        System.out.println(list);
        if(list.get(1) - list.get(0) > 1){
            System.out.println("Wrong pattern");
        }
    }

    private static void findPattern(String str, List<Integer> list, int start, int count) {
        for(int i = 0; i < str.length(); i += count){
            start = i;
            int end = start + count;
            
            String temp = str.substring(start, end);
            System.out.println(temp);
            list.add(Integer.valueOf(temp));
            /*if(list.size() == 2){
                break;
            }*/
        }

    }


}
