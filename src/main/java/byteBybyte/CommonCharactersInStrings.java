/* 
User: Urmi
Date: 1/17/2020 
Time: 3:56 PM
*/

/**
 * WAP to return the common characters between two strings
 */
package byteBybyte;

public class CommonCharactersInStrings {
    private static String common(String str1, String str2){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str1.length(); i++){
            char c = str1.charAt(i);
            int index = str2.indexOf(c);
            if(index != -1){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(common("urmi", "rini"));
    }
}
