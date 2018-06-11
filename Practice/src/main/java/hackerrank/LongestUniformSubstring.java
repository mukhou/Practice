package hackerrank;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 2/3/18
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */

//From coderpad
public class LongestUniformSubstring {

    //backward comparison - so index starts with 1
    public static int[] LongestUniformSubstring(String str){
        //initialize
        int longestStart = -1;
        int longestLength = 0;
        int index = 1;
        int length = str.length();

        //ATM: 2 while loops BOTH ON LENGTH CHECK CONDITION
        while(index < length){// LENGTH CHECK 1
            //initialize start for each iteration
            int start = index - 1;//initialize start to 0
            int lengthSoFar = 1;// initialize lengthSoFar = 1(as we are starting from the 1st index(second character)

            while(index < length && str.charAt(index) == str.charAt(index - 1)){// LENGTH CHECK 2
                index ++;
                lengthSoFar ++;
            }

            //assign max length and max start
            if(lengthSoFar > longestLength){
                longestLength = lengthSoFar;
                //reset start
                longestStart = start;
            }
            index ++;
        }
        return new int[]{longestLength, longestStart};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(LongestUniformSubstring("abbccc")));

    }
}
