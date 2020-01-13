package crackingcodeinterview;

/**WAP to check if two strings are anagrams or not.
 * two words with the same character counts
 * To implement this algorithm, we simply iterate through this code, counting how many times each character appears.
 * Then, afterwards, we compare the two arrays.
 */
//Alternate question: check if two strings are anagrams
public class StringsWithIdenticalChars {

    //PREFERRED APPROACH - use StringBuilder
    public static boolean checkAnagram1(String first, String second) {
        char[] firstChars = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
        for (char ch : firstChars) {
            int index = sbSecond.indexOf("" + ch);
            if (index != -1) {
                sbSecond.deleteCharAt(index);
            } else {
                return false;
            }
        }
        System.out.println(sbSecond.length() == 0 ? true : false);
        return sbSecond.length() == 0 ? true : false;
    }

    private static boolean identicalChars(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        int[] letters = new int[128];//assumption ASCII chars

        for(char c : s1.toCharArray()){
            letters[c]++;
        }
        for(int i = 0; i < s2.length(); i++){
            int c = (int)s2.charAt(i);
            letters[c] --;
            if(letters[c]  < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(identicalChars("urmi", "rini"));
    }

}
