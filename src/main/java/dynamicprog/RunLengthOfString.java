/* 
User: Urmi
Date: 11/19/2021 
Time: 2:36 PM
*/

package dynamicprog;

//GS interview
public class RunLengthOfString {

    public static String runLength(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
                count ++;
                i ++;
            }
            sb.append(str.charAt(i));
            sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(runLength("aaabccab"));
    }
}
