package crackingcodeinterview;

/**
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class IsStringRotation {

    /**
     * Algorithm:
     * 1. Check if length(s1) == length(s2). If not, return false.
     * 2. Else, concatenate s1 with itself and see whether s2 is substring of the result.
     * input: s1 = apple, s2 = pleap ==> apple is a substring of pleappleap
     * input: s1 = apple, s2 = ppale ==> apple is not a substring of ppaleppale
     */
    private static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        String s1s1 = s1 + s1;
        return s1s1.indexOf(s2) >= 0 ? true : false;
    }
    public static void main(String[] args) {
        System.out.println(isRotation("urmi", "iurm"));

    }

}
