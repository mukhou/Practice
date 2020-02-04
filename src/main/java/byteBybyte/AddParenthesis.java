/* 
User: Urmi
Date: 1/10/2020 
Time: 8:40 AM
*/

/**
 * Given an unbalanced bracket sequence of ‘(‘ and ‘)’, convert it into a balanced sequence by adding the minimum number
 * of ‘(‘ at the beginning of the string and ‘)’ at the end of the string.
 */
package byteBybyte;

//https://www.geeksforgeeks.org/convert-an-unbalanced-bracket-sequence-to-a-balanced-sequence/
//Algorithm
//Let us assume that whenever we encounter with opening bracket the depth increases by one and with a closing bracket the depth decreases by one.
//Find the maximum negative depth in minDep and addCharacter that number of ‘(‘ at the beginning.
//Then loop the new sequence to find the number of ‘)’s needed at the end of the string and addCharacter them.
//Finally, return the string.
public class AddParenthesis {
    private static String solution(String str) {
        int count = 0, minCount = 0;
        //look for missing opening braces
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                count++;
            }else {
                count--;
            }
            minCount = Math.min(minCount, count);
        }
        //addCharacter opening braces to the beginning
        if(minCount < 0){
            while (minCount != 0){
                str = '(' + str;
                minCount ++;
            }
        }

        count = 0;
        //look for missing closing braces by checking count of opening and closing braces: if none, count will be 0
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                count++;
            }else {
                count--;
            }
        }
        if(count != 0){
            while (count > 0){
                str = str + ')';
                count --;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        //System.out.println(solution("><<><"));
        System.out.println(solution("())"));
    }

}
