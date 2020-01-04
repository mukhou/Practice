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
        int longestStart = -1, longestLength = 0;
        int index = 1;
        //need this variable to keep track of the longest string
        StringBuilder sb = null;

        //ATM: 2 while loops BOTH ON LENGTH CHECK CONDITION
        while(index < str.length()){// LENGTH CHECK 1
            //initialize start for each iteration
            int start = index - 1;//initialize start to the previous index
            int lengthSoFar = 1;// initialize lengthSoFar = 1(as we are starting from the 1st character

            //create string builder every time
            sb = new StringBuilder(Character.toString(str.charAt(start)));

            while(index < str.length() && str.charAt(index) == str.charAt(index - 1)){// LENGTH CHECK 2
                sb.append(str.charAt(index));

                index ++;
                lengthSoFar ++;
            }

            //assign max length and max start
            if(lengthSoFar > longestLength){
                longestLength = lengthSoFar;
                //new start
                longestStart = start;
            }
            //increment index anyway
            index ++;
        }
        System.out.println(sb.toString());
        return new int[]{longestLength, longestStart};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(LongestUniformSubstring("abbccc")));

    }
}
