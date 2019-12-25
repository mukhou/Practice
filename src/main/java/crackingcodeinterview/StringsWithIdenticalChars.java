package crackingcodeinterview;

/**WAP to check if two strings are anagrams or not.
 * two words with the same character counts—to implement
 * this algorithm. We simply iterate through this code, counting how many times each character appears.
 * Then, afterwards, we compare the two arrays.
 */
public class StringsWithIdenticalChars {

    private static boolean identicalChars(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] letters = new int[128];//assumption ASCII chars
        char[] arr = s1.toCharArray();
        for(char c : arr){
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