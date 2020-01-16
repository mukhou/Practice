/* 
User: Urmi
Date: 1/13/2020 
Time: 4:14 PM
*/

package byteBybyte;

import java.util.List;

public class CompareStringAndChar {

    public static void main(String[] args){
        List<String> list = List.of(",", "!", ":");
        String str = "go!";
        for(String s : list){
            //IMP: NEED TO ADD "" TO CHAR, ELSE THE equals() check fails
            if(list.contains(str.charAt(str.length() - 1) + "")){
                str = str.substring(0, str.length() - 1);
            }
        }
        System.out.println(str);
    }
}
